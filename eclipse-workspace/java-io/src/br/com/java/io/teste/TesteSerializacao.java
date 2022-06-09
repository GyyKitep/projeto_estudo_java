package br.com.java.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//		Cliente cliente = new Cliente();
// 		cliente.setNome("Geovanny");
//  		cliente.setProfissao("Dev");
//  		cliente.setCpf("234113131");
//  		
//  
//  		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
//  		
//  		oos.writeObject(cliente);  //para seriealizar um objeto o objeto precisa assinar o contrato/implementar java.io.Serializable
//  		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
		Cliente cliente =(Cliente) ois.readObject();
		
		ois.close();
		System.out.println(cliente.getNome());
		

	}

}
