<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${tipo eq 'Medico'}">
	<jsp:forward page="../welcome/index.jsp?naoAutorizado=Você não está autorizado a acessar esta página" />
</c:if>
