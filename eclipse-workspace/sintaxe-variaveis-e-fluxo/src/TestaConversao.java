
public class TestaConversao {
	
	public static void main(String[] args) {
		
		float pontoFlutuante = 3.14f;    // coloca f no final para ele aceitar casas decimais
		
		double salario = 1270.50;
		int valor = (int)salario;    //ele transforma o valor no tipo que esta em ( ) -> Type Casting
		
		System.out.println(valor);
		
		long numeroGrande = 2139121204123123l;       //long aceita um numero bem grande e tem que colocar "l"  no final 2^63 - 1
		
		short valorPequeno = 2131;                  //long aceita um numero bem grande e tem que colocar "l"  no final
		
		byte B = 127;                               //long aceita um numero bem grande e tem que colocar "l"  no fina 2^8 - 1
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		
		double total = valor1 - valor2;             // o calculo esta certo pq estamos usando double
		
		System.out.println(total);                  
		
		
	}

}
