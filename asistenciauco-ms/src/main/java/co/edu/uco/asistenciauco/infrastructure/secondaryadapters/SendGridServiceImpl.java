package co.edu.uco.asistenciauco.infrastructure.secondaryadapters;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.SendGridConstants;
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
    private final MessageCatalog messageCatalog;

    @Value("${apisengrid}")
    private String sendGridAPI;

    @Value("${correoremitente}")
    private String fromEmail;

    public SendGridServiceImpl(MessageCatalog messageCatalog) {
        this.messageCatalog = messageCatalog;
    }

    @Override
    public void send(EmailMessage emailMessage) {
        Email from = new Email(fromEmail);
        Email toEmail = new Email(emailMessage.getTo());

        // Usa el HTML desde RedisConstants con contenido dinámico
        String htmlFormatted = String.format(SendGridConstants.HTMLCONTENT, emailMessage.getContent());
        Content content = new Content("text/html", htmlFormatted);

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
