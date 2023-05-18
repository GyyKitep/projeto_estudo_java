package br.com.threads.banheiro;

public class Banheiro {
	
	public void fazNumero1() {
		System.out.println("entrando no banheiro");
		System.out.println("fazendo coisa rapida");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		System.out.println("dando descarga");
		System.out.println("lavando mão");
		System.out.println("saindo do banheiro");
	}
	
	public void fazNumero2() {
		System.out.println("entrando no banheiro");
		System.out.println("fazendo coisa demorada");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("dando descarga");
		System.out.println("lavando mão");
		System.out.println("saindo do banheiro");
		
	}
}
