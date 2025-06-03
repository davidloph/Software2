package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import java.util.UUID;


import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueSesionExista implements Validator<UUID, ValidationResultVO>{

	private final SesionRepository sesionRepository;
	private final MessageCatalog messageCatalog;
	
	
	
	public ValidarQueSesionExista(final SesionRepository sesionRepository, final MessageCatalog messageCatalog) {

		this.sesionRepository = sesionRepository;
		this.messageCatalog=messageCatalog;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!sesionRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDARQUESESIONEXISTA) + data);
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEVALIDATORUSECASE);
			String technicalMessage = messageCatalog.getMessage(RedisConstants.VALIDARQUESESIONEXISTA) + data;
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		return resultadoValidacion;
	}

}
