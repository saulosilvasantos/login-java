package dao;
import java.util.List;


import dao.UsuarioDAO;
import usuario.Conta;
import usuario.Usuario;
public class Test {

	public static void main(String[] args) {
		
                   //novaSenha();
                  //Confirmar_Conta_para_true();
		 //true_or_false_Conta();
		//obterIdUsuario();
               //cadastroAtivacao();
              //ativacaoConta();
             //verificarExistenciaEmail();
            //cadastrarUsuario();   
           //buscarEmail();    
             buscarDadosUsuario();
		
	}
        public static void buscarDadosUsuario() {
            Conta usu = new Conta();
            usu.setId("82");
            UsuarioDAO usuDao = new UsuarioDAO();
	    List <Conta> listaResultado = usuDao.buscarDadosUsuario(usu);
         
		for(Conta u: listaResultado){
                    
		    System.out.println("id: "+u.getId());
		    System.out.println("email: "+u.getEmail());
                    System.out.println("nome: "+u.getNome());
                    System.out.println("serial: "+u.getSerial_ativacao());
                    System.out.println("valor: "+u.isValor_ativacao());
                    System.out.println("senha: "+u.getSenha());
			
		}

        }
        
        
         public static void novaSenha() {
             /*
             8b5551ea922dd24625c45051c64adb50fdff91fecdf5327a02c7b0be3933965e
             06171a17f13ef63a510b96cadf8074bcc9a77d675e681f75e48734c4c14dd1c9
             a829c72c42755e384141ad8f163e4965ef5c9f8f0e07378c1d05a7222af0dd80
             15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225
             12bdc9eedc0abc0dc0f5a4c36836d8bac9a5b78de2e10a4747859a305f6d4535
             */
            UsuarioDAO usuDao = new UsuarioDAO();
            String senha = "15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225";
            int id = 82;
	    usuDao.novaSenha(senha, id);

        }
        
        public static void  Confirmar_Conta_para_true(){
            
            UsuarioDAO usuDao = new UsuarioDAO();
            String serial = "f391e014b2ee3a42955272b8fc78634de1d5833e0cacb412b180376f9c756e49";
            int id = 82;
	    usuDao.Confirmar_Conta_para_true(id, serial);
            
        }
        
        public static void true_or_false_Conta(){
            
            UsuarioDAO usuDao = new UsuarioDAO();
            int id = 82;
            Boolean conta = usuDao.true_or_false_Conta(id);
            
            if(conta){
                System.out.println("conta ativada");
            }else{
                System.out.println("conta desativada");
            }
            
        }
        
        public static void obterIdUsuario(){
            
            UsuarioDAO usuDao = new UsuarioDAO();
            String email = "www.saulosilva@gmail.com";
            Integer IdUsuario = usuDao.obterIdUsuario(email);
            System.out.println("ID: "+IdUsuario);
        }
        
        private static void cadastroAtivacao(){
            UsuarioDAO usuDao = new UsuarioDAO();
            int id_usuario = 84;
            String serial = "f391e014b2ee3a42955272b8fc78634de1d5833e0cacb412b180376f9c756e49";;
            Boolean valor_ativacao = false;
            usuDao.cadastroAtivacao(id_usuario,serial,valor_ativacao);
            
        }
        
        
        private static void ativacaoConta(){
            
            UsuarioDAO usuDao = new UsuarioDAO();
            String email = "www.saulosilva@gmail.com";
            String nome = "maelli";
            usuDao.ativacaoConta(email,nome);
        }
        
        
      private static void  verificarExistenciaEmail(){
        UsuarioDAO usuDao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setEmail("www.saulosilva@gmail.com.inf");
        usuario.setNome("Évertãoçriâs");
        usuario.setSenha("123456789");
        Integer status = usuDao.verificarExistenciaEmail(usuario);
        if(status==223){
                System.out.println("nome ok");
        }if(status==201){
                System.out.println("email ok");
        }if(status==202){
                System.out.println("senha ok");
        }if(status==200){
                System.out.println("cadastro ok");
        }if(status==707){
                System.out.println("email disponivel para cadastro, mas falhou em cadastrar");
        }if(status==101){
                System.out.println("email ja existe");
        }if(status==363){
                System.out.println("O campo nao pode ficar em branco!");
        }if(status==369){
                System.out.println("Nome nao deve conter caracter e numeros");
        }if(status==366){
                System.out.println("tamanho minio e 3");
        }if(status==444){
                System.out.println("Senha dever ter no minimi 8 Digito");
        }if(status==406){
                System.out.println("Erro: Caracter aceito apenas letras e numeros");
        }if(status==304){
                System.out.println("Email invalido");
        }
        
        }
        
        private static void  cadastrarUsuario() {
            
            UsuarioDAO usuDao = new UsuarioDAO();
            Usuario usuario = new Usuario();
            usuario.setEmail("www.saulosilva@gmail.com.info");
            usuario.setNome("Évertãoçriâs");
            usuario.setSenha("123456789");
            Boolean cadastro = usuDao.cadastrarUsuario(usuario);
            
            
            if(cadastro){
                 System.out.println("cadastro realizado com sucesso");
            }else{
                System.out.println("ERRO cadastro realizar");
            }
        }
        
        
        private static void  buscarEmail(){
            
            UsuarioDAO usuDao = new UsuarioDAO();
            Usuario usuario = new Usuario();
            usuario.setEmail("www.saulosilva@gmail.com");
            usuario.setSenha("15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225");
             List <Usuario> listaResultado = usuDao.buscarEmail(usuario);
         
		for(Usuario u: listaResultado){
                    
		    System.out.println("id: "+u.getId());
		    System.out.println("email: "+u.getEmail());
                    System.out.println("senha: "+u.getSenha());
			
		}
            
        }
        
        
        
        

}
