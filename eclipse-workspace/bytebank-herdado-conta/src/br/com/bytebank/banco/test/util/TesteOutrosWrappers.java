package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {

	public static void main(String[] args) {
		
		Integer idadeRef = Integer.valueOf(29); //criar um objeto apartir do numero primitivo autoboxing 
		
		System.out.println(idadeRef.intValue()); // untoboxing
		
		Double dRef = Double.valueOf(3.2);   // autoboxing 
		System.out.println(dRef.doubleValue());// untoboxing
		
		Boolean bRef = Boolean.FALSE; // constante sempre em letra maiuscula
		System.out.println(bRef.booleanValue());
		
		Number refNumero = Float.valueOf(29.9f);
		
		List<Number> lista = new ArrayList<>();
		
		lista.add(10);
		lista.add(32.6);
		lista.add(32.6f);
	}

}
