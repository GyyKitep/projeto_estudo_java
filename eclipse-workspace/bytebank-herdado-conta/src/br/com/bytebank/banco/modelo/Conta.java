package br.com.bytebank.banco.modelo;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio

/**
 * Classe que representa a moldura de uma conta
 * 
 * @author Geovanny
 *
 */
public abstract class Conta { 
	 protected double saldo;		      // private proibe que outras classes possam mexer e ler ela, apenas esta classe pode mexer nela
	 private int agencia;                    // atributos
	 private int numero;               // o atributo pode ser imutavel, ter um valor constante
	 private Cliente titular; //= new Cliente();  // a cada instanciacao é criado um titular   
	 private static int total;        // static deixa o atributo da classe e não exclusiva da conta e não da pra usar "this." 
	 
//	 public Conta() {    //depois que tiver um metodo contrutor o metodo sem parametros não é criado pelo java
//		 
//	 }
	 /**
	  *  Conta apartir da agenia e numero 
	  * @param agencia
	  * @param numero
	  */
	 
	 public Conta(int agencia, int numero) {                    //construtor padrao se não colocar o java faz para vc	 
		 Conta.total++;
		 //System.out.println("o total de contas é " + Conta.total);
		 
		 this.agencia = agencia;
		 this.numero  = numero;		 
		 
		 //System.out.println("estou criando uma conta " + this.numero);
	 }
	 

//          devolve         recebe
	 
     public abstract void deposita(double valor);  //obriga o filho a declarar este metodo

     /**
      * Valor que precisa ser maior que o saldo
      * 
      * @param valor
      * @throws SaldoInsuficienteExcepction
      */
     
     
     public void saca(double valor) throws SaldoInsuficienteExcepction{
    	 
    	 if(this.saldo < valor) {
    		 throw new SaldoInsuficienteExcepction("saldo: " + this.saldo + ", Valor: " + valor);
    	 }   
    	 
    	 this.saldo -= valor;
     }
     
     public void transfere(double valor, Conta destino) throws SaldoInsuficienteExcepction{
    	     this.saca(valor);    // com a tratativa de erro, caso der erro ele vai abortar
    		 destino.deposita(valor);
	  	 
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
		//System.out.println(this.saldo);    // não existe this em um metodo estatico
    	
    	return Conta.total;
	}
    
	@Override
	public String toString() {
		return "Número: " + this.getNumero() + " Agenica: " + this.getAgencia();
	}
	   
    
}
	 