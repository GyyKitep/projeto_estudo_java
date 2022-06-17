package br.com.projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {
	
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as colecoes do Java", "Geovanny");
		
		javaColecoes.add(new Aula("Trabalhando com ArrayList", 25));
		javaColecoes.add(new Aula("Criando uma Aula", 20));
		javaColecoes.add(new Aula("Modelando com Coleções", 22));

		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulas);
		System.out.println(javaColecoes.getTempoTotal());
		
		System.out.println(javaColecoes.toString());
		
		
	}

}
