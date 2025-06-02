package co.edu.uco.asistenciauco.application.usecase.profesor.validator;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.ProfesorRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueProfesorExista implements Validator<UUID, ValidationResultVO>{

	private ProfesorRepository profesorRepository;
	private MessageCatalog messageCatalog;
	
	
	
	public ValidarQueProfesorExista(final ProfesorRepository profesorRepository,final MessageCatalog messageCatalog) {
		this.profesorRepository = profesorRepository;
		this.messageCatalog=messageCatalog;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!profesorRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueprofesorexista") + data);
		}
		
		return resultadoValidacion;
	}

}
