package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Cursos {

	private String nome;
	private int alunos;

	public Cursos(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

}

public class ExemploCrusos {
	public static void main(String[] args) {
		List<Cursos> cursos = new ArrayList<Cursos>();
		cursos.add(new Cursos("Python", 45));
		cursos.add(new Cursos("JavaScript", 150));
		cursos.add(new Cursos("Java 8", 113));
		cursos.add(new Cursos("C", 55));

		cursos.sort(Comparator.comparing(Cursos::getAlunos));

		// cursos.forEach(c -> System.out.println(c.getNome()));
		cursos.stream().filter(c -> c.getAlunos() >= 100).map(Cursos::getAlunos).forEach(System.out::println);

		//int sum = cursos.stream()
		
		OptionalDouble media = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Cursos::getAlunos)
			.average();
		
		System.out.println(media);
		
		//Optional<Cursos> optionalCursos = cursos.stream()
	    //cursos.stream()
			//.filter(c -> c.getAlunos() >= 100)
			//.findAny()
			//.ifPresent(c -> System.out.println(c.getNome()));;
			
	    cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(	        //atualiza a lista stream
					c -> c.getNome(),           //chave 
					c -> c.getAlunos()))        //valor    		
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
	   
	   
		//Cursos curso = optionalCursos.orElse(null); //encontra 1 curso se colocar apenas o get ele retorna uma exeção
		//System.out.println(curso.getNome());

	}
}
