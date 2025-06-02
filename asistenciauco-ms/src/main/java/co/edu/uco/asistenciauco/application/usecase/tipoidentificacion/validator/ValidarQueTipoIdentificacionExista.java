package co.edu.uco.asistenciauco.application.usecase.tipoidentificacion.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.TipoIdentificacionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.MessageCatalogImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueTipoIdentificacionExista implements Validator<UUID, ValidationResultVO>{

	private TipoIdentificacionRepository tipoIdentificacionRepository;
	private MessageCatalog messageCatalog;

	public ValidarQueTipoIdentificacionExista(TipoIdentificacionRepository tipoIdentificacionRepository, MessageCatalog messageCatalog) {
		this.tipoIdentificacionRepository = tipoIdentificacionRepository;
		this.messageCatalog = messageCatalog;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!tipoIdentificacionRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarquetipoidentificacionexista") + data);
			String userMessage = messageCatalog.getMessage("usermessagevalidatorusecase");
			String technicalMessage = messageCatalog.getMessage("validarquetipoidentificacionexista") + data;
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
