
//contrato Autenticavel 
	//quem asssinar esse contrato precisa implementar 
		//o metodo setSenha e o autentifica

public abstract interface Autenticavel {       //interface é uma classe abstrata com todos os metodos abstratos	
		
	public abstract void setSenha(int senha);

	
	public abstract boolean autentica(int senha);
}
