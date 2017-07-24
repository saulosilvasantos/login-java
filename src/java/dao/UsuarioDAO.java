package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.ConexaoBancoPostgreSQL;
import email.sedEmail;
import usuario.Usuario;
import security.Hash_SHA_256;
import security.ValidacaoEmail;
import security.ValidacaoNome;
import security.ValidacaoSenha;
import usuario.Conta;

public class UsuarioDAO {

	
	
	

	
	private static final Connection abrirConexao(Connection con){
	       con = null;
		if(con == null){
		   con = ConexaoBancoPostgreSQL.abrirConexao();
		}
	    return con;
	}
	
        
        
        public void novaSenha(String senha, int id){
            
          
            
         String sql = "UPDATE usuario   SET  senha_usuario = ? WHERE id_usuario = ?";
         PreparedStatement preparador = null;
         Connection conexao = null;
		try{
		     conexao = abrirConexao(conexao);
	             preparador = conexao.prepareStatement(sql);
		     preparador.setString(1, senha);
                     preparador.setInt(2, id);
			preparador.execute();
			preparador.close();
			conexao.close();
	    } catch (SQLException e){
	    	
	    	e.printStackTrace();
	    	
	       }finally{
		    	   
			    conexao = null;
			    preparador = null;
			    
		  
	       }
          
     }
      
    public List <Conta> buscarDadosUsuario(Conta id){
     /**String sql = "SELECT usuario.id_usuario,usuario.nome_usuario,usuario.email_usuario,usuario.senha_usuario,ativacao.serial_ativacao,ativacao.valor_ativacao  FROM usuario,ativacao WHERE usuario.id_usuario = 83 and ativacao.id_usuario =83";*/
        String sql = "SELECT usuario.id_usuario,usuario.nome_usuario,usuario.email_usuario,usuario.senha_usuario,ativacao.serial_ativacao,ativacao.valor_ativacao  FROM usuario,ativacao WHERE usuario.id_usuario = ? and ativacao.id_usuario = ?"; 
        List<Conta> lista = new ArrayList<Conta>();
       PreparedStatement preparador = null;
		ResultSet resultado = null;
		Connection conexao = null;
		try{
			conexao = abrirConexao(conexao);
			preparador = conexao.prepareStatement(sql);
                        int idInt = Integer.parseInt(id.getId());
			preparador.setInt(1, idInt);
                        preparador.setInt(2, idInt);
			resultado = preparador.executeQuery();
			
		        Conta conta = new Conta();
			while(resultado.next()){

				
		                conta.setEmail(resultado.getString("email_usuario"));
				conta.setNome(resultado.getString("nome_usuario"));
                                conta.setSerial_ativacao(resultado.getString("serial_ativacao"));
                                conta.setValor_ativacao(resultado.getBoolean("valor_ativacao"));
                                conta.setSenha(resultado.getString("senha_usuario"));
                                conta.setId(resultado.getString("id_usuario"));
	
			}
			
			lista.add(conta);
			resultado.close();
			preparador.close();
			conexao.close();
	
			
    } catch (SQLException e){
    	
    	e.printStackTrace();
    	
       }finally{
	    	   
		    conexao = null;
		    preparador = null;
		    resultado = null;
	  
       }
		

		return lista;
		
	}
	
        
        
        
      public void  Confirmar_Conta_para_true(Integer id, String serial){
        
          String sql = "UPDATE ativacao   SET  valor_ativacao = true WHERE id_usuario = ? AND serial_ativacao = ? ";
          PreparedStatement preparador = null;
          Connection conexao = null;
		try{
		     conexao = abrirConexao(conexao);
	             preparador = conexao.prepareStatement(sql);
		     preparador.setInt(1, id);
                     preparador.setString(2, serial);
			preparador.execute();
			preparador.close();
			conexao.close();
	    } catch (SQLException e){
	    	
	    	e.printStackTrace();
	    	
	       }finally{
		    	   
			    conexao = null;
			    preparador = null;
			    
		  
	       }
          
     }
        
        
        public Boolean true_or_false_Conta(Integer id){
        
            Boolean conta = null;
            String sql = "SELECT valor_ativacao FROM ativacao where id_usuario = ?";
            
            PreparedStatement preparador = null;
		ResultSet resultado = null;
		Connection conexao = null;
		try{
		     conexao = abrirConexao(conexao);
			 preparador = conexao.prepareStatement(sql);
		         preparador.setInt(1, id);
			 resultado = preparador.executeQuery();
		
				if(resultado.next()){
					
					conta =  resultado.getBoolean("valor_ativacao");
			    	
				}
				resultado.close();
				preparador.close();
				conexao.close();
	    } catch (SQLException e){
	    	
	    	e.printStackTrace();
	    	
	       }finally{
		    	   
			    conexao = null;
			    preparador = null;
			    resultado = null;
		  
	       }
            
            
            return conta;
        
        }
        
        

        
        
