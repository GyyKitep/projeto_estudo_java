package br.com.projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAula {
	
	public static void main(String[] args) {
		Aula a1 = new Aula("Revisitando as ArrayList", 21);
		Aula a2 = new Aula("Lista de objetos", 20);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
		
		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		System.out.println(aulas);  // se nao definir o metodo tostring neste objeto ele manda a referencia do objeto
		
		Collections.sort(aulas);    //funciona pois implementamos o campore no objeto aula
		
		System.out.println(aulas);
		
		aulas.sort(Comparator.comparing(Aula::getTempo)); // ou Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		
		System.out.println(aulas);
		
		
	}

}
