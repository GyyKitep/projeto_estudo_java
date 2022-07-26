<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServletEntrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<c:import url="logout-parcial.jsp"></c:import>
	<form action="${linkServletEntrada}" method="post"> <!-- como padrao ele usa get -->
		Nome: <input type="text" name="nome"/>
		Data Abertura: <input type="text" name="data"/>
		<input type="hidden" name="acao" value="NovaEmpresa"/>
		<input type="submit">
	</form>
</body>
</html>