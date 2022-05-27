
public class TestaValores {
	public static void main(String[] args) {
		Conta conta = new Conta(1337 , 24226);     // dentro do parenteses invoca um metodo construtor
		
		
		// conta está inconsistente pq ela tem valor defaut zerado - antes do metodo construtor
		//conta.setAgencia(-50);
		//conta.setNumero(-330);		
		
		System.out.println(conta.getAgencia());
		
		Conta conta2 = new Conta(1337 , 21331);
		Conta conta3 = new Conta(1337 , 123121);
		
		
		System.out.println(Conta.getTotal());
		
		
	}
}
