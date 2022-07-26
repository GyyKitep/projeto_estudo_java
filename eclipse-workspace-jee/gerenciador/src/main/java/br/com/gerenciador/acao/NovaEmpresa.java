package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("nova empresa");
		
		System.out.println("Cadastrando nova empresa");
		String nomeEmpresa = request.getParameter("nome"); //parametro do site
		String dataEmpresa = request.getParameter("data");
			
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //parsing
		    dataAbertura = sdf.parse(dataEmpresa); //checked por isso é obrigado a fazer o tratamento
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		
		//PrintWriter out = response.getWriter();		
		//out.println("<html><body> Empresa " + nomeEmpresa + " Cadastrada com sucesso</body></html>");
		
		//chamar o JPS
		//RequestDispatcher rd = request.getRequestDispatcher("/entrada?acao=ListaEmpresas");
		//request.setAttribute("empresa", empresa.getNome());
		
		//rd.forward(request, response);
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
