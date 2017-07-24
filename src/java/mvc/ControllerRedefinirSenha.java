/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDAO;
import java.util.List;
import usuario.Conta;
import email.redefinirSenha;
import javax.servlet.http.HttpSession;

/**
 *
 * @author saulo
 */
@WebServlet(name = "ControllerRedefinirSenha", urlPatterns = {"/ControllerRedefinirSenha"})
public class ControllerRedefinirSenha extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
         String email = request.getParameter("Email");
   
         Conta usuario = new Conta();
         UsuarioDAO usuDao = new UsuarioDAO();
         
         int id = usuDao.obterIdUsuario(email);
         String idTXT= ""+id;
         usuario.setId(idTXT);
         
         List <Conta> listaResultado = usuDao.buscarDadosUsuario(usuario);
         
                String nome=null,serial=null;
		for(Conta u: listaResultado){
		    serial = u.getSerial_ativacao();
                    nome = u.getNome();	
                    
		}
                
          redefinirSenha.Email(nome, email, id, serial);
         
         
    }
    
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
       
       
         String id = request.getParameter("id");
         String serial = request.getParameter("serial");
         String email = request.getParameter("email");
        
         
         
         System.out.println(id);
         System.out.println(serial);
         
         HttpSession sesion = request.getSession();
         
         
         sesion.setAttribute("id",id);   
         sesion.setAttribute("email",email); 
         sesion.setAttribute("serial",serial); 
         sesion.setAttribute("pageSesion",0); 
         response.sendRedirect("redefinirSenha.jsp");
         
     
     
         
    }

}
