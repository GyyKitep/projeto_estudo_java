package br.com.java.io.teste;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TesteEscritaPrintStreamPrintWriter {

	public static void main(String[] args) throws IOException {
		//Fluxo de Entrada com Arquivo
		
//		OutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos); 	
//		BufferedWriter bw = new BufferedWriter(osw);

		//FileWriter fw = new FileWriter("lorem2.txt");
		//BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));			
		//PrintStream ps = new PrintStream(new File("lorem2.txt"));
		
		PrintWriter ps = new PrintWriter("lorem2.txt", "UTF-8");
		
		ps.println("Teste de write no arquivo lorem2");
		ps.println();
		ps.println("Teste de write 2 no arquivo lorem2");
				
		ps.close();
		
		System.out.println();
		
	}

}
