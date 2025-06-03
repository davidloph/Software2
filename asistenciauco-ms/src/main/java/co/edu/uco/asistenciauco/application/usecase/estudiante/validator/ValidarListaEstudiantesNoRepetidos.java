package co.edu.uco.asistenciauco.application.usecase.estudiante.validator;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;


@Service
public class ValidarListaEstudiantesNoRepetidos implements Validator<List<UUID>, ValidationResultVO>{

	private final MessageCatalog messageCatalog;

	public ValidarListaEstudiantesNoRepetidos(final MessageCatalog messageCatalog) {
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(List<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();

		boolean isRepetido = new LinkedHashSet<UUID>(data).size() < data.size();
		if(isRepetido){
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDARESTUDIANTESREPETIDOS));
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEVALIDATORUSECASE);
			String technicalMessage = messageCatalog.getMessage(RedisConstants.VALIDARESTUDIANTESREPETIDOS);
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}

		return resultadoValidacion;
	}

}
