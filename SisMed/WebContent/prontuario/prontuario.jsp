<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="aap.controller.*,aap.model.*,aap.model.db.dao.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="/includes/header.jsp"></jsp:include>
<jsp:include page="/includes/menu.jsp"></jsp:include>

	<h2>Prontuário Paciente: ${ paciente.nome }</h2>
	<br />
	<jsp:useBean id="dao" class="aap.model.db.dao.HistoricoDAO" />
	<br />

	<c:forEach var="prontuarios" items="${prontuarios}">
		<table class="list_table">
			<tr>
				<td rowspan="4" width="125" height="150" align="Center"><image width="125" height="190" src="../MostrarImagem.do?idFoto=${ prontuarios.idHistorico }" />
			</tr>
			<tr>
				<td>Data da Consulta: <fmt:formatDate value="${prontuarios.dataTimeConsulta}" type="both" pattern="dd/MM/yyyy - HH:mm" />
				<td>Peso: ${prontuarios.peso}</td>
			</tr>
			<tr>
				<td>Idade: ${prontuarios.idade}</td>
				<td>Altura: ${prontuarios.altura}</td>
			</tr>
			<tr>
				<td>Medicamentos: ${prontuarios.medicamentos}</td>
				<td>IMC: ${prontuarios.imc}</td>
			</tr>
		</table>
		<br/>
	</c:forEach>


<input type="button" value="Imprimir" onclick="javascript:window.print()" />
<jsp:include page="/includes/footer.jsp"></jsp:include>