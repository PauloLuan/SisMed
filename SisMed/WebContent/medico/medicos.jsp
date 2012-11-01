<jsp:include page="../includes/isPaciente.jsp"></jsp:include>
<jsp:include page="../includes/isMedico.jsp"></jsp:include>
<jsp:include page="../includes/checkLogin.jsp"></jsp:include>
<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.sql.*,aap.model.db.dao.MedicoDao,aap.model.Medico,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".search_bt").click(function() {
			$("#buscaMedicos").slideToggle();
		});
	});
</script>
<a class="add_bt" href="cadastrarMedico.jsp">Cadastrar Médico</a>
<a class="search_bt">Buscar Médico</a>
<div id="buscaMedicos" style="display: none;">
	<form action="medicos.jsp" method="get">
		<table class="crud_table">
			<tr>
				<td class="crud_text">Nome:</td>
				<td><input type="text" name="busca_nome" size="50"
					value="${ param.busca_nome }" /></td>
			</tr>
			<tr>
				<td class="crud_text">RG:</td>
				<td><input type="text" name="busca_rg" size="30"
					value="${ param.busca_rg }" /></td>
			</tr>
			<tr>
				<td class="crud_text">CPF:</td>
				<td><input type="text" name="busca_cpf" size="30"
					value="${ param.busca_cpf }" /></td>
			</tr>
			<tr>
				<td class="crud_text">CRM:</td>
				<td><input type="text" name="busca_crm" size="30"
					value="${ param.busca_crm }" /></td>
			</tr>
			<tr>
				<td class="crud_text">Telefone Residencial:</td>
				<td><input type="text" name="busca_telefoneResidencial"
					size="20" value="${ param.busca_telefoneResidencial }" /></td>
			</tr>
			<tr>
				<td class="crud_text">Telefone Celular:</td>
				<td><input type="text" name="busca_telefoneCelular" size="20"
					value="${ param.busca_telefoneCelular }" /></td>
			</tr>
			<tr>
				<td class="crud_text">Email:</td>
				<td><input type="text" name="busca_email" size="40"
					value="${ param.busca_email }" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Buscar" /> <input type="button" onclick="javascript:window.location='medicos.jsp'" value="Limpar" /></td>
			</tr>
		</table>
	</form>
</div>
<br />
<c:if test="${ not empty param.msg }">
	<small class="msg_green">${ param.msg }</small>
</c:if>
<c:if test="${ not empty param.msg2 }">
	<small class="msg_red">${ param.msg2 }</small>
</c:if>
<div>
	<table class="list_table">
		<tr>
			<td><b>Nome</b></td>
			<td><b>CRM</b></td>
			<td><b>Telefone</b></td>
			<td><b>Email</b></td>
			<td><b>Cidade</b></td>
			<td><b>Ações</b></td>
		</tr>
		<%
			MedicoDao dao = new MedicoDao();
			List<Medico> lista = dao.search(
					request.getParameter("busca_nome"),
					request.getParameter("busca_rg"),
					request.getParameter("busca_cpf"),
					request.getParameter("busca_crm"),
					request.getParameter("busca_telefoneResidencial"),
					request.getParameter("busca_telefoneCelular"),
					request.getParameter("email"));
			//out.print(lista.size());
			pageContext.setAttribute("lista",lista);
		%>

		<c:forEach var="user" items="${ lista }" varStatus="status">
			<c:set var="linhaPar" value="${status.count % 2 == 0}" />
			<c:set var="corFundo" value="${linhaPar ? '#e7e7e7' : '#FFFFFF'}" />
			<tr bgColor="${corFundo}">
				<td>${user.nome}</td>
				<td>${user.crm}</td>
				<td>${user.telefoneResidencial}</td>
				<td>${user.email}</td>
				<td>${user.cidade}</td>
				<td><a class="edit_bt"
					href="editarMedico.do?id=${ user.idMedico }">Editar</a> | <a
					class="remove_bt"
					href="removerMedico.do?id=${ user.idMedico }">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>