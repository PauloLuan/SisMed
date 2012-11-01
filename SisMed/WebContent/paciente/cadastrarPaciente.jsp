<jsp:include page="../includes/isPaciente.jsp"></jsp:include>
<jsp:include page="../includes/isMedico.jsp"></jsp:include>
<jsp:include page="../includes/checkLogin.jsp"></jsp:include>
<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

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
<a class="back_bt" href="pacientes.jsp">Voltar</a><br/><br/>
<h2>Cadastrar Paciente</h2>
<form id="form1" action="addPaciente.do" method="post">
	<table class="crud_table">
		<tr>
			<td class="crud_text">Nome: </td>
			<td><input type="text" name="nome" size="50" class="required" minlength="5" /></td>
		</tr>
		<tr>
			<td class="crud_text">Data de Nascimento: </td>
			<td><input id="dataNascimento" type="text" name="dataNascimento" size="25" class="required" minlength="10" /></td>
		</tr>
		<tr>
			<td class="crud_text">RG: </td>
			<td><input type="text" name="rg" size="30" class="required" minlength="5" /></td>
		</tr>
		<tr>
			<td class="crud_text">CPF: </td>
			<td><input id="cpf" type="text" name="cpf" size="30" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Telefone Residencial: </td>
			<td><input id="telefoneResidencial" type="text" name="telefoneResidencial" size="20" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Telefone Celular: </td>
			<td><input id="telefoneCelular" type="text" name="telefoneCelular" size="20" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Email: </td>
			<td><input type="text" name="email" size="40" class="required email"/></td>
		</tr>
		<tr>
			<td class="crud_text">Senha: </td>
			<td><input type="text" name="senha" size="20" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Estado (SP): </td>
			<td><input id="estado" type="text" name="estado" size="10" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Cidade: </td>
			<td><input type="text" name="cidade" size="50" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Endereço (rua / avenida): </td>
			<td><input type="text" name="endereco" size="50" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Número: </td>
			<td><input type="text" name="numero" size="10" class="required" /></td>
		</tr>
		<tr>
			<td class="crud_text">Complemento: </td>
			<td><input type="text" name="complemento" size="30" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Cadastrar" /></td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>