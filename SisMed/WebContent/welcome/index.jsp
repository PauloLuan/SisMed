<jsp:include page="../includes/checkLogin.jsp"></jsp:include>
<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Bem vindo! ${ nome }</h1>
<c:if test="${ not empty param.naoAutorizado }">
<h2 style="color: red">${ param.naoAutorizado }</h2>
</c:if>
<jsp:include page="../includes/footer.jsp"></jsp:include>