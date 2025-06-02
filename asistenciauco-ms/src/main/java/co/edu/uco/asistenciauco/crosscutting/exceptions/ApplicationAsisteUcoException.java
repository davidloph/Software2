package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.enums.Layer;

public class ApplicationAsisteUcoException extends AsisteUcoException {
    public ApplicationAsisteUcoException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, Layer.APPLICATION);
    }

    public static final ApplicationAsisteUcoException create(final String userMessage, final String technicalMessage,
                                                             final Exception rootException) {
        return new ApplicationAsisteUcoException(userMessage, technicalMessage, rootException, Layer.APPLICATION);
    }

    public static final ApplicationAsisteUcoException create(final String userMessage) {
        return new ApplicationAsisteUcoException(userMessage, userMessage, new Exception(), Layer.APPLICATION);
    }

    public static final ApplicationAsisteUcoException create(final String userMessage, final String technicalMessage) {
        return new ApplicationAsisteUcoException(userMessage, technicalMessage, new Exception(), Layer.APPLICATION);
    }
    
}