	public Integer obterIdUsuario(String email){
		Integer id_usuario = null;
		String sql = "SELECT id_usuario FROM usuario where email_usuario = ?";
		PreparedStatement preparador = null;
		ResultSet resultado = null;
		Connection conexao = null;
		try{
		     conexao = abrirConexao(conexao);
			 preparador = conexao.prepareStatement(sql);
		         preparador.setString(1, email);
			 resultado = preparador.executeQuery();
		
				if(resultado.next()){
					
					id_usuario =  resultado.getInt("id_usuario");
			    	
				}
				resultado.close();
				preparador.close();
				conexao.close();
	    } catch (SQLException e){
	    	
	    	e.printStackTrace();
	    	
	       }finally{
		    	   
				conexao = null;
			    preparador = null;
			    resultado = null;
		  
	       }
		
		return id_usuario;
	}
	
	public void cadastroAtivacao(int id_usuario, String serial, Boolean valor_ativacao){
			
			String sql = "INSERT INTO ativacao( id_usuario, serial_ativacao, valor_ativacao)VALUES (?, ?, ?)";
			PreparedStatement preparador = null;
			Connection conexao = null;
			try{
			conexao = abrirConexao(conexao);
		        preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, id_usuario);
			preparador.setString(2, serial);
			preparador.setBoolean(3, valor_ativacao);
			preparador.execute();
			preparador.close();
			conexao.close();
			
			} catch (SQLException e){
		    	
		    	e.printStackTrace();
		    	
		       }finally{
			    	   
			            conexao = null;
				    preparador = null;
			  
		       }
			
		}
	
	public void ativacaoConta(String email,String nome){
		Hash_SHA_256 criarSerial = new Hash_SHA_256();
		
		Integer id_usuario = obterIdUsuario(email);
		String serial = criarSerial.numeroAleartorio();
		Boolean valor_ativacao = false;
                String  sessao = null;

		cadastroAtivacao(id_usuario,serial,valor_ativacao);
		sedEmailUsuario(nome, email, id_usuario,serial,sessao);
		
	}
	public void sedEmailUsuario(String nome, String email, int id_usuario, String serial,String sessao){
              
                sedEmail sedEmail = new sedEmail();
                sedEmail.Email(nome, email, id_usuario,serial,sessao);
        }
	
	public Integer verificarExistenciaEmail(Usuario usuario) {
		                  Integer status = 404;
				  List <Usuario> listaResultado = new ArrayList<>();
				  listaResultado=buscarEmail(usuario);
				  
				  ValidacaoEmail email = new ValidacaoEmail();
				  ValidacaoSenha senha = new ValidacaoSenha();
				  ValidacaoNome nome = new ValidacaoNome();
				  Hash_SHA_256 hash = new Hash_SHA_256();
				  
				  Integer senhaStatus = senha.setSenhaValidacao(usuario.getSenha());
				  Integer emailStatus = email.setEmailValidacao(usuario.getEmail());
				  Integer nomeStatus  = nome.setNomeValidacao(usuario.getNome());
				  String  emailAtivacao = usuario.getEmail();
				  String  nomeAtivacao  = usuario.getNome();
				  
		          for(Usuario u: listaResultado){
		  			
		        	if(nomeStatus.equals(223)){  
		        		
		        	  if(emailStatus.equals(201)){
		        		  
		        		  if(senhaStatus.equals(202)){  
	        				String senhaHash = hash.criptografar(usuario.getSenha());//criotografa a senha
	        				usuario.setSenha(senhaHash);
											  			if( u.getEmail().equals("null")){
									
											  	  				         Boolean cadastro = cadastrarUsuario(usuario);
											  	  				         if(cadastro){
											  	  				        	          
											  	  				        	          ativacaoConta(emailAtivacao,nomeAtivacao);
											  	  				        	          status = 200;//castro realizado com sucesso
											  	  				        	          
											  	  				        	
											  	  				           }else{
											  	  				        	   
															  					 status = 707;//email disponivel para cadastro, mas falhou em cadastrar
														  		                
											  	  				           } 
											  	  				        
											  			    }else{
											  			        	    
																  status = 101;//email ja existe	
																	  
											                }
											  			
											  			
											  			
							        		  }else{
							        			  status =  senhaStatus;
							        			  
							        		  }  			
							        	     
		        	        }else{
		        	        	
		        	        	
		        	        	status = emailStatus;
		        	        	
		        	        }
		        	  
		          }else{
		        	  
		        	  status = nomeStatus;
		          }
			 
		     }
 

			return status;

	}
	
	

	public Boolean cadastrarUsuario(Usuario usu) {
		String sql = "INSERT INTO  usuario (nome_usuario,email_usuario,senha_usuario)  VALUES (?,?,?)";
		Boolean cadastro = false;
		PreparedStatement preparador = null;
		Connection conexao = null;
		try{
		conexao = abrirConexao(conexao);
		preparador = conexao.prepareStatement(sql);
		preparador.setString(1,usu.getNome());
		preparador.setString(2,usu.getEmail());
		preparador.setString(3,usu.getSenha());
	        preparador.execute();
		preparador.close();
		conexao.close();
	        cadastro = true;

	    }catch(SQLException e){
	    	
	    	e.printStackTrace();
	    	
	       }finally{
		    	   
				conexao = null;
			    preparador = null;
		  
	       }

		return cadastro;
		
	}
	
	
	
	/* ### VALIDAR EMAIL ###
	 * este metodo valida email, se o email e senha existe ou nao
	 * se existir retorna o email senao retorna falso
	 * */
	public List<Usuario> buscarEmail(Usuario usuario){
	    String sql = " SELECT * FROM usuario WHERE email_usuario = ? ";
	    List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement preparador = null;
		ResultSet resultado = null;
		Connection conexao = null;
		try{
			conexao = abrirConexao(conexao);
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getEmail());
			resultado = preparador.executeQuery();
			
		        Usuario usu = new Usuario();
			usu.setEmail("null"); 
			usu.setSenha("null");
			while(resultado.next()){

				
				if( resultado.getString("email_usuario").equals(usuario.getEmail()) ){
					usu.setEmail(resultado.getString("email_usuario"));
				}
				if( resultado.getString("senha_usuario").equals(usuario.getSenha()) ){
					
				    usu.setSenha(resultado.getString("senha_usuario"));
				    usu.setId(resultado.getString("id_usuario"));
				}
				
	
			}
			
			lista.add(usu);
			resultado.close();
			preparador.close();
			conexao.close();
	
			
    } catch (SQLException e){
    	
    	e.printStackTrace();
    	
       }finally{
	    	   
		    conexao = null;
		    preparador = null;
		    resultado = null;
	  
       }
		

		return lista;
		
	}
	
	
	
	
	
}


/**
CREATE TABLE public.usuario
(
  id_usuario SERIAL NOT NULL,
  nome_usuario character varying(40) NOT NULL,
  email_usuario character varying(100) NOT NULL,
  senha_usuario character varying(64),
  CONSTRAINT email_usuario_uk UNIQUE (email_usuario),
  CONSTRAINT id_usuario_key PRIMARY KEY (id_usuario)
);
CREATE TABLE public.ativacao
(
  id_ativacao SERIAL NOT NULL ,
  id_usuario INT NOT NULL,
  serial_ativacao character varying(64) NOT NULL,
  valor_ativacao boolean NOT NULL,
  CONSTRAINT id_ativacao_key PRIMARY KEY (id_ativacao),
  CONSTRAINT id_usuario_uk UNIQUE (id_usuario),
  CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) references usuario(id_usuario)
);
*/