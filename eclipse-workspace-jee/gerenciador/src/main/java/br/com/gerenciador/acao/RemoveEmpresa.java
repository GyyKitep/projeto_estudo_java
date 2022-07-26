package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("removendo empresas");
		
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		Banco.removeEmpresa(id);
		
		return "redirect:entrada?acao=ListaEmpresas";		
		
	}

}
