<jsp:include page="../includes/isMedico.jsp"></jsp:include>
<jsp:include page="../includes/isPaciente.jsp"></jsp:include>
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

<a class="back_bt" href="ListarSecretarias.jsp">Voltar</a>
<br />
<br />
<h2>Edição de Secretária</h2>

<form id="form1" action="EditarSecretaria.do" method="post">
	<table class="crud_table">
		<input type="hidden" name="id" value="${secretaria.id}" readonly="readonly" />
		<tr>
			<td class="crud_text">Nome</td>
			<td><input type="text" name="nome" value="${secretaria.nome}" class="required" ></td>
		</tr>
		<tr>
			<td class="crud_text">Data de Nascimento:</td>
			<td><input id="dataNascimento" type="text" name="dataNascimento"
				size="25" class="required" minlength="10"
				value="<fmt:formatDate value="${secretaria.dataNascimento}" type="both" pattern="dd/MM/yyyy" />" /></td>
		</tr>
		<tr>
			<td class="crud_text">RG:</td>
			<td><input type="text" name="rg" value="${secretaria.rg}" class="required" ></td>
		</tr>
		<tr>
			<td class="crud_text">CPF:</td>
			<td><input type="text" name="cpf" value="${secretaria.cpf}" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Telefone Residencial:</td>
			<td><input type="text" name="telefoneResidencial" value="${secretaria.telResidencial}" ></td>
		</tr>
		<tr>
			<td class="crud_text">TelefoneCelular:</td>
			<td><input type="text" name="telefoneCelular" value="${secretaria.celular}" ></td>
		</tr>
		<tr>
			<td class="crud_text">Email:</td>
			<td><input type="text" name="email" value="${secretaria.email}" class="required"></td>
		</tr>
		<tr>
			<td class="crud_text">Senha:</td>
			<td><input type="text" name="senha" value="${secretaria.senha}" class="required" ></td>
		</tr>
		<tr>
			<td class="crud_text">Estado:</td>
			<td><input type="text" name="estado" value="${secretaria.estado}" class="required" ></td>
		</tr>
		<tr>
			<td class="crud_text">Cidade:</td>
			<td><input type="text" name="cidade" value="${secretaria.cidade}" class="required" ></td>
		</tr>
		<tr>
			<td class="crud_text">Endereco:</td>
			<td><input type="text" name="endereco" value="${secretaria.endereco}" class="required"></td>
		</tr>
		<tr>
			<td class="crud_text">Numero:</td>
			<td><input type="text" name="numero" value="${secretaria.numero}" class="required" ></td>
		</tr>
		<tr>
			<td class="crud_text">Complemento:</td>
			<td><input type="text" name="complemento" value="${secretaria.complemento}" /></td>
		</tr>
		<tr>
			<td class="crud_text"><input type="submit" value="Salvar" /></td>
		</tr>
	</table>
</form>

<br>
<br>

<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>
</html>


