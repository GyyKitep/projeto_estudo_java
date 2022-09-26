package br.com.forum.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.forum.modelo.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest //teste para repository
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //configuração para não usar o banco em memoria
@ActiveProfiles("test") //forca esta classe usar o profile de teste
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repositoy;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("PRogramacao");
		em.persist(html5);
		
		Curso curso = repositoy.findByNome(nomeCurso);
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());
	}	
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstaCadastrado() {
		String nomeCurso = "JPA";
		Curso curso = repositoy.findByNome(nomeCurso);
		Assert.assertNull(curso);
	}

}
