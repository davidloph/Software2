package co.edu.uco.asistenciauco.application.usecase.grupo.validator;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.GrupoRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueGrupoActivo implements Validator<UUID, ValidationResultVO>{

	private final GrupoRepository grupoRepository;
	private final MessageCatalog messageCatalog;

	public ValidarQueGrupoActivo(GrupoRepository grupoRepository,MessageCatalog messageCatalog) {

		this.grupoRepository = grupoRepository;
		this.messageCatalog=messageCatalog;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!grupoRepository.existsBySesionActiva(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDARQUEGRUPOACTIVO)+ data);
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEVALIDATORUSECASE);
			String technicalMessage = messageCatalog.getMessage(RedisConstants.VALIDARQUEGRUPOACTIVO)+ data;
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
