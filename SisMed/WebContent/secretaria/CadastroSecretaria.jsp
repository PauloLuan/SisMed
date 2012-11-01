<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:include page="../includes/isMedico.jsp"></jsp:include>
<jsp:include page="../includes/isPaciente.jsp"></jsp:include>
<jsp:include page="../includes/checkLogin.jsp"></jsp:include>
<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<%@page import="aap.model.Secretaria"%><html>

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
<script type="text/javascript" src="../js/jquery.maskedinput.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#form1").validate();
		$("#dataNascimento").mask("99/99/9999",{placeholder:"_"});
		$("#cpf").mask("999.999.999-99",{placeholder:"_"});
		$("#telefoneResidencial").mask("(99) 9999-9999",{placeholder:"_"});
		$("#telefoneCelular").mask("(99) 9999-9999",{placeholder:"_"});
		$("#estado").mask("aa",{placeholder:"_"});
	});
</script>


<a class="back_bt" href="ListarSecretarias.jsp">Voltar</a><br/><br/>
<h2>Cadastrar Secretária</h2>

<form id="form1" action="CadastrarSecretaria.do" method="post">
	<table class="crud_table">
		<tr>
			<td class="crud_text">Nome:</td>
			<td><input type="text" name="nome" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Data de Nascimento:</td>
			<td><input type="text" id="dataNascimento" name="dataNascimento" id="data_6" size="10" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">RG:</td>
			<td><input type="text" name="rg" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">CPF:</td>
			<td><input id="cpf" type="text" name="cpf" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Telefone Residencial:</td>
			<td><input id="telefoneResidencial" type="text" name="telefone" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Telefone Celular:</td>
			<td><input id="telefoneCelular" type="text" name="celular" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Email:</td>
			<td><input type="text" name="email" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Senha de Acesso:</td>
			<td><input type="text" name="senha" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Estado:</td>
			<td><input id="estado" type="text" name="estado" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Cidade:</td>
			<td><input type="text" name="cidade" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Endereço:</td>
			<td><input type="text" name="endereco" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Número:</td>
			<td><input type="text" name="numero" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Complemento:</td>
			<td><input type="text" name="complemento" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Cadastrar" /></td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>