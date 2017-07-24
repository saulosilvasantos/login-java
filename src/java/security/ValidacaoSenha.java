package security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoSenha {

	
	
	public static void main(String[] args) {
        
	
		  
		Integer status = setSenhaValidacao("12345678");
		  
		  
		 if(status.equals(444)){
			
			System.out.println("Senha dever ter no minimi 8 Digito");
		 }
		 if(status.equals(406)){
		
		       System.out.println("Erro: Caracter aceito apenas letras e numeros");
	         }
	         if(status.equals(202)){
				
		       System.out.println("senha aceita com sucesso");
		 }
			
		
       
		
		
		  

		} 
	
	
	public static Integer setSenhaValidacao(String Senha){
		Integer	status = 404;
		int tamanhoMinimo = 8;
	   
	  if ((Senha.length() < tamanhoMinimo)){// Verificando tamanho minimo
		  
		  status = 444;
		  
	  }else{
		  status = senha(Senha);
	  }
	  
	  return status;
	}
	
	

	//recebe a senha
	public static Integer senha(String s) {
	    char r = (char) 0;
	    Integer  status = null;
	    for (char c : s.toCharArray()) {//ler caracter por caracter
	        r = c;
	        String asString = Character.toString(r);//converte o caracter em string
	        Boolean caracter =  Regex(asString);//envia o caracter para ser aveliado ou seja so aceita a-z | A-Z | 0-9
	        if(!caracter){//se o caracter for diferente de verdadeiro
	        	status = 406;//receber falso
	        	break;//o programa para de ler
	        }else{
	        	status = 202;// todos caracter sao a-z | A-Z | 0-9
	        }
	    }
	    return status;
	}
	
	
	
	
	
	//valida a senha
	public static Boolean Regex(String caracter) {

	        Boolean status = null;
  
        if (caracter != null && caracter.length() > 0) {
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
            Matcher matcher = pattern.matcher(caracter);
            
		            if (!matcher.matches()) {
		            	status = true;
		            	
		            }else{
		            	status = false;
		            	
		            }
            
        }
        
        
		return status;
        
	}
	
	
	
	
	
	
}
