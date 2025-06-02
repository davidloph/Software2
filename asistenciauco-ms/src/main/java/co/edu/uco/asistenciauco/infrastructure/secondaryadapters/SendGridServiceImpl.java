package co.edu.uco.asistenciauco.infrastructure.secondaryadapters;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.sendgrid.SendGridService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class SendGridServiceImpl implements SendGridService {


    @Value("${apisengrid}")
    public String sendGridAPI;

    @Value("${correoremitente}")
    public String fromEmail;

    private MessageCatalog messageCatalog;

    @Override
    public void send(EmailMessage emailMessage) {
        Email from = new Email(fromEmail);
        Email toEmail = new Email(emailMessage.getTo());
        Content content = new Content("text/html", "<h1 style='color: yellow; background-color: green; text-align: center;'>" + messageCatalog.getMessage(RedisConstants.ASISTENCIANOREGISTRADA) + "</h1>" +
                "<p style='color: green; font-weight: bold;'>" + emailMessage.getContent() + "</p>" +
                "<a href='" + messageCatalog.getMessage(RedisConstants.LINK) +"' style='color: white; background-color: green; padding: 5px 10px; text-decoration: none;'>" + messageCatalog.getMessage(RedisConstants.ASUNTOCORREO)+ "</a>");
        Mail mail = new Mail(from, emailMessage.getSubject(), toEmail, content);

        SendGrid sg = new SendGrid(sendGridAPI);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);

        } catch (IOException exception) {
            System.out.println();
        }

    }
}
