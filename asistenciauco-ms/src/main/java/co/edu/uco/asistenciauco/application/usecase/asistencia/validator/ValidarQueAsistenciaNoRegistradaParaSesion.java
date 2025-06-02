package co.edu.uco.asistenciauco.application.usecase.asistencia.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.AsistenciaRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueAsistenciaNoRegistradaParaSesion implements Validator<UUID, ValidationResultVO>{

	private final AsistenciaRepository asistenciaRepository;
	private final MessageCatalog messageCatalog;

	public ValidarQueAsistenciaNoRegistradaParaSesion(final AsistenciaRepository asistenciaRepository,final MessageCatalog messageCatalog) {
		this.messageCatalog=messageCatalog;
		this.asistenciaRepository = asistenciaRepository;
	}

	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(asistenciaRepository.existsBySesion_Id(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueasistencianoregistradaparasesion") + data);
			String userMessage = messageCatalog.getMessage("usermessagevalidatorusecase");
			String technicalMessage = messageCatalog.getMessage("validarqueasistencianoregistradaparasesion") + data;
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
