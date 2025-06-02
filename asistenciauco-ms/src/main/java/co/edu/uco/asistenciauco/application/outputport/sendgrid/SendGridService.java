package co.edu.uco.asistenciauco.application.outputport.sendgrid;

import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.EmailMessage;

public interface SendGridService {

    void send(EmailMessage emailMessage);

}
