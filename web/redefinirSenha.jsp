<%-- 
    Document   : recuperarSenha
    Created on : 15/07/2017, 17:57:15
    Author     : saulo
--%>


<%@ page import = "dao.UsuarioDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    HttpSession sesion = request.getSession();
    
  try{
    if ((sesion.getAttribute("pageSesion").toString().equals("0"))){ 
 
            String idd =  sesion.getAttribute("id").toString();
            int id = new Integer(Integer.parseInt(idd));
            String serial =  sesion.getAttribute("serial").toString();
            String email =  sesion.getAttribute("email").toString();

%> 
  <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/Controller.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Redefinir sua senha</h1>
        <form >
	<label>Nova senha:</label>
	<input type="password" id="txtSenha"/>
	<input type=hidden name="txtId" id="txtId"value="<%out.println(id);%>"> 
        <input type=hidden name="txtEmail" id="txtEmail"value="<%out.println(email);%>"> 
        <input type=hidden name="txtSerial" id="txtSerial"value="<%out.println(serial);%>"> 
	<input type="button" id="btnNovaSenha" value="Redefinir"/>
	</form>
        <div id="msg"></div>
       <a href="<%=request.getContextPath()%>/EncerrarSessao.jsp">SAIR</a>  
    </body>
</html>       
<%  }else{   %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/Controller.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Redefinir sua senha</h1>

        <form >
	<label>E-mail:</label>
	<input type="text" id="txtEmail"/>
																
	<input type="button" id="btnRedefinir" value="Entrar"/>
	</form>
        <div id="msg"></div>
        
    </body>
</html>
<% } }catch(NullPointerException e){%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/Controller.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Redefinir sua senha</h1>
        <form >
	<label>E-mail:</label>
	<input type="text" id="txtEmail"/>
																
	<input type="button" id="btnRedefinir" value="Entrar"/>
	</form>
        <div id="msg"></div>
        
    </body>
</html>


<%} %>