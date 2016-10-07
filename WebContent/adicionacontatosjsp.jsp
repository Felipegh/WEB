<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda de Contatos</title>

</head>

<body>

	<c:import url="cabecalho.jsp" />
	
	<h1>Adiciona Contatos no BD</h1>
		<hr />
		<form action="adicionacontato">
			Nome: 		<input type="text" name="nome" /><br />
			E-mail: 	<input type="text" name="email" /><br />
			Endereço:	<input type="text" name="endereco" /><br />
			Data Nascimento:	<caelum:campoData id="dataNascimento" /><br />  
						 
				<hr />
				<input type="submit" value="Gravar" />
				
				
		</form>
		
	<c:import url="rodape.jsp" />
</body>
</html>