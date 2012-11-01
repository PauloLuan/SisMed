<jsp:include page="../includes/isPaciente.jsp"></jsp:include>
<jsp:include page="../includes/isMedico.jsp"></jsp:include>
<jsp:include page="../includes/checkLogin.jsp"></jsp:include>
<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<%@page
	import="java.util.Date, java.text.SimpleDateFormat, java.text.ParseException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
<script type="text/javascript" src="../js/jquery.maskedinput.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#form1").validate();
		$("#dataNascimento").mask("99/99/9999", {
			placeholder : "_"
		});
		$("#cpf").mask("999.999.999-99", {
			placeholder : "_"
		});
		$("#telefoneResidencial").mask("(99) 9999-9999", {
			placeholder : "_"
		});
		$("#telefoneCelular").mask("(99) 9999-9999", {
			placeholder : "_"
		});
		$("#estado").mask("aa", {
			placeholder : "_"
		});
	});
</script>

<a class="back_bt" href="medicos.jsp">Voltar</a>
<br />
<br />
<h2>Editar Médico</h2>


<form id="form1" action="atualizarMedico.do" method="post">
	<input type="hidden" name="idMedico" value="${ medico.idMedico }" />

	<table class="crud_table">
		<tr>
			<td class="crud_text">Nome:</td>
			<td><input type="text" name="nome" size="50"
				value="${ medico.nome }" class="required" minlength="5" /></td>
		</tr>
		<tr>
			<td class="crud_text">Data de Nascimento:</td>
			<td><input id="dataNascimento" type="text" name="dataNascimento"
				size="25" class="required" minlength="10"
				value="<fmt:formatDate value="${medico.dataNascimento}" type="both" pattern="dd/MM/yyyy" />" /></td>
		</tr>
		<tr>
			<td class="crud_text">RG:</td>
			<td><input type="text" name="rg" size="30"
				value="${ medico.rg }" class="required" minlength="5" /></td>
		</tr>
		<tr>
			<td class="crud_text">CPF:</td>
			<td><input id="cpf" type="text" name="cpf" size="30"
				value="${ medico.cpf }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">CRM:</td>
			<td><input type="text" name="crm" size="30"
				value="${ medico.crm }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Telefone Residencial:</td>
			<td><input id="telefoneResidencial" type="text"
				name="telefoneResidencial" size="20"
				value="${ medico.telefoneResidencial }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Telefone Celular:</td>
			<td><input id="telefoneCelular" type="text"
				name="telefoneCelular" size="20"
				value="${ medico.telefoneCelular }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Email:</td>
			<td><input type="text" name="email" size="40"
				value="${ medico.email }" class="required email" /></td>
		</tr>
		<tr>
			<td class="crud_text">Senha:</td>
			<td><input type="text" name="senha" size="20"
				value="${ medico.senha }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Estado (SP):</td>
			<td><input id="estado" type="text" name="estado" size="10"
				value="${ medico.estado }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Cidade:</td>
			<td><input type="text" name="cidade" size="50"
				value="${ medico.cidade }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Endereço (rua / avenida):</td>
			<td><input type="text" name="endereco" size="50"
				value="${ medico.endereco }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Número:</td>
			<td><input type="text" name="numero" size="10"
				value="${ medico.numero }" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Complemento:</td>
			<td><input type="text" name="complemento" size="30"
				value="${ medico.complemento }" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Atualizar" /></td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>