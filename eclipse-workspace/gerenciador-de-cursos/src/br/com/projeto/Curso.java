package br.com.projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();  //linkedhashset - guarda na ordem que foi adicionada
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	
	public Curso(String nome, String instrutor) {
		super();
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas); // faz com que tenha que usar o metodo da classe para alterar a
													// lista
	}

	public void add(Aula aula) {
		this.aulas.add(aula);
	}

	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	@Override
	public String toString() {
		return "[Curso: " + nome + ", Tempo total: " + this.getTempoTotal() + "," + " Aulas: " + this.getAulas() + "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);		
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos); // faz com que tenha que usar o metodo da classe para alterar a
													// lista
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatricula(int numero) {
		
//		for (Aluno aluno : alunos) {
//			if(aluno.getNumeroMatricula() == numero) {
//				return aluno;
//			}			
//		}		
//		throw new NoSuchElementException("Matricula nao encontrada: " + numero);
		
		if(!matriculaParaAluno.containsKey(numero)) {
			throw new NoSuchElementException();
		}
		
		return matriculaParaAluno.get(numero);
	}
}
