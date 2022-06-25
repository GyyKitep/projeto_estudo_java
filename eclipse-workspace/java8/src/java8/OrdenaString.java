package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaString {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();

		palavras.add("Consultor Master Supremo");
		palavras.add("Analista Junior");
		palavras.add("Desenvolvedor");

		
		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		//palavras.sort(Comparator.comparing(s -> s.length()));
		
		palavras.sort(Comparator.comparing(String::length));
		
		System.out.println(palavras);
		
		// interface funcional - é a interface que so tem um metodo
		
		//Function<String, Integer> funcao =s -> s.length();
		Function<String, Integer> funcao = String::length;
		Comparator<String> comparador = Comparator.comparing(funcao);
		System.out.println(comparador);
		
		//Consumer<String> impressor = s -> System.out.println(s);
		Consumer<String> impressor = System.out::println;
		
		//palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);

	}
}