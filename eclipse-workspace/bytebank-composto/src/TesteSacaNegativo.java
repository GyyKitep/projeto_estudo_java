
public class TesteSacaNegativo {

	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.deposita(100);
		System.out.println(conta.saca(101));
		
		conta.saca(101);
		
		System.out.println(conta.getSaldo());
		
		conta.numero = -1377;
		
		//conta.saldo = conta.saldo - 101;              // nao devemos trabalhar direto com os atributos devemos apenas usar os metodos		
		//System.out.println(conta.saldo);
		
	}
}
