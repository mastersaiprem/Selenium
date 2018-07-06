package thrymr.e2log_testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.xalan.trace.PrintTraceListener;

import com.google.common.io.Files;
import com.sendgrid.*;

import junit.runner.FailureDetailView;

public class SendGridEx {
	private static byte[] fileData;

	public static void main(String[] args) {
		try {
			Properties props = new Properties();
			InputStream input = null;
			input = new FileInputStream("mail.properties");
			props.load(input);

			Email email = new Email("you@youremail.com");
			String subject = "Job offer from jugaad";
			Email to = new Email("");
			Email from = new Email("adithyaroy@jugaad.co.in");
			
			String Context = Files.toString(new File("/home/thrymr/Desktop/sample.html"), Charsets.UTF_8);
			Content content = new Content("text/html",Context);
			
			Mail mail = new Mail(from, subject, to, content);
			SendGrid sendgrid = new SendGrid(props.getProperty("Sendgrid_apikey"));
			Request request = new Request();
			
//			File file = new File("/home/thrymr/Desktop/passport.jpg");
//			try {
//				fileData = org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(file));
//			} catch (IOException ex) {
//			}
//			Base64 x = new Base64();
//			String imageDataString = x.encodeAsString(fileData);
//			Attachments attachment = new Attachments();
//			attachment.setContent(imageDataString);
//			attachment.setType("image/png/html");// "application/pdf"
//			attachment.setFilename("761562732859390_o.html");
//			attachment.setDisposition("attachment");
//			attachment.setContentId("Banner");
//			mail.addAttachments(attachment);

			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sendgrid.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
