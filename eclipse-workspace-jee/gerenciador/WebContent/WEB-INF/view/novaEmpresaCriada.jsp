<!--  <|%
 //scriplet
 String nomeEmpresa = (String)request.getAttribute("empresa");
 System.out.println(nomeEmpresa);
%>-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<body>
	<c:import url="logout-parcial.jsp"></c:import>	
	     <!--  Empresa <|%=nomeEmpresa %>  <|%out.println(nomeEmpresa);%> Cadastrada com sucesso -->
	     <c:if test="${not empty empresa }">
         	Empresa ${ empresa } Cadastrada com sucesso
         </c:if>
         
         <c:if test="${empty empresa }">
         	Nenhuma empresa cadastrada
         </c:if>
         
	</body>
</html>