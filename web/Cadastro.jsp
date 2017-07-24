<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/Controller.js"></script>
</head>
<body>

	<form>
	<label>Nome:</label>
	<input type="text" id="txtNome"/>
	
	<label>E-mail:</label>
	<input type="text" id="txtEmail"/>
	
	<label>Senha:</label>
	<input type="password" id="txtSenha"/>
																
	<input type="button" id="btnSalvar" value="Salvar"/>
	</form>
<div id="msg"></div>
</body>
</html>