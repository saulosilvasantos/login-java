package email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saulo
 */
public class redefinirSenha {

   //http://www.journaldev.com/2532/javamail-example-send-mail-in-java-smtp
	  public static void sendEmail(Session session, String toEmail, String subject, String body,String html){
			
			try
		    {
		      MimeMessage msg = new MimeMessage(session);
		      //set message headers
		      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		      msg.addHeader("format", "flowed");
		      msg.addHeader("Content-Transfer-Encoding", "8bit");

		      msg.setFrom(new InternetAddress("suporty.caifnet@gmail.com", "caifnet"));

		      msg.setReplyTo(InternetAddress.parse("no_reply_caifnet@gmail.com", false));

		      msg.setSubject(subject, "UTF-8");

		      msg.setText(body, "UTF-8");

		      msg.setSentDate(new Date());

		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		      
		      
		      
		      
	         //Create the message body part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         messageBodyPart.setText(body);
	         
	         //Create a multipart message for attachment
	         Multipart multipart = new MimeMultipart();

	         //Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         //third part for displaying image in the email body
	         messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setContent(html, "text/html");
	         multipart.addBodyPart(messageBodyPart);
	         
	         //Set the multipart message to the email message
	         msg.setContent(multipart);
	      
	      
		      
		      
		      System.out.println("Message is ready");
	    	  Transport.send(msg);  

		      System.out.println("EMail Sent Successfully!!");
		    
			  }catch (MessagingException e) {
			         e.printStackTrace();
			      } catch (UnsupportedEncodingException e) {
					 e.printStackTrace();
				}
			}
	
	
		public static void Email(String nomeUsuario, String emailUsuario,Integer id, String serial) {
	
			
			final String fromEmail = "www.saulosilva@gmail.com"; //Requer ID válido do Gmail
			final String password = "************"; // Senha correta para o ID do Gmail
			
			System.out.println("SSLEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
			props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			props.put("mail.smtp.port", "465"); //SMTP Port
			props.put("mail.smtp.port", "587"); //TLS Port
			
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			
			Session session = Session.getDefaultInstance(props, auth);
			
			final String nome = nomeUsuario;
			final String toEmail = emailUsuario;
			final String titulo = "Redefinir senha";
			final String msg = "";
			
			String url = "http://localhost:8080/login/ControllerRedefinirSenha?id="+id+"&serial="+serial+"&email="+emailUsuario;
			String html = " "  
					   + "Ola "+nome+" Parece que você está tendo problemas para fazer login. Basta clicar no botão abaixo.<br/>"
					   + "Clique no botão abaixo para redefinir sua senha<br/>"
					   + "<br/>"
					   +"<a href='"+url+"'><button>redefinir sua senha</button></a>"
					   + "<br/>"
					   + "<br/>"
					   + "<br/>"
					   + "Com os melhores cumprimentos,<br> Equipe CAIFNET<br/>"		   
					   + "<br/>"
					   + "<br/>"
					   + "Obs: Este e-mail é automático e não é necessário ser respondido";
			
			sedEmail.sendEmail(session, toEmail,titulo,msg,html);
      

	}
                
                public static void main(String[] args) {
                    
                    Email("saulo", "www.saulosilva@gmail.com",83,"kclbjndjgizbncmv2n85d952v5");
                    
                }
                
                
	
    
}
