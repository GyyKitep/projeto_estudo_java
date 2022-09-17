package br.com.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.controller.form.AtualizacaoTopicoForm;
import br.com.forum.controller.form.TopicoForm;
import br.com.forum.modelo.Topico;
import br.com.forum.repository.CursoRepository;
import br.com.forum.repository.TopicoRepository;

@RestController   //se usar o restcontroller ele considera que todo metodo é responsebody
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	@Cacheable(value = "listaDeTopicos")
	public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso, 
			@PageableDefault(sort = "id", direction = Direction.DESC) Pageable paginacao){  // para fazer isso precisa habilitar o modulo sping data web support na application
			//@RequestParam int pagina, @RequestParam int qtd, @RequestParam(required = false) String ordencao) {
		
		//Pageable paginacao = PageRequest.of(pagina, qtd, Direction.DESC, ordencao);
		
		Page<Topico> topicos;
		if (nomeCurso == null) {
			topicos = topicoRepository.findAll(paginacao);	
		}else {
			topicos = topicoRepository.findByCurso_Nome(nomeCurso, paginacao);
		}
					
		
		return TopicoDto.converter(topicos);
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries= true)
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);		
		topicoRepository.save(topico);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) {  //o nome da variavel tem que ser o msm do mapping, caso não quiser @PathVariable("id") Long codigo 
		
	    //Topico topico = topicoRepository.getReferenceById(id);
		Optional<Topico> topico = topicoRepository.findById(id);	// para tratar se nao encontrar o id
		
		if  (topico.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
		}
		
		return ResponseEntity.notFound().build();

	}
	
	@PutMapping("/{id}") //@put atualizar tudo @path atualizar algumas coisas
	@Transactional       //jpa gerencia e atualiza sozinho no final da transacao
	@CacheEvict(value = "listaDeTopicos", allEntries= true)
	public ResponseEntity<TopicoDto> atualizar(@PathVariable long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		
		Optional<Topico> optional = topicoRepository.findById(id);
		
		if  (optional.isPresent()) {
			Topico topico = form.atualizar(id, topicoRepository); 
			
			return ResponseEntity.ok(new TopicoDto(topico));
		}
		
		return ResponseEntity.notFound().build();
				
		

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries= true)
	public ResponseEntity<?> remover(@PathVariable long id){
		
		Optional<Topico> optional = topicoRepository.findById(id);
		
		if  (optional.isPresent()) {
			topicoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();		

	}
	
}
