public class Conta { 
	 private double saldo;		      // private proibe que outras classes possam mexer e ler ela, apenas esta classe pode mexer nela
	 private int agencia;                    // atributos
	 private int numero;               // o atributo pode ser imutavel, ter um valor constante
	 private Cliente titular; //= new Cliente();  // a cada instanciacao � criado um titular   
	 private static int total;        // static deixa o atributo da classe e n�o exclusiva da conta e n�o da pra usar "this." 
	 public Conta() {    //depois que tiver um metodo contrutor o metodo sem parametros n�o � criado pelo java
		 
	 }
	 
	 public Conta(int agencia, int numero) {                    //construtor padrao se n�o colocar o java faz para vc	 
		 Conta.total++;
		 //System.out.println("o total de contas � " + Conta.total);
		 
		 this.agencia = agencia;
		 this.numero  = numero;		 
		 
		 //System.out.println("estou criando uma conta " + this.numero);
	 }
	 

//          devolve         recebe
	 
     public void deposita(double valor) {           //metodo
    	                           
    	 this.saldo += valor;                       // referencia para do metodo invocado
     
     }
     
     public boolean saca(double valor) {
    	 if(this.saldo >= valor) {
    		 this.saldo -= valor;
    		 return true;
    	 }else {
    		 return false;
    	 }
    	 
     }
     
     public boolean transfere(double valor, Conta destino) {
    	 if(this.saldo >= valor) {
    		 this.saldo -= valor;
    		 destino.deposita(valor);
    		 return true;
    	 }
    		 return false;            // returne aborta o metodo 	  	 
     }
     
     public double getSaldo() {
    	 return this.saldo;    	 
     }
    
     public double getNumero() {
    	 return this.numero;    	 
     }
     
     public void setNumero(int numero) {
    	 if(numero <=0) {
    		 System.out.println("nao pode valor menor igual a 0");
    		 return; 
    	 }
    	 this.numero = numero;    	 
     }
     
     public int getAgencia() {
    	 return this.agencia;
	}
     
    public void setAgencia(int agencia) {
    	if(agencia <=0) {
    		System.out.println("nao pode valor menor igual a 0");
    		return; 
	 }
   	 	this.agencia = agencia;
	}     
     
    public void setTitular(Cliente titular) {
		this.titular = titular;
	}
    
    public Cliente getTitular() {
		return this.titular;
	}
    
    public static int getTotal() {           //colocado static para poder pegar o metodo pela classe
		//System.out.println(this.saldo);    // n�o existe this em um metodo estatico
    	
    	return Conta.total;
	}
    
}
	 