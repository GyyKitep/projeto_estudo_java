package br.com.threads.busca_texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextutal implements Runnable {

	String nomeArquivo;
	String nome;
	
	public TarefaBuscaTextutal(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nome;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(nomeArquivo));
			
			int numeroLinha = 1;			
			
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				
				if (linha.toLowerCase().contains(nome.toLowerCase())) {
					System.out.println(nomeArquivo + " - " + linha + " linha - " + numeroLinha);
					
				}
			
				numeroLinha++;
				
			}
			
			
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
