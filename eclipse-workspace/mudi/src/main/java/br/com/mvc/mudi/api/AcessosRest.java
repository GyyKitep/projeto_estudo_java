package br.com.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mvc.mudi.interceptor.IntercepctadorDeAcessos;
import br.com.mvc.mudi.interceptor.IntercepctadorDeAcessos.Acesso;

@RequestMapping("/api/acessos")
@RestController
public class AcessosRest {
	
	@GetMapping
	public List<Acesso> getAcessos(){
		return IntercepctadorDeAcessos.acessos;
		
	}
	

}
