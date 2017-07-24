/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import dao.UsuarioDAO;
import email.redefinirSenha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import usuario.Conta;
import security.ValidacaoSenha;
import security.Hash_SHA_256;
import usuario.Usuario;


/**
 *
 * @author saulo
 */
@WebServlet(name = "ControllerSenhaRecuperada", urlPatterns = {"/ControllerSenhaRecuperada"})
public class ControllerSenhaRecuperada extends HttpServlet {
    
    String objectJson;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
          response.getWriter().print(objectJson);
    }

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
        
         String id = request.getParameter("Id").trim();
         String serial = request.getParameter("Serial").trim();
         String senha = request.getParameter("Senha").trim();
         String email = request.getParameter("Email").trim();

        ValidacaoSenha vs = new ValidacaoSenha();
        Integer status = vs.setSenhaValidacao(senha);
        
        
         if(status.equals(444)){
             
		objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";		
            }
         if(status.equals(406)){
            
                objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
	    }
	 if(status.equals(202)){
             UsuarioDAO usuDAO = new UsuarioDAO();
             Hash_SHA_256 hash = new Hash_SHA_256();  
	     String senhaHash = hash.criptografar(senha);//criotografa a senha
             int ID = Integer.parseInt(id);
             usuDAO.novaSenha(senhaHash,ID);
             objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
                 
	   }
             
             
             
             
        
       
        
       

   
   
   
    }

   
}
