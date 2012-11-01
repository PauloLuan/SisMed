<jsp:include page="../includes/isPaciente.jsp"></jsp:include>
<jsp:include page="../includes/isMedico.jsp"></jsp:include>
<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*,aap.model.db.dao.PacienteDao,aap.model.Paciente,aap.model.db.dao.MedicoDao,aap.model.Medico,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
@import "../css/jquery.datepick.css";
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.datepick.js"></script>
<script type="text/javascript" src="../js/jquery.datepick-pt-BR.js"></script>
<script type="text/javascript" src="../js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#data1').datepick();
		$("#data1").mask("99/99/9999",{placeholder:"_"});
		$("#data1").blur(function() { $("#hora").focus(); });
		$("#hora").mask("99:99",{placeholder:"_"});
	});
</script>

<a class="back_bt" href="../consulta/consultas.jsp">Voltar</a><br/><br/>

<h2>Editar Consulta</h2>
<body>
	<form action="salvarConsulta.do" method="post">
		<table class="crud_table">
			<tr>
				<td class="crud_text">Paciente:</td>
				<td>${ consulta.nomePaciente }</td>
			</tr>
			<tr>
				<td class="crud_text">Médico:</td>
				<td><select name="idMedico" class="required">
						<option value="">-- Selecione --</option>
						<jsp:useBean id="dao" class="aap.model.db.dao.MedicoDao" />
						<c:forEach var="user" items="${dao.list}" varStatus="status">
							<c:if test="${ user.idMedico == consulta.idMedico }">
								<option value="${user.idMedico}" selected>${user.nome}</option>
							</c:if>
							<c:if test="${ user.idMedico != consulta.idMedico }">
								<option value="${user.idMedico}">${user.nome}</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="crud_text">Data Consulta:</td>
				<td><input id="data1" type="text" name="data" size="20" value="<fmt:formatDate value="${consulta.dataTimeConsulta}" type="both" pattern="dd/MM/yyyy" />" /></td>
			</tr>
			<tr>
				<td class="crud_text">Hora Consulta:</td>
				<td><input id="hora" type="text" name="hora" size="15" value="<fmt:formatDate value="${consulta.dataTimeConsulta}" type="both" pattern="HH:mm" />" /></td>
			</tr>
			<tr>
				<td class="crud_text">Observações:</td>
				<td><textarea name="observacoes" rows="8" cols="100">${consulta.observacoes}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="hidden" name="idConsulta" value="${consulta.idConsulta}" />
					<input type="submit" value="Atualizar">
				</td>
			</tr>
		</table>
	</form>

	<jsp:include page="../includes/footer.jsp"></jsp:include>