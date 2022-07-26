package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("Alterando nova empresa");
		String nomeEmpresa = request.getParameter("nome"); //parametro do site
		String dataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("altera empresas" + id);
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //parsing
		    dataAbertura = sdf.parse(dataEmpresa); //checked por isso é obrigado a fazer o tratamento
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);	
		
		Banco banco = new Banco();		
		Empresa empresa = Banco.buscaEmpresaPelaId(id);
		
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
