package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.enums.Layer;

public class EmailAsisteUcoException extends AsisteUcoException {
    public EmailAsisteUcoException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, Layer.EMAIL);
    }

    public static final EmailAsisteUcoException create(final String userMessage, final String technicalMessage,
                                                       final Exception rootException) {
        return new EmailAsisteUcoException(userMessage, technicalMessage, rootException, Layer.EMAIL);
    }

    public static final EmailAsisteUcoException create(final String userMessage) {
        return new EmailAsisteUcoException(userMessage, userMessage, new Exception(), Layer.EMAIL);
    }

    public static final EmailAsisteUcoException create(final String userMessage, final String technicalMessage) {
        return new EmailAsisteUcoException(userMessage, technicalMessage, new Exception(), Layer.EMAIL);
    }
    
}
