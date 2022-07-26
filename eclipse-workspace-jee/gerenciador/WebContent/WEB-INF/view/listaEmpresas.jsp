<%@page import="br.com.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standar Taglib</title>
</head>
<body>	
	
	<c:import url="logout-parcial.jsp"></c:import>
		
	Usuario Logado: ${ usuarioLogado }
	
	<br>
	<br>
	<br>
	
	Lista de empresas: <br>
	
	<c:if test="${not empty empresa }">
		Empresa ${ empresa } Cadastrada com sucesso
	</c:if>	
	
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">	
		
			<li>	
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
			</li>
			
			
		</c:forEach>	
	</ul>
	
	
	<!--<ul>
	  <|% 		
	   List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");	
		for (Empresa empresa : lista) {
	%>
			<li><|%= empresa.getNome()%></li>
	<|%
		}
	%>		
	</ul>-->
	
</body>
</html>