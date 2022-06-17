package br.com.projeto;

import java.util.Iterator;
import java.util.Set;

public class TestaBuscaAlunosNoCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Geovanny");

		javaColecoes.add(new Aula("Trabalhando com ArrayList", 25));
		javaColecoes.add(new Aula("Criando uma Aula", 20));
		javaColecoes.add(new Aula("Modelando com Coleções", 22));
		
		Aluno a1 = new Aluno("Giovanna" , 1);
		Aluno a2 = new Aluno("Marcos", 2);
		Aluno a3 = new Aluno("Nicolas", 3);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Todos os aunos matriculados");
		
		Set<Aluno> alunos = javaColecoes.getAlunos();
		Iterator<Aluno> iterador = alunos.iterator();
		
		System.out.println("---------Iterator---------");
		while(iterador.hasNext()) {
			Aluno proximo = iterador.next();
			System.out.println(proximo);
		}
		System.out.println("---------Iterator---------");
		
		javaColecoes.getAlunos().forEach( a -> {
			System.out.println(a);			
		});
		
		System.out.println("O aluno " + a1 + " esta matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno Marcos = new Aluno("Marcos", 2);
		
		System.out.println("O aluno " + Marcos + " esta matriculado?");
		System.out.println(javaColecoes.estaMatriculado(Marcos));  //se o Aluno fosse uma List na classe Curso ele retornaria true
																   //para funcionar com hashset é preciso reesccrever o metrodo hashcode
		System.out.println("a2 == Marcos");
		System.out.println(a2 == Marcos);
		
		System.out.println("a2 equals Marcos");
		System.out.println(a2.equals(Marcos));  //precisa reescrever o metodo equals para ele funcionar como deseja
		
		// obrigatorioamente o seguinte é true:
		
		System.out.println(a2.hashCode() == Marcos.hashCode());
	}

}
