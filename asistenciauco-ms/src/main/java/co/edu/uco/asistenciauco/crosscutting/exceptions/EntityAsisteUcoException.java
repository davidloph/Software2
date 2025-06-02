package co.edu.uco.asistenciauco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exception.enums.Layer;

public class EntityAsisteUcoException extends AsisteUcoException{
    public EntityAsisteUcoException(String userMessage, String technicalMessage, Exception rootException, Layer layer) {
        super(userMessage, technicalMessage, rootException, Layer.ENTITY);
    }

    public static final EntityAsisteUcoException create(final String userMessage, final String technicalMessage,
                                                              final Exception rootException) {
        return new EntityAsisteUcoException(userMessage, technicalMessage, rootException, Layer.ENTITY);
    }

    public static final EntityAsisteUcoException create(final String userMessage) {
        return new EntityAsisteUcoException(userMessage, userMessage, new Exception(), Layer.ENTITY);
    }

    public static final EntityAsisteUcoException create(final String userMessage, final String technicalMessage) {
        return new EntityAsisteUcoException(userMessage, technicalMessage, new Exception(), Layer.ENTITY);
    }
    
    
}
