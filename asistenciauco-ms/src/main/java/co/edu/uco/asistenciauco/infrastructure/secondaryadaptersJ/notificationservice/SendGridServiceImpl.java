package co.edu.uco.asistenciauco.infrastructure.secondaryadaptersJ.notificationservice;

import co.edu.uco.asistenciauco.infrastructure.secondaryadaptersJ.info.EmailMessage;
import co.edu.uco.asistenciauco.application.outputport.notificationservice.SendGridService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import

public class SendGridServiceImpl implements SendGridService {

    @Value("${apisengrid}")
    public String sendGridAPI;


    private final String fromEmail = "asistenciauniversitaria2025@gmail.com";

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
            System.out.println(exception);
        }
    }
}
