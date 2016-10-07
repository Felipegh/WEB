<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contato Logic</title>
</head>
<body>
	<h1>Adiciona um Contato no BD através de Logic</h1>
	<hr />
	<c:import url="cabecalho.jsp" />

	Formulário para Adicionar contatos:<br/>
	
		<form action="adiciona" method="POST">
		<!-- Id: <input type="text" name="id"/><br/> -->
		Nome: <input type="text" name="nome"/><br/>
		E-mail: <input type="text" name="email"/><br/>
		Endereço: <input type="text" name="endereco"/><br/>
		Data de Nascimento: <caelum:campoData id="dataNascimento" />
		<input type="hidden" name="logica" value="adicionacontatologic"/>
		<input type="submit" value="Adicionar"/>
		</form>
		<a href=lista-contatos-elegante.jsp>Lista de Contatos</a>
	<c:import url="rodape.jsp" />
</body>
</html>