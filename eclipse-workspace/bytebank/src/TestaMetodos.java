
public class TestaMetodos {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.saldo = 100;
		conta.deposita(50);        //invocar metodo
		System.out.println(conta.saldo);
		
		boolean conseguiuRetirar = conta.saca(20);   // invoca o metodo e recebe o valor do retorno
		
		System.out.println(conta.saldo);
		System.out.println(conseguiuRetirar);
		
		Conta contaDeTranferencia = new Conta();
				
		contaDeTranferencia.deposita(1000);
		
		boolean sucesssoTransferencia = contaDeTranferencia.transfere(300, conta);
		
		if(sucesssoTransferencia) {            // contaDeTranferencia.transfere(300, conta) como retorna boolean da para usar a invocacao do metodo no if
			System.out.println("transferencia com sucesso");
		}else {
			System.out.println("faltou dinheiro");
		}
		
		System.out.println(contaDeTranferencia.saldo);
		
		System.out.println(conta.saldo);		

		
		conta.titular = "paulo silveira";
		System.out.println(conta.titular);
		
	}
}
