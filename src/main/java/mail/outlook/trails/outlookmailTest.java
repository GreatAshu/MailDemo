package mail.outlook.trails;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class outlookmailTest {
	
	public void outlookmail() throws MessagingException {
		String host = "smtp-mail.outlook.com";
		final String username = "ashutoshanand2020@outlook.com"; 
		final String password = "ashutosh@123";
		String[] to = { "ashutoshanand2020@outlook.com" };
		Properties props = new Properties();
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");

        try
        {
        Authenticator auth = new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          };

        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        msg.setText("Hey, this is the testing email.");
        msg.setSubject("Testing");
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("ashutoshanand2020@outlook.com"));
        Transport.send(msg);

        }catch (MessagingException mex) {
           mex.printStackTrace();
        }
		
		
		
	}
	
	public static void main(String[] args) throws MessagingException{
		outlookmailTest mail = new outlookmailTest();
		mail.outlookmail();
	}
	

}
