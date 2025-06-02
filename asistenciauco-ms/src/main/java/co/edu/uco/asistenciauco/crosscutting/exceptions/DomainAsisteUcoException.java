package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.enums.Layer;

public class DomainAsisteUcoException extends AsisteUcoException {
    public DomainAsisteUcoException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, Layer.DOMAIN);
    }

    public static final DomainAsisteUcoException create(final String userMessage, final String technicalMessage,
                                                        final Exception rootException) {
        return new DomainAsisteUcoException(userMessage, technicalMessage, rootException, Layer.DOMAIN);
    }

    public static final DomainAsisteUcoException create(final String userMessage) {
        return new DomainAsisteUcoException(userMessage, userMessage, new Exception(), Layer.DOMAIN);
    }

    public static final DomainAsisteUcoException create(final String userMessage, final String technicalMessage) {
        return new DomainAsisteUcoException(userMessage, technicalMessage, new Exception(), Layer.DOMAIN);
    }
    
}
