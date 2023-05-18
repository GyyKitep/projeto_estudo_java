package br.com.threads.busca_texto;

public class Pesquisa {
	
	public static void main(String[] args) {
		String nome = "Jef";		
		
		Thread threadAssinaturas1 = new Thread(new TarefaBuscaTextutal("assinaturas1.txt", nome));
		Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextutal("assinaturas2.txt", nome));
		Thread autores = new Thread(new TarefaBuscaTextutal("autores.txt", nome));
		
		threadAssinaturas1.start();
		threadAssinaturas2.start();
		autores.start();
	}

}
