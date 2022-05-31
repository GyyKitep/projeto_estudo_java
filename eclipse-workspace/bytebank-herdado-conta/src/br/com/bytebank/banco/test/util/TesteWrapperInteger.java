package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {

	public static void main(String[] args) {
		
		int[] idades = new int[5];
		String[] nomes = new String[5];
		
		// int  - > java.lang.Integer
		int idade = 29;  //Class integer - ele transforma automaticamente em objeto(Autoboxing)
		//Integer idadeRef = new Integer(29);
		Integer idadeRef = Integer.valueOf(29); //criar um objeto apartir do numero primitivo autoboxing 
		
		System.out.println(idadeRef.doubleValue());
		
		int valor = idadeRef.intValue(); //pede o valor do primitivo unboxing
		
		String s = args[0]; // "12" - para trazer esse 12 precisa passar um parametro na configuracao do run config		
		//Integer numero = Integer.valueOf(s);
		int numero = Integer.parseInt(s);
		System.out.println(numero);
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		//numeros.add(Integer.valueOf(29));
		numeros.add(29); //autoboxing

	}

}
