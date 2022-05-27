public class Conta { 
	 private double saldo;		      // private proibe que outras classes possam mexer e ler ela, apenas esta classe pode mexer nela
	 int agencia;                    // atributos
	 int numero;               
	 Cliente titular; //= new Cliente();  // a cada instanciacao é criado um titular               

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
}
	 