
public class TesteGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setNumero(1337);
		
		System.out.println(conta.getNumero());
		
		Cliente paulo = new Cliente();
		
		paulo.setNome("paulo silveira");
		
		conta.setTitular(paulo);
		
		System.out.println(conta.getTitular().getNome());
		
		conta.getTitular().setProfissao("programado");
		
		System.out.println(conta.getTitular().getProfissao());
		
		Cliente titularDaConta = conta.getTitular();
		titularDaConta.setProfissao("analista");
		
		System.out.println(titularDaConta);
		System.out.println(paulo);
		System.out.println(conta.getTitular());
	}
}
