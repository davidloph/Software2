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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class SendGridServiceImpl implements SendGridService {

    private static final Logger logger = LoggerFactory.getLogger(SendGridServiceImpl.class);
    private static MessageCatalog messageCatalog;

    @Value("${apisengrid}")
    public String sendGridAPI;

    @Value("${correoremitente}")
    public String fromEmail;


    @Override
    public void send(EmailMessage emailMessage) {
        Email from = new Email(fromEmail);
        Email toEmail = new Email(emailMessage.getTo());
        Content content = new Content("text/html", "<h1 style='color: yellow; background-color: green; text-align: center;'>Asistencia No Registrada</h1>" +
                "<p style='color: green; font-weight: bold;'>" + emailMessage.getContent() + "</p>" +
                "<a href='https://uco.edu.co/' style='color: white; background-color: green; padding: 5px 10px; text-decoration: none;'>Para más información presione aquí</a>");
        Mail mail = new Mail(from, emailMessage.getSubject(), toEmail, content);

        SendGrid sg = new SendGrid(sendGridAPI);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);

        } catch (IOException exception) {
            logger.error(messageCatalog.getMessage(RedisConstants.EXCEPCIONSENDGRID), exception);
        }

    }
}
