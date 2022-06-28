package junit;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class CalculadoraTest {
	
	@Test
	public void deveriaSomarDoisNumeroPositivos (){
		
		Calculadora calc = new Calculadora();
		int soma = calc.somar(3, 7);
		
		Assert.assertEquals(10, soma);
		
	}

}
