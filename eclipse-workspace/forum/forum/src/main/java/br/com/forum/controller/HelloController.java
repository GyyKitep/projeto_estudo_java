package br.com.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/")
	@ResponseBody         // faz com que o spring entenda que o retorno nao e uma pagina
	public String hello() {
		return "Hello World!";
	}
	
}
