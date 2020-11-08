package product.app;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailServiceThirdParty {
	
	private static final Logger LOGGER = Logger.getLogger(EmailServiceThirdParty.class.getName());
	
	public void sendEmail(String email, String answer) {
		String to = email;
		String from = "s11819431@stu.najah.edu";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true"); 
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        	
        	@Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("s11819431@stu.najah.edu", "Yazan_Habash@1142000");

            }

        });
        session.setDebug(true);
        
		try {
			// Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field

            // Now set the actual message
            message.setText(answer);
            
            // Send message
            Transport.send(message);
		} catch(MessagingException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		
	}
}
