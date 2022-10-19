package server.service;

import org.springframework.stereotype.Service;
import server.model.Message;
import server.model.Recipe;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class MailService {
    private static String username = "tudor.adrian.ginga";
    private static String password;

    public static void send(Message message, List<Recipe> flights) {
        Properties properties = System.getProperties();
        { password = "";
        } String host = "smtp.gmail.com";
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", username);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);
        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            mimeMessage.setFrom(new InternetAddress(username));
            InternetAddress to = new InternetAddress(message.getEmail());
            mimeMessage.addRecipient(javax.mail.Message.RecipientType.TO, to);
            mimeMessage.setSubject(message.getSubject());
            mimeMessage.setText(flights.toString());

            Transport transport = session.getTransport("smtp");
            transport.connect(host, username, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
