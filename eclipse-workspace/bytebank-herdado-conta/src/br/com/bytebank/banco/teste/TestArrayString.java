package br.com.bytebank.banco.teste;

public class TestArrayString {  // para rodar a clase precisa entrar nas pastas e usar br.com.bytebank.banco.teste.TestArrayString ( e parametros se qusier)
							    // na compilação podemos colocar uma configura��o para mandarmos argumentos para a classe
	
	public static void main(String[] args) {
		System.out.println("Funcionou!");
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);;
			
		}
	}
}
