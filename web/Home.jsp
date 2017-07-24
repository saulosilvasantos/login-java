<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "dao.UsuarioDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script type="text/javascript"src="js/buttonBackHome.js"></script>

<% 
    
 String sessao = request.getParameter("txtSessao");
 String id_TXT = request.getParameter("txtId");
 HttpSession sesion = request.getSession(); 
 
 try {
            if(sesion.getAttribute("sessao") != null){
               if ((sessao==null) & (sesion.getAttribute("sessao") != null)){
                   sessao = sesion.getAttribute("sessao").toString();
                   id_TXT = sesion.getAttribute("id").toString();
                   
                   
               }
            }
      } catch (NullPointerException e) {
          
    }
 
 
 if (sesion.getAttribute(sessao)== null){response.sendRedirect("index.jsp");}else{}
      UsuarioDAO usuDao = new UsuarioDAO(); 
      int id_INT = 0;        
      Boolean  conta = null;
      try {
             id_INT = Integer.parseInt(id_TXT);
             conta = usuDao.true_or_false_Conta(id_INT);
            if (conta == false){ 
               sesion.setAttribute("sessao",sessao);
               sesion.setAttribute("id",id_INT);
               response.sendRedirect("ativarConta.jsp");

            }else{}

        } catch (NumberFormatException e) {
          
    }
  

    %>
</head>
<body >
</p>Bem-Vindo ${sessionScope.sessao}</p>

 
 



<% 

out.println("id do usuario: "+id_INT+"<br>"+conta+"<br>");  
out.println("sessao: "+sessao+"<br>");
%>


<a href="<%=request.getContextPath()%>/EncerrarSessao.jsp">SAIR</a>          
</body>
</html>