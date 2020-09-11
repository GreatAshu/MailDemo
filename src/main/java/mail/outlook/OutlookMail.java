package mail.outlook;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class OutlookMail {

	public void outlookmail() throws MessagingException {
		String host = "smtp-mail.outlook.com";
		String username = "ashutoshanand2020@outlook.com"; 
		String password = "ashutosh@123";
		String[] to = { "ashutoshanand2020@outlook.com" };
		Properties props = new Properties();
		//props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);

		
		
		try {
			int size = to.length;
			for (int i = 0; i < size; i++) {
				MimeMessage msg = new MimeMessage(session);
				// set the message content here
				msg.setFrom(new InternetAddress(username));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to[i]));
				msg.setSubject("Testing!!");
				BodyPart msgbodypart = new MimeBodyPart();
				msgbodypart.setText("This is message body part");
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(msgbodypart);
				msg.setContent(multipart);
				Transport.send(msg, username, password);
			}
		} catch (MessagingException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws MessagingException {
		OutlookMail mail = new OutlookMail();
		mail.outlookmail();
	}

}
