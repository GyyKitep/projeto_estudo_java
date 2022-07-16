package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//oi
//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet{
	
	//o tomcat cria o metodo main - > inversao de controles
	
	public OiMundoServlet() {
		System.out.println("Criando Oi Mundo servlet"); //o tomcat cria apenas uma vez a classe
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Olá mundo");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet foi chamado");
		
	}
}
