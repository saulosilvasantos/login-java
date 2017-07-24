package Core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexaoBancoPostgreSQL {
	
	
	private static final String  SENHA = "203327";	
	private static final String  USERNAME = "postgres";
	private static final String  NOME_BANCO = "ajax";
	private static final String  HOST = "localhost";
	private static final String  PORTA = "5432";
	private static final String  DRIVER= "jdbc:postgresql";
	private static final String  URL = DRIVER+"://"+HOST+":"+PORTA+"/"+NOME_BANCO;
    public static Connection abrirConexao(){
		    Connection  con = null;
		    try {

                        Class.forName("org.postgresql.Driver");
                        con = DriverManager.getConnection(URL,USERNAME,SENHA);
                        System.out.print("conexao efetuada com sucesso\n");
                    
		    } catch (SQLException e) {
		  	  
		        System.out.println("No pode conectar  \n" + e.getMessage());
		                                   
		             
		    }catch (ClassNotFoundException e) {
		    	  
			System.out.println("Driver No pode conectar  \n" + e.getMessage());
		                                                               
		    }
		    return con;
     }
}
