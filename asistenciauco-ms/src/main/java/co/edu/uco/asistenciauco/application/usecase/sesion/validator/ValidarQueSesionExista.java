package co.edu.uco.asistenciauco.application.usecase.sesion.validator;


import co.edu.uco.asistenciauco.application.mapper.entity.AsistenciaMapper;
import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Sesion;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueSesionExista implements Validator<Sesion, ValidationResultVO>{

	private final SesionRepository sesionRepository;
	private final MessageCatalog messageCatalog;
	private final AsistenciaMapper asistenciaMapper;
	
	
	
	public ValidarQueSesionExista(final SesionRepository sesionRepository, final MessageCatalog messageCatalog, AsistenciaMapper asistenciaMapper) {

		this.sesionRepository = sesionRepository;
		this.messageCatalog=messageCatalog;
        this.asistenciaMapper = asistenciaMapper;
    }



	@Override
	public ValidationResultVO validate(Sesion sesion) {
		
		var resultadoValidacion = new ValidationResultVO();

		SesionEntity sesionEntity = asistenciaMapper.toSesionEntity(sesion);

		if(!sesionRepository.existsById(sesionEntity.getId())) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDARQUESESIONEXISTA) + sesionEntity.getId());
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEVALIDATORUSECASE);
			String technicalMessage = messageCatalog.getMessage(RedisConstants.VALIDARQUESESIONEXISTA) + sesionEntity.getId();
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		return resultadoValidacion;
	}

}
