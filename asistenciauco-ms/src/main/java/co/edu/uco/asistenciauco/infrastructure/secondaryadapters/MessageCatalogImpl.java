package co.edu.uco.asistenciauco.infrastructure.secondaryadapters;


import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class MessageCatalogImpl implements MessageCatalog {

    private final StringRedisTemplate redisTemplate;
    private static final String FALLBACK_MESSAGE = "Mensaje no encontrado en Redis o revise la conexion.";

    @Autowired
    public MessageCatalogImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public String getMessageOrDefault(String key) {
        String message = redisTemplate.opsForValue().get(key);
        return (!ObjectHelper.isNull(message)) ? message : FALLBACK_MESSAGE;
    }
}
