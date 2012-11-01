<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="../css/css.css" />
</head>
<body>
	<div id="login">
		<a class="logo" href="index.jsp">SisMed</a>
		<form action="../login.do" method="post">
			<table>
				<tr>
					<td><small>Email: </small></td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td><small>Senha: </small></td>
					<td><input type="password" name="senha" /></td>
				</tr>
				<c:if test="${ not empty param.msg }">
					<tr><td></td><td><p style="color: red; font-size: 10px;">${ param.msg }</p></td></tr>
				</c:if>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>