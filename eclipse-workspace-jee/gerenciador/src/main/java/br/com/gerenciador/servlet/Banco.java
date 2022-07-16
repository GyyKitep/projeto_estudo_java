package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Google");
		
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Microsoft");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Apple");	
		
		lista.add(empresa);
		lista.add(empresa1);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);		
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public static void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
		//for (Empresa empresa : lista) {  nao posso ler a lista e modificar ao mesmo tempo
		//	if(empresa.getId() == id) {
		//		lista.remove(empresa);
		//	}
		//}
		
	}

	public static Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {  
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}


}
