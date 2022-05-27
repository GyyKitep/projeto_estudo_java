
public class TesteReferencias {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;
		
		System.out.println("saldo da primeira: " + primeiraConta.saldo);
		
		Conta segundaConta = primeiraConta;                 //copia a referencia, pega a msm referencia de memoria do msm objeto 

		System.out.println("saldo da segunda: " + segundaConta.saldo);	
        
		segundaConta.saldo += 100;
		System.out.println("saldo da primeira: " + primeiraConta.saldo);
				
		System.out.println("saldo da segunda: " + segundaConta.saldo);
		
		if(primeiraConta == segundaConta) {
			System.out.println("Sao a mesma conta");
		}
		
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
	}
}
