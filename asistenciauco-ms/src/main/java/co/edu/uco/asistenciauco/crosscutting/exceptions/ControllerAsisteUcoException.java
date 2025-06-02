package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.enums.Layer;

public class ControllerAsisteUcoException extends AsisteUcoException {
    public ControllerAsisteUcoException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
    }

    public static final ControllerAsisteUcoException create(final String userMessage, final String technicalMessage,
                                                                  final Exception rootException) {
        return new ControllerAsisteUcoException(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
    }

    public static final ControllerAsisteUcoException create(final String userMessage) {
        return new ControllerAsisteUcoException(userMessage, userMessage, new Exception(), Layer.CONTROLLER);
    }

    public static final ControllerAsisteUcoException create(final String userMessage, final String technicalMessage) {
        return new ControllerAsisteUcoException(userMessage, technicalMessage, new Exception(), Layer.CONTROLLER);
    }
    
}
