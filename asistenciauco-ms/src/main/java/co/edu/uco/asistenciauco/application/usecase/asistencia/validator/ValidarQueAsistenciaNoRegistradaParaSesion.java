package co.edu.uco.asistenciauco.application.usecase.asistencia.validator;

import co.edu.uco.asistenciauco.application.mapper.entity.AsistenciaMapper;
import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.AsistenciaRepository;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Sesion;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;

import java.util.UUID;


@Service
public class ValidarQueAsistenciaNoRegistradaParaSesion implements Validator<Sesion, ValidationResultVO>{

	private final AsistenciaRepository asistenciaRepository;
	private final MessageCatalog messageCatalog;
	private final AsistenciaMapper asistenciaMapper;

	public ValidarQueAsistenciaNoRegistradaParaSesion(final AsistenciaRepository asistenciaRepository,final MessageCatalog messageCatalog,
													  AsistenciaMapper asistenciaMapper) {
		this.messageCatalog=messageCatalog;
		this.asistenciaRepository = asistenciaRepository;
		this.asistenciaMapper = asistenciaMapper;
	}

	@Override
	public ValidationResultVO validate(Sesion sesion) {
		
		var resultadoValidacion = new ValidationResultVO();
		SesionEntity sesionEntity = asistenciaMapper.toSesionEntity(sesion);
		if(asistenciaRepository.existsBySesion_Id(sesionEntity.getId())) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDARASISTENCIANOREGISTRADAPARASESION) + sesionEntity.getId());
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEVALIDATORUSECASE);
			String technicalMessage = messageCatalog.getMessage(RedisConstants.VALIDARQUEASISTENCIANOREGISTRADAPARASESION) + sesionEntity.getId();
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
