package br.com.projeto;

import java.util.List;

public class TestaCurso {
	
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Geovanny");
		
		javaColecoes.add(new Aula("Trabalhando com ArrayList", 25));
		javaColecoes.add(new Aula("Criando uma Aula", 20));
		javaColecoes.add(new Aula("Modelando com Coleções", 22));
		
		List<Aula> aulas = javaColecoes.getAulas();
		
		System.out.println(javaColecoes.getAulas());
	}

}
