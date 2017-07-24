package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.UsuarioDAO;

public final class redefinirSenha_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    HttpSession sesion = request.getSession();
    
    String id =  sesion.getAttribute("id").toString();
    String email =  sesion.getAttribute("email").toString();
    String senha =  sesion.getAttribute("senha").toString();
  
 


      out.write(" \n");
      out.write("\n");
      out.write("   \n");
      out.write(" ");
 if (sesion.getAttribute("pageSesion")== "0"){  
      out.write("\t       \n");
      out.write("        \n");
      out.write("        <form >\n");
      out.write("\t<label>Redefina sua senha:</label>\n");
      out.write("\t<input type=\"password\" id=\"txtSenha\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t<input type=\"button\" id=\"btnRedefinir\" value=\"Redefinir\"/>\n");
      out.write("\t</form>\n");
      out.write("        <div id=\"msg\"></div>\n");
      out.write("        \n");
   }  
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"js/Controller.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Redefinir sua senha</h1>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <form >\n");
      out.write("\t<label>E-mail:</label>\n");
      out.write("\t<input type=\"text\" id=\"txtEmail\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t<input type=\"button\" id=\"btnRedefinir\" value=\"Entrar\"/>\n");
      out.write("\t</form>\n");
      out.write("        <div id=\"msg\"></div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
