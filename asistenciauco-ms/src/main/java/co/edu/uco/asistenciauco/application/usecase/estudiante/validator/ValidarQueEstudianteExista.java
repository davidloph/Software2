package co.edu.uco.asistenciauco.application.usecase.estudiante.validator;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.MessageCatalogImpl;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueEstudianteExista implements Validator<UUID, ValidationResultVO>{

	private EstudianteRepository estudianteRepository;
	private MessageCatalog messageCatalog;

	public ValidarQueEstudianteExista(final EstudianteRepository estudianteRepository, final MessageCatalog messageCatalog) {
		this.estudianteRepository = estudianteRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!estudianteRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueestudianteexista")+ data);
		}
		
		return resultadoValidacion;
	}

}
