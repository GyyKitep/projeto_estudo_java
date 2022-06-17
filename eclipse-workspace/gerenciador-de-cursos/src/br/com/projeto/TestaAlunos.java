package br.com.projeto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {
	
	public static void main(String[] args) {
		
		Collection<String> alunos = new HashSet<>(); //ele nao da garantia da sequencia que vc adicionou
											  //nao aceita elementos repitidos
		alunos.add("Geovanny");
		alunos.add("Giovanna");
		alunos.add("Marcos");
		alunos.add("Nicolas");
		alunos.add("Antonio");
		
		System.out.println(alunos.size()); 
		
		for (String aluno : alunos) {
			System.out.println(aluno);
			
		}
				
		System.out.println(alunos);
		
		boolean geovannyEstaMatriculado = alunos.contains("Geovanny");
		
		System.out.println(geovannyEstaMatriculado);
		alunos.remove("Geovanny");
		
		alunos.forEach(aluno ->{
			System.out.println(aluno);
		});		
		
		System.out.println("-----lista------");
		
		List<String> alunosEmLista = new ArrayList<>(alunos);
		
		System.out.println(alunosEmLista.get(2));
		
	}
	
}
