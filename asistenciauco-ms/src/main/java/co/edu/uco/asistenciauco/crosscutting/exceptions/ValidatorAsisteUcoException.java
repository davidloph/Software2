package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.enums.Layer;

public class ValidatorAsisteUcoException extends AsisteUcoException {
    public ValidatorAsisteUcoException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, Layer.VALIDATOR);
    }

    public static final ValidatorAsisteUcoException create(final String userMessage, final String technicalMessage,
                                                           final Exception rootException) {
        return new ValidatorAsisteUcoException(userMessage, technicalMessage, rootException, Layer.VALIDATOR);
    }

    public static final ValidatorAsisteUcoException create(final String userMessage) {
        return new ValidatorAsisteUcoException(userMessage, userMessage, new Exception(), Layer.VALIDATOR);
    }

    public static final ValidatorAsisteUcoException create(final String userMessage, final String technicalMessage) {
        return new ValidatorAsisteUcoException(userMessage, technicalMessage, new Exception(), Layer.VALIDATOR);
    }
    
}
