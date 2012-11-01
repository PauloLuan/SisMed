<jsp:include page="../includes/isSecretaria.jsp"></jsp:include>
<jsp:include page="../includes/checkLogin.jsp"></jsp:include>
<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*,aap.model.db.dao.MedicoDao,aap.model.Medico,aap.model.db.dao.PacienteDao,aap.model.Paciente,aap.model.db.dao.ConsultaDAO,aap.model.Consulta,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
@import "../css/jquery.datepick.css";
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.datepick.js"></script>
<script type="text/javascript" src="../js/jquery.datepick-pt-BR.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".search_bt").click(function() {
			$("#buscaConsultas").slideToggle();
		});
		$('#data1').datepick();
	});
</script>
<a class="search_bt">Buscar Consulta</a>
<div id="buscaConsultas" style="display: none;">
	<form action="minhas_consultas.jsp" method="get">
		<table class="crud_table">
			<c:if test="${ tipo == 'Medico' }">
				<tr>
					<td class="crud_text">Paciente:</td>
					<td><input type="text" name="busca_paciente" size="50"
						value="${ param.busca_paciente }" /></td>
				</tr>
			</c:if>
			<c:if test="${ tipo == 'Paciente' }">
				<tr>
					<td class="crud_text">Médico:</td>
					<td><input type="text" name="busca_medico" size="30"
						value="${ param.busca_medico }" /></td>
				</tr>
			</c:if>
			<tr>
				<td class="crud_text">Data:</td>
				<td><input id="data1" type="text" name="busca_data" size="30"
					value="${ param.busca_data }" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Buscar" /> <input
					type="button"
					onclick="javascript:window.location='minhas_consultas.jsp'"
					value="Limpar" /></td>
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
			<td><b>Data</b></td>
			<td><b>Médico</b></td>
			<td><b>Paciente</b></td>
			<c:if test="${ tipo == 'Medico' }">
			<td><b>Ações</b></td>
			</c:if>
		</tr>
		<%
			String medicoId;
			String pacienteId;
			ConsultaDAO dao = new ConsultaDAO();
			if (session.getAttribute("tipo") == "Medico") {
				medicoId = (String) session.getAttribute("idMedico");
			} else {
				medicoId = request.getParameter("busca_medico");
			}
			if (session.getAttribute("tipo") == "Paciente") {
				pacienteId = (String) session.getAttribute("idPaciente");
			} else {
				pacienteId = request.getParameter("busca_medico");
			}
			List<Consulta> lista = dao.search(pacienteId, medicoId,
					request.getParameter("busca_data"));
			//out.print(lista.size());
			pageContext.setAttribute("lista", lista);
		%>

		<c:forEach var="consulta" items="${ lista }" varStatus="status">
			<c:set var="linhaPar" value="${status.count % 2 == 0}" />
			<c:set var="corFundo" value="${linhaPar ? '#e7e7e7' : '#FFFFFF'}" />
			<tr bgColor="${corFundo}">
				<td><fmt:formatDate value="${consulta.dataTimeConsulta}"
						type="both" pattern="dd/MM/yyyy - HH:mm" />h</td>
				<td>${ consulta.nomeMedico }</td>
				<td>${ consulta.nomePaciente }</td>
				<c:if test="${ tipo == 'Medico' }">
				<td>
					<a class="edit_bt"
					href="../prontuario/ProntuarioPacienteServlet.do?idPaciente=${ consulta.idPaciente }">Prontuários</a> |
					<a class="consulta_bt"
					href="../prontuario/cadastrarHistorico.jsp?idConsulta=${ consulta.idConsulta }">Novo Prontuário</a>
				</td>
				</c:if>
			</tr>
		</c:forEach>
	
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>