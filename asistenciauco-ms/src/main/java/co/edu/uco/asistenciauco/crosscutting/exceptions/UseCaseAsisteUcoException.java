package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.enums.Layer;

public class UseCaseAsisteUcoException extends AsisteUcoException {
    public UseCaseAsisteUcoException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, Layer.USECASE);
    }

    public static  UseCaseAsisteUcoException create(final String userMessage, final String technicalMessage,
                                                         final Exception rootException) {
        return new UseCaseAsisteUcoException(userMessage, technicalMessage, rootException, Layer.USECASE);
    }

    public static  UseCaseAsisteUcoException create(final String userMessage) {
        return new UseCaseAsisteUcoException(userMessage, userMessage, new Exception(), Layer.USECASE);
    }

    public static  UseCaseAsisteUcoException create(final String userMessage, final String technicalMessage) {
        return new UseCaseAsisteUcoException(userMessage, technicalMessage, new Exception(), Layer.USECASE);
    }
    
}
