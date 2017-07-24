$(document).ready(function(){
	
	
	//enviar em formato JSON - LOGIN
	$("#btnEntrar").click(function (){
		txtEmail = $("#txtEmail").val();
		txtSenha = $("#txtSenha").val();
		$.post("ControllerLogin", { Email:txtEmail, Senha:txtSenha } , function(data, status){
			Login();
		});

	});
	
	
	//enviar em formato JSON - CADASTRO
	$("#btnSalvar").click(function (){
                document.getElementById("msg").innerHTML = ("Aguarde cadastrando...");
		txtNome = $("#txtNome").val();
		txtEmail = $("#txtEmail").val();
		txtSenha = $("#txtSenha").val();
		$.post("ControllerCadastro", { Nome:txtNome, Email:txtEmail, Senha:txtSenha } , function(data, status){
			statusCadastro();
		});

	});
	
	//enviar em formato JSON - CADASTRO
	$("#btnRedefinir").click(function (){
                document.getElementById("msg").innerHTML = ("Aguarde enviando email...");
		txtEmail = $("#txtEmail").val();
		$.post("ControllerRedefinirSenha", { Email:txtEmail } , function(data, status){
		document.getElementById("msg").innerHTML = ("Email enviado com sucesso <br> <a href='index.jsp'>Voltar</a>");
		});

	});
        
        //enviar em formato JSON - CADASTRO
	$("#btnNovaSenha").click(function (){
                document.getElementById("msg").innerHTML = ("Aguarde registrando nova senha...");
		txtSenha = $("#txtSenha").val();
                txtId = $("#txtId").val();
                txtSerial = $("#txtSerial").val();
                txtEmail = $("#txtEmail").val();
		$.post("ControllerSenhaRecuperada", { Email:txtEmail, Senha:txtSenha, Id:txtId, Serial:txtSerial } , function(data, status){
			statusSenhaRecuperada();
		});

	});
        
        
});//fim 



function statusSenhaRecuperada(){
	
	
	 $.get("ControllerSenhaRecuperada", function(data, status) {
			

			var objDados = JSON.parse(data);

			
			var email,senha,id,sessao,homepage,status;
			for(i=0; i < objDados.usuario.length; i++){
					
				email=objDados.usuario[i].email;
				senha=objDados.usuario[i].senha;
				status=objDados.usuario[i].status;
			}
			
			if(status==202){
				txtEmail = email;
				txtSenha = senha;
				$.post("ControllerLogin", { Email:txtEmail, Senha:txtSenha } , function(data, status){
					Login();
				});
			}
			if(status==707){
				document.getElementById("msg").innerHTML = ("Erro de Cadastrar tente novamente");
			}
			if(status==404){
				document.getElementById("msg").innerHTML = ("Erro inesperados tente mais tarde");
			}
			if(status==444){
				document.getElementById("msg").innerHTML = ("Senha dever ter no minimi 8 Digito");
			}
			if(status==406){
				document.getElementById("msg").innerHTML = ("Erro: Caracter aceito apenas letras e numeros");
			}
			
	});
	
	
	
}//fim




function statusCadastro(){
	
	
	 $.get("ControllerCadastro", function(data, status) {
			

			var objDados = JSON.parse(data);

			
			var email,senha,id,sessao,homepage,status;
			for(i=0; i < objDados.usuario.length; i++){
					
				email=objDados.usuario[i].email;
				senha=objDados.usuario[i].senha;
				status=objDados.usuario[i].status;
			}
			
			if(status==200){
				txtEmail = email;
				txtSenha = senha;
				$.post("ControllerLogin", { Email:txtEmail, Senha:txtSenha } , function(data, status){
					Login();
				});
			}
			if(status==101){
				document.getElementById("msg").innerHTML = ("Email "+email+" Ja em uso");
			}
			if(status==707){
				document.getElementById("msg").innerHTML = ("Erro de Cadastrar tente novamente");
			}
			if(status==404){
				document.getElementById("msg").innerHTML = ("Erro inesperados tente mais tarde");
			}
			if(status==444){
				document.getElementById("msg").innerHTML = ("Senha dever ter no minimi 8 Digito");
			}
			if(status==406){
				document.getElementById("msg").innerHTML = ("Erro: Caracter aceito apenas letras e numeros");
			}
			if(status==304){
				document.getElementById("msg").innerHTML = ("Email invalido");
			}
			if(status==363){
				document.getElementById("msg").innerHTML = ("O campo Nome não pode ficar em branco!");
			}
			if(status==369){
				document.getElementById("msg").innerHTML = ("Nome nao deve conter caracter e numeros");
			}
			if(status==366){
				document.getElementById("msg").innerHTML = ("tamanho nome deve ter no minimo 3 palavras");
			}
			
	});
	
	
	
}//fim






function Login(){
	 $.get("ControllerLogin", function(data, status) {
			var objDados = JSON.parse(data);

			var email,senha,id,sessao,homepage;
			for(i=0; i < objDados.usuario.length; i++){
			
				email=objDados.usuario[i].email;
				senha=objDados.usuario[i].senha;
			}
			for(i=0; i < objDados.usuario.length; i++){
			
				id=objDados.usuario[i].id;
				sessao=objDados.usuario[i].sessao;
				homepage=objDados.usuario[i].homepage;
			}
			
			if(email !="null" && senha!="null"){
				
				var redirect = function(url, method,id,sessao) {
				    var form = document.createElement('form');
				    form.method = method;
				    form.action = url;
				    form.submit();
				    $("body").append(form);
				    var input = document.createElement('input');
				    input.type = "hidden";
				    input.name = "txtId";
				    input.value = id;
				    form.appendChild(input);
				    form.submit();
				   $("body").append(form);
				    var input = document.createElement('input');
				    input.type = "hidden";
				    input.name = "txtSessao";
				    input.value = sessao;
				    form.appendChild(input);
				    form.submit(); 
				    $("body").append(form);
				    
				};
				redirect(homepage, 'POST',id,sessao);
				
				
	
			}if(email=="null" && senha=="null"){
				document.getElementById("msg").innerHTML = ("login e senha inestente");
			}else{
				if(senha=="null"){
			           document.getElementById("msg").innerHTML = ("senha errado");
                                   document.getElementById("RecuperarSenha").innerHTML = ("<a href='redefinirSenha.jsp'>Recuperar senha</a>");
				}
			}
			
			
			
	});
}



