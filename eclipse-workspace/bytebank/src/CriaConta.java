
public class CriaConta {

	public static void main(String[] args) {
		Conta primeiraConta = new Conta();   //estou instanciando um objeto, transformando a classe em objeto que dentro dela possui seus atributos
		primeiraConta.saldo = 200;
		
		System.out.println(primeiraConta.saldo);
		
		primeiraConta.saldo += 100;
	
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;
		
		System.out.println("primeira conta tem " + primeiraConta.saldo);
		System.out.println("segunda conta tem " + segundaConta.saldo);
		
		System.out.println(primeiraConta.agencia);
		System.out.println(primeiraConta.numero);
		
		System.out.println(segundaConta.agencia);
		
		segundaConta.agencia = 146;
		
		System.out.println("agora a segunda conta esta" + "na agencia " + segundaConta.agencia);
		
		
		if(primeiraConta == segundaConta) {
			System.out.println("Sao a mesma conta");
		} else {
			System.out.println("Sao diferentes");	
		}

		System.out.println(primeiraConta);
		System.out.println(segundaConta);
	}
}
