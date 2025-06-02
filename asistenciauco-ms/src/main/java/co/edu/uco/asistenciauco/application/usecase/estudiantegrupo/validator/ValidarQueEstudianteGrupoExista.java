package co.edu.uco.asistenciauco.application.usecase.estudiantegrupo.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteGrupoRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueEstudianteGrupoExista implements Validator<UUID, ValidationResultVO> {

	private final EstudianteGrupoRepository estudianteGrupoRepository;
	private final MessageCatalog messageCatalog;

	public ValidarQueEstudianteGrupoExista(final EstudianteGrupoRepository estudianteGrupoRepository, final MessageCatalog messageCatalog) {
		this.estudianteGrupoRepository = estudianteGrupoRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!estudianteGrupoRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueestudiantegrupoexista")+ data);
			String userMessage = messageCatalog.getMessage("usermessagevalidatorusecase");
			String technicalMessage = messageCatalog.getMessage("validarqueestudiantegrupoexista")+ data;
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
