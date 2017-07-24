package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hash_SHA_256 {
	
	
	
	private static String stringHexa(byte[] bytes) {
		   StringBuilder s = new StringBuilder();
		   for (int i = 0; i < bytes.length; i++) {
		       int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
		       int parteBaixa = bytes[i] & 0xf;
		       if (parteAlta == 0) s.append('0');
		       s.append(Integer.toHexString(parteAlta | parteBaixa));
		   }
		   return s.toString();
		}


		public static byte[] gerarHash(String frase, String algoritmo) {
		  try {
		    MessageDigest md = MessageDigest.getInstance(algoritmo);
		    md.update(frase.getBytes());
		    return md.digest();
		  } catch (NoSuchAlgorithmException e) {
		    return null;
		  }
		}

		
		
		public static String criptografar(String Hash){
			
			return Hash = stringHexa(gerarHash(Hash, "SHA-256"));
			
		}
		
		public static Boolean compararHashPorHash(String Hash){
			
			String dado = stringHexa(gerarHash(Hash, "SHA-256"));
			
			
			if(dado.equals(Hash)){
				
				return true;
				
			}else{
				
				return false;
				
			}
	
		}
		
		
	    public static String numeroAleartorio() {
	        Random gerador = new Random();
	        int numero = gerador.nextInt(999);    
	        String Hash = ""+numero;
	        Hash =  criptografar(Hash);
	        return Hash;
	    }
	    
		
		

	public static void main(String[] args) {
              
		          String frase = "saulo";
			  
			  String SHA_256 = stringHexa(gerarHash(frase, "SHA-256"));
			  String MD5 = stringHexa(gerarHash(frase, "MD5"));
			  String SHA_1 = stringHexa(gerarHash(frase, "SHA-1"));
			  
			  System.out.println("SHA_256: "+criptografar(frase));
			  System.out.println("MD5: "+MD5);
			  System.out.println("SHA_1: "+SHA_1);
			  System.out.println("numero aleartorio: "+numeroAleartorio());
			  System.out.println("comparar Hash: "+compararHashPorHash(SHA_256));
			  

			} 

		
		

}
