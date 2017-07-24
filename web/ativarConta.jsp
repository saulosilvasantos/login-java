<%-- 
    Document   : ativarConta
    Created on : 14/07/2017, 19:17:18
    Author     : saulo
--%>

<%@page import="java.util.List"%>
<%@page import="usuario.Conta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "dao.UsuarioDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


<% 
    HttpSession sesion = request.getSession(); 
    if (sesion.getAttribute("sessao")== null){
        response.sendRedirect("index.jsp");
    }else{}
      UsuarioDAO usuDao = new UsuarioDAO();
      Object id = sesion.getAttribute("id");  
      int  id_INT = Integer.parseInt(id.toString());
      String id_TXT = id_INT+"";
      Object  sessiao =  sesion.getAttribute("sessao");
      String sessao  = sessiao.toString();       
      Conta conta = new Conta();
      conta.setId(id_TXT.trim());
      List <Conta> listaResultado = usuDao.buscarDadosUsuario(conta);
      Boolean Valor_ativacao = null;
      String  serial  = null;
      for(Conta u: listaResultado){
          serial = u.getSerial_ativacao();
          Valor_ativacao = u.isValor_ativacao();
      }
      try {   
            if (Valor_ativacao == true){ 
               sesion.setAttribute("sessao",sessao); 
               sesion.setAttribute("id",id_INT); 
               response.sendRedirect("Home.jsp");

                      }else{}

                   }catch (NumberFormatException e) {
                      response.sendRedirect("index.jsp");
               }catch (NullPointerException e) {
                      response.sendRedirect("index.jsp");
          }

%> 
	
    </head>
    <body>
        <%   out.println("<br> id do usuario: "+   sesion.getAttribute("id")); %>
        <%   out.println("<br> sessiao: "+   sessiao); %>
        <%   out.println("<br> serial: "+   serial); %>
        <%   out.println("<br> Valor Ativacao: "+   Valor_ativacao); %>
        
  
        
        
       
        <h1>acessa seu email e click em ativar conta</h1>
        <h2>caso o email não chegou clica em <a href="reenviarEmail?id=<%out.println(id_INT);%>&sessao=<%out.println(sessao);%>&serial=<%out.println(serial);%>">reenviar email<a></h2>
        <a href="<%=request.getContextPath()%>/EncerrarSessao.jsp">SAIR</a>               
    </body>
</html>
