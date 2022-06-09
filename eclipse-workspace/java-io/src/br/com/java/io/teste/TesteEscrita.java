package br.com.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {
		//Fluxo de Entrada com Arquivo
		
		OutputStream fos = new FileOutputStream("lorem2.txt");
		
		Writer osw = new OutputStreamWriter(fos); 
		
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write("Teste de write no arquivo lorem2");
//		bw.newLine(); pula para a proxima linha
		bw.newLine();
		bw.write("Teste de write 2 no arquivo lorem2");
		
		
		bw.close();
		
	}

}
