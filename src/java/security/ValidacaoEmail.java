package security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoEmail {
	
	
	
	 public static int setEmailValidacao(String email){
	        int isEmailIdValid = 304;
	        if (email != null && email.length() > 0) {
	            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	            Matcher matcher = pattern.matcher(email);
	            if (matcher.matches()) {
	                isEmailIdValid = 201;
	            }
	        }
	        return isEmailIdValid;
	    }
	
	
	public static void main(String[] args){
		
		
		int status = setEmailValidacao("saulo@gmail.com");
		if(status==304){
                    System.out.println("email invalido");
                }if(status==201){
                    System.out.println("email valido");
                }
		
	}
	

}
