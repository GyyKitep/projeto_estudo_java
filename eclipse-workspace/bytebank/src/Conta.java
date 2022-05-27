public class Conta { 
	 double saldo;
	 int agencia;                    // atributos
	 int numero;               
	 String titular;
	 String cpf;
	 String profissao;

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
}
	 