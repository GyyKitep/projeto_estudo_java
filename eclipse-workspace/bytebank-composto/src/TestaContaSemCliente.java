
public class TestaContaSemCliente {
	public static void main(String[] args) {
		Conta contaDaMarcela = new Conta();
		//System.out.println(contaDaMarcela.saldo);
		
		contaDaMarcela.titular = new Cliente();    // funciona pq criamos uma referencia, mas poderiamos adicionar uma referencia já criada
		
		System.out.println(contaDaMarcela.titular);
		
		contaDaMarcela.titular.nome = "Marcela";
		System.out.println(contaDaMarcela.titular.nome);
	}
}
