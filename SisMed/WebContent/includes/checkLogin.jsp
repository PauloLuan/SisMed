<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${ empty autorizado }">
	<jsp:forward page="../login/login.jsp" />
</c:if>