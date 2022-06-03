package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TesteInterator {

	public static void main(String[] args) {
		//List<String> nomes = new ArrayList<>();
		Set<String> nomes = new HashSet<>();
		
		nomes.add("Marcos");
		nomes.add("David");
		nomes.add("Geovanny");
		
		Iterator<String> it = nomes.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());				
		}
		
		
		
		
		
		
		
	}
	
	
}
