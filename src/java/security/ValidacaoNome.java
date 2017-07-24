package security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoNome {

	
	public static Integer setNomeValidacao(String nome){
		
		Integer tamanhoMinimo = 3;
		Integer status = 0;
		
		if(nome == ""){
			status = 363; //O campo nao pode ficar em branco!
		}
		else{
			Pattern pattern = Pattern.compile("[^a-zA-ZÀÁÂĖÈÉÊÌÍÒÓÔÕÙÚÛÇàáâãèéêìíóôõùúç' ']");
			Matcher matcher = pattern.matcher(nome);
			if(matcher.find()){
				status = 369; //Nao deve conter caracter e numeros
			}else{
				if(nome.length() < tamanhoMinimo){
					status = 366; //tamanho minio e 3
				}else{
					status = 223;
				}
			}		
		}
		return status;
	}
	
	public static void main(String[] args){
		
		
		int status = setNomeValidacao("Félix Ângel");
		System.out.println(status);
		
	}
	
	

}