package co.edu.uco.asistenciauco.application.usecase.profesor.validator;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.ProfesorRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueProfesorExista implements Validator<UUID, ValidationResultVO>{

	private final ProfesorRepository profesorRepository;
	private final MessageCatalog messageCatalog;
	
	
	
	public ValidarQueProfesorExista(final ProfesorRepository profesorRepository,final MessageCatalog messageCatalog) {
		this.profesorRepository = profesorRepository;
		this.messageCatalog=messageCatalog;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!profesorRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueprofesorexista") + data);
			String userMessage = messageCatalog.getMessage("usermessagevalidatorusecase");
			String technicalMessage = messageCatalog.getMessage("validarqueprofesorexista") + data;
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
