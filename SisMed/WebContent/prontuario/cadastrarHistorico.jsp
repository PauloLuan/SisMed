<jsp:include page="../includes/isPaciente.jsp"></jsp:include>
<jsp:include page="../includes/isSecretaria.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:include page="../includes/checkLogin.jsp"></jsp:include>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/css.css" type="text/css">

<title> Cadastro de Prontuário Médico | Secretária </title>

</head>
<body>

	<jsp:include page="../includes/header.jsp"></jsp:include>
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	
	<br><h2> Cadastrar historico do Paciente </h2>
	
	<div class = "alinhar_meio">
	<form enctype="multipart/form-data" action="../CadastrarHistorico.do" method="post"> 
		
		<br> Foto <br>
		<input type = "file" name = "foto" value = "escolher foto"/><br/><br/>
		
		<br>Idade: <br>
		<input type = "text"  name="idade" size = "60">
		
		<br><br>
		Peso: <input type = "text"  name = "peso" size = "10" align ="right"></input>
		Altura: <input type = "text"  name = "altura" size = "10" align ="right"></input>
		
		<br><br> Observações:<br> 
		<textarea name = "observacoes" rows="10" cols="100"> </textarea>
		<br><br>
		
		<br><br> Medicamentos:<br> 
		<textarea name = "medicamentos" rows="10" cols="100"> </textarea>
		<br><br>
		
		<input type="hidden" name="idConsulta" value="${param.idConsulta}" />
		
		<input type=submit value="Salvar">
	</form>
	
		<a href = "listarHistorico.jsp"> Ver Histórico </a>
		<input type="button" value="Imprimir" onclick="javascript:window.print()" />
		
	<br>
	<br>
	</div>		
	
	<jsp:include page="../includes/footer.jsp"></jsp:include>

	
</body>
</html>