package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.enums.Layer;

public class DTOAsisteUcoException extends AsisteUcoException{
    public DTOAsisteUcoException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, layer);
    }

    public static final DTOAsisteUcoException create(final String userMessage, final String technicalMessage,
                                                           final Exception rootException) {
        return new DTOAsisteUcoException(userMessage, technicalMessage, rootException,Layer.DTO);
    }

    public static final DTOAsisteUcoException create(final String userMessage) {
        return new DTOAsisteUcoException(userMessage, userMessage, new Exception(),Layer.DTO);
    }

    public static final DTOAsisteUcoException create(final String userMessage, final String technicalMessage) {
        return new DTOAsisteUcoException(userMessage, technicalMessage, new Exception(),Layer.DTO);
    }
    
}
