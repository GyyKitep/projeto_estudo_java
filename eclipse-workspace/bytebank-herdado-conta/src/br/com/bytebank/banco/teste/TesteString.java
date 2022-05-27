package br.com.bytebank.banco.teste;

public class TesteString {

	public static void main(String[] args) {
		
		int a = 3;
		String nome = "Alura";  // strings tbm são objetos   // object literal // depois que a string é inicializado ela não pode ser alterada
		//String outro = new String("Alura");
		
	    String vazio = "      Alura      ";   // " " é diferente de ""
		String outroVazio = vazio.trim();
	          
		
		System.out.println(vazio.contains("Alu"));
		System.out.println(vazio.isEmpty());
		System.out.println(outroVazio.isEmpty());
		
		//System.out.println(nome.length());
		
		
		//String sub = nome.substring(1);
		
		//System.out.println(sub);
		
		//int pos = nome.indexOf("ur");
		
		//System.out.println(pos);
		
		//char c = nome.charAt(2);
		
		
		//char c = 'A';
		//char d = 'a';
		//String outra = nome.replace(c, d);
		//String outra = nome.toLowerCase();
		
		//System.out.println(nome);
		//System.out.println(outra);

		//System.out.println(c);
		
	}

}
