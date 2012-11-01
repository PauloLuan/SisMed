<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="aap.controller.*,aap.model.*,aap.model.db.dao.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../includes/isMedico.jsp"></jsp:include>
<jsp:include page="../includes/isPaciente.jsp"></jsp:include>
<jsp:include page="../includes/checkLogin.jsp"></jsp:include>
<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>
<a class="add_bt" href="CadastroSecretaria.jsp">Cadastrar Secretária</a>
<br/>
<c:if test="${ not empty param.msg }">
	<small class="msg_green">${ param.msg }</small>
</c:if>
<c:if test="${ not empty param.msg2 }">
	<small class="msg_red">${ param.msg2 }</small>
</c:if>
<jsp:useBean id="dao" class="aap.model.db.dao.SecretariaDAO" />
<table class="list_table">
	<tr>
		<td>Nome</td>
		<td>RG</td>
		<td>CPF</td>
		<td>Email</td>
		<td>Ações</td>
	</tr>

	<!-- Percorre a lista de usuários criando um usuário temporário para pegar os dados (var) o objeto items é a lista da qual a variável percorre -->
	<c:forEach var="secretaria" items="${dao.lista}">
		<tr>
			<!-- tem o mesmo valor que instanciar um objeto e utilizar o seu método: usuario.getId() -->
			<td>${secretaria.nome}</td>
			<td>${secretaria.rg}</td>
			<td>${secretaria.cpf}</td>
			<td>${secretaria.email}</td>

			<td><a class="edit_bt"
				href="EnviarSecretariaPost.do?id=${secretaria.id}">Editar</a> <a
				class="remove_bt"
				href="RemoverSecretaria.do?id=${secretaria.id}&nome=${secretaria.nome}">Remover</a>
			</td>
			
		</tr>
	</c:forEach>
</table>
<br>
<br>

<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>
</html>