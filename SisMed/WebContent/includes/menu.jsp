<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<div id="menu">
		<span>Usu�rio: <b>${ nome }</b></span>
			<c:if test="${ tipo == 'Secretaria' }">
				<jsp:include page="menu_secretaria.jsp"></jsp:include>
			</c:if>
			<c:if test="${ tipo == 'Medico' }">
				<jsp:include page="menu_medico.jsp"></jsp:include>
			</c:if>
			<c:if test="${ tipo == 'Paciente' }">
				<jsp:include page="menu_paciente.jsp"></jsp:include>
			</c:if>
	</div>
	
<div id="conteudo">