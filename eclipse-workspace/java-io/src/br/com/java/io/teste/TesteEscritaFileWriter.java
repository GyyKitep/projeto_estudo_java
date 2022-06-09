package br.com.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscritaFileWriter {

	public static void main(String[] args) throws IOException {
		//Fluxo de Entrada com Arquivo
		
//		OutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos); 	
//		BufferedWriter bw = new BufferedWriter(osw);

		//FileWriter fw = new FileWriter("lorem2.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));	
		bw.write("Teste de write no arquivo lorem2");
		//fw.write(System.lineSeparator());
		bw.newLine();
		bw.newLine();
		bw.write("Teste de write 2 no arquivo lorem2");
				
		bw.close();
		
	}

}
