package co.edu.uco.asistenciauco.application.outputport.redis;

public interface MessageCatalog {
    String getMessage(String key);
    String getMessageOrDefault(String key);
}
