package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;

import dao.UsuarioDAO;
import usuario.Usuario;
import security.Hash_SHA_256;

@WebServlet("/ControllerCadastro")
public class ControllerCadastro extends HttpServlet {

	String objectJson;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	    response.getWriter().print(objectJson);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nome = request.getParameter("Nome");
		String email = request.getParameter("Email");
		String senha = request.getParameter("Senha");
		
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);

		Integer status = usuarioDao.verificarExistenciaEmail(usuario);
			
		
		
		
		if(status.equals(200) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
		if(status.equals(707) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
		if(status.equals(101) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
		if(status.equals(404) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
		
		if(status.equals(304) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
		if(status.equals(444) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
		if(status.equals(406) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
        if(status.equals(363) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
		if(status.equals(369) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}
		if(status.equals(366) ){
			
			objectJson = "{\"usuario\":[{\"status\":\""+status+"\",\"email\":\""+email+"\",\"senha\":\""+senha+"\"}]}";
		}

		
		System.out.println("Status "+status);
		System.out.println("Cadastro Nome: "+nome+" Email: "+email+" Senha: "+senha);
	
		
	}

}