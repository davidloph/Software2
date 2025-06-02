package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.UcoApplicationException;
import co.edu.uco.crosscutting.exception.enums.Layer;

public class AsisteUcoException extends UcoApplicationException {

    private static final long serialVersionUID = 1L;

    public AsisteUcoException(final String userMessage, final String technicalMessage, final Exception rootException,
                                    final Layer layer) {
        super(userMessage, technicalMessage, rootException, layer);
    }

    public static AsisteUcoException create(final String userMessage, final String technicalMessage,
                                                  final Exception rootException, final Layer layer) {
        return new AsisteUcoException(userMessage, technicalMessage, rootException, layer);
    }

    public static AsisteUcoException create(final String userMessage) {
        return new AsisteUcoException(userMessage, userMessage, new Exception(), Layer.GENERAL);
    }

    public static AsisteUcoException crear(final String userMessage, final String technicalMessage) {
        return new AsisteUcoException(userMessage, technicalMessage, new Exception(), Layer.GENERAL);
    }
    
}
