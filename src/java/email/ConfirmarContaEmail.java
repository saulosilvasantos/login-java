package email;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import email.sedEmail;
import javax.servlet.http.HttpSession;


@WebServlet("/ConfirmarContaEmail")
public class ConfirmarContaEmail extends HttpServlet {
    //http://localhost:8080/ajax/ConfirmarContaEmail?id=25&serial=133456789
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
            
            try {
            
                        String id_TXT = request.getParameter("id");
                        Integer id_INT = Integer.parseInt(id_TXT);
                        String sessao = request.getParameter("sessao");
                        String serial = request.getParameter("serial");
                        UsuarioDAO usuDAO = new UsuarioDAO();
                        Boolean  conta = usuDAO.true_or_false_Conta(id_INT);
                        System.out.println("ConfirmarEmail \n id: "+id_INT+" sessao: "+sessao+" serial: "+serial+"");
                        if(conta == false){
                          usuDAO.Confirmar_Conta_para_true(id_INT,serial);

                          response.sendRedirect("ativarConta.jsp");
                        }else{
                        response.sendRedirect("index.jsp");
                        }
                    }catch (NumberFormatException e) {
                      response.sendRedirect("index.jsp");
               }catch (NullPointerException e) {
                      response.sendRedirect("index.jsp");
              }

	}

	
}
