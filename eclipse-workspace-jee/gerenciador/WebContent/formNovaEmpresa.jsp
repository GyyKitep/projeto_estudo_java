<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form action="${linkServletNovaEmpresa}" method="post"> <!-- como padrao ele usa get -->
		Nome: <input type="text" name="nome"/>
		Data Abertura: <input type="text" name="data"/>
		<input type="submit">
	</form>
</body>
</html>