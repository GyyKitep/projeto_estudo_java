
public class TesteSistema {
		
	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		g1.setSenha(2222);
		
		Administrador adm1 = new Administrador();
		adm1.setSenha(3333);
		
		Cliente cl1 = new Cliente();
		cl1.autentica(2222);
		
		SistemaInterno si = new SistemaInterno();
		si.autentifica(g1);
		si.autentifica(adm1);	
		si.autentifica(cl1);
	}
		
		
}
