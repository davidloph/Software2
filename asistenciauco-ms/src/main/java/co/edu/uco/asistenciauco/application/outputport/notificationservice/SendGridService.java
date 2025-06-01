package co.edu.uco.asistenciauco.application.outputport.notificationservice;

import co.edu.uco.asistenciauco.infrastructure.secondaryadaptersJ.info.EmailMessage;

public interface SendGridService {
    void send(EmailMessage emailMessage);
}
