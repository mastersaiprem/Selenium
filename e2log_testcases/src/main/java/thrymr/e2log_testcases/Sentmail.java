package thrymr.e2log_testcases;

import java.security.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.management.MXBean;

import com.sendgrid.Response;
import org.springframework.ui.velocity.VelocityEngineUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class Sentmail {

	
	
	public static void main(String[] args) {


		try {
			Properties props = new Properties();
			InputStream input = null;
			input = new FileInputStream("mail.properties");
			props.load(input);
			final String username = props.getProperty("username");
			final String password = props.getProperty("password");
			final String toaddress = "suryajyoti.bisen@thrymr.net";
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			Session session = Session.getInstance(props, new GMailAuthenticator(username, password));
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("no_reply@example.com", "noreplay@e2log.com"));
			InternetAddress[] toAdressArray = InternetAddress.parse(toaddress);
			message.setRecipients(Message.RecipientType.TO, toAdressArray);
			// message.setRecipients(Message.RecipientType.TO, arg1);
			message.setSubject("e2log_html_report");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart = new MimeBodyPart();
			String filename = "/home/thrymr/e2log.csv";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport tr = session.getTransport("smtp");
			tr.connect("smtp.gmail.com", username, password);
			tr.send(message);
			tr.close();
			System.out.println("Mail Sent to " + toaddress);
		}
		
		
		
		
		catch (IOException ie) {
			throw new RuntimeException(ie);
		}

		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	
	/*public void template(String toMail) {
		
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("name", "Customer");
		
		StringBuilder bodyText = new StringBuilder();
		bodyText.append("We have received your request to register on e2log platform as "
		
		+ ". An e2log representative will get in touch with you and guide you through onboarding process.");
		model.put("body", bodyText.toString());
		String path = "emailtest.vm";
//		sendMail(toMail, model, path, "Registration Request Received");
		
	}*/
/*

	private void sendMail(String toMail, Map<String, Object> model, String path, String string) {
		String text = VelocityEngineUtils.mergeTemplateIntoString(getVelocityEngine(), "/templates/" + path, "UTF-8",
				model);
				sendEmail(toEmail, text, model, subject);
		
		
	}
	
		
	public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
	VelocityEngineFactory factory = new VelocityEngineFactory();
	Properties props = new Properties();
	props.put("resource.loader", "class");
	props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	factory.setVelocityProperties(props);
	return factory.createVelocityEngine();
	}*/
	
	
}