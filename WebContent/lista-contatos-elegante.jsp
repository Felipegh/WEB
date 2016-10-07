<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos JSP JSTL</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<!-- cria a lista -->
	<jsp:useBean id="dao" class="modelo.ContatoDao"/>
	<table>
		<!-- for -->
		<c:forEach var="contato" items="${dao.lista}">
		
			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
							E-mail não informado
					</c:if>
					
					<%-- <c:choose>				//pode usar choose tbm
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
						E-mail não informado
						</c:otherwise>
					</c:choose> --%>
					
				</td>
				<td>${contato.endereco}</td>
				<td> <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /> </td>
				<%-- <td>${contato.dataNascimento.time}</td> --%>
			</tr>
			
			<%-- <tr>
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento.time}</td>
			</tr> --%>
			
		</c:forEach>
	</table>
	
	<a href="removecontatologic.jsp">Remove Contatos</a>

	<c:import url="rodape.jsp" />
	
</body>
</html>