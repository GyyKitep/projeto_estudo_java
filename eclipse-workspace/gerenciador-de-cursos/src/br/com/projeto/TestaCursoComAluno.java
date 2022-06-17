package br.com.projeto;

public class TestaCursoComAluno {

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
		
	    System.out.println("Quem e o aluno com matricula 5617?");
	    Aluno aluno = javaColecoes.buscaMatricula(3);
	    
	    System.out.println("aluno: " + aluno);
	    

	}

}
