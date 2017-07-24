package mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.UsuarioDAO;
import security.Hash_SHA_256;
import usuario.Usuario;


@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {
	
	List <Usuario> listaResultado = new ArrayList<>();
	String objectJson="";
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = null;
	
		 if(objectJson !=""){

				 json = objectJson;
				 objectJson= "";
				 System.out.println("A "+json);
		 }else{
				ObjectMapper mapper = new ObjectMapper();
				String j = mapper.writeValueAsString(listaResultado);
			    json = "{\"usuario\":" + j + "}";
			    System.out.println("B "+json);
		 }

		
	
	    response.getWriter().print(json);
	    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("Email");
		String senha = request.getParameter("Senha");
		
		System.out.println("- "+email+senha);
		
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Hash_SHA_256 hash = new Hash_SHA_256();
		String senhaHash = hash.criptografar(senha);
		
		usuario.setEmail(email);
		usuario.setSenha(senhaHash);
		
		System.out.println("-+ "+usuario.getEmail()+usuario.getSenha());
		HttpSession sesion= request.getSession();
		String sessao = hash.numeroAleartorio();
		String homepage = "Home.jsp";

		
		listaResultado = usuarioDao.buscarEmail(usuario);
		
		
		for(Usuario u: listaResultado){
			
			if( u.getEmail() !="null" && u.getSenha() !="null"){
				
				  System.out.println("C "+u.getId()+" "+ u.getEmail()+" "+u.getSenha());
				     
		          sesion.setAttribute(sessao,sessao);
		          response.sendRedirect(homepage);
		          objectJson = "{\"usuario\":[{\"id\":\""+u.getId()+"\",\"sessao\":\""+sessao+"\",\"homepage\":\""+homepage+"\"}]}";
				
			}

	    }
	
	}
	
}
