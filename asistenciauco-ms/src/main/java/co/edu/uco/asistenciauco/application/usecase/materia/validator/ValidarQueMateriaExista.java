package co.edu.uco.asistenciauco.application.usecase.materia.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.MateriaRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.MessageCatalogImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueMateriaExista implements Validator<UUID, ValidationResultVO> {

	private MateriaRepository materiaRepository;
	private MessageCatalog messageCatalog;

	public ValidarQueMateriaExista(final MateriaRepository materiaRepository,final MessageCatalog messageCatalog) {

		this.materiaRepository = materiaRepository;
		this.messageCatalog=messageCatalog;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!materiaRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarquemateriaexista") + data);
			String userMessage = messageCatalog.getMessage("usermessagevalidatorusecase");
			String technicalMessage = messageCatalog.getMessage("validarquemateriaexista") + data;
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
