<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${tipo eq 'Medico'}">
	<jsp:forward page="../welcome/index.jsp?naoAutorizado=Voc� n�o est� autorizado a acessar esta p�gina" />
</c:if>
