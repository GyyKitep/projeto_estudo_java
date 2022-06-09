package br.com.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {

	public static void main(String[] args) throws IOException {
		//Fluxo de Entrada com Arquivo
		
		//arquivo/entrada/fluxo
		InputStream fis = new FileInputStream("lorem.txt"); // checked
		
		Reader isr = new InputStreamReader(fis, "UTF-8"); // transforma os bites e bytes em caracteres do arquivo
		
		BufferedReader br = new BufferedReader(isr);// checked
		String linha = br.readLine(); // metodo do bufferedreader
		
		while(linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		
		
		
		br.close();
		
	}

}
