package br.com.java.io.teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeitura2 {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(new File("contas.csv"), "UTF-8");
		
		while (scan.hasNextLine()) {
			String linha = scan.nextLine();			
			//System.out.println(linha);	
			
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US); //usa a regra decimal selecionada
			linhaScanner.useDelimiter(",");
			
			String tipoConta = linhaScanner.next();
			int agencia = linhaScanner.nextInt();			
			int numero = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();
												  //%s -> string esta no documentação
			String valorFormatado = String.format(new Locale("pt" , "BR"), "%s - %04d-%08d %20s: %05.2f",
					                                                       tipoConta, agencia , numero, titular, saldo);
			System.out.println(valorFormatado);
			
			linhaScanner.close();
			//String[] valores = linha.split(",");	
			//System.out.println(valores[3]);
			
			
		}
		
		scan.close();
		
	}

}
