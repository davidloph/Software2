package co.edu.uco.asistenciauco.application.usecase.estudiante.validator;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ValidarListaEstudiantesNoVacia implements Validator<List<Estudiante>, ValidationResultVO>{

	private final MessageCatalog messageCatalog;

	public ValidarListaEstudiantesNoVacia(final MessageCatalog messageCatalog) {
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(List<Estudiante> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(data.isEmpty()){
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDACIONLISTAVACIA));
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEVALIDATORUSECASE);
			String technicalMessage = messageCatalog.getMessage(RedisConstants.VALIDACIONLISTAVACIA);
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}

		return resultadoValidacion;
	}

}
