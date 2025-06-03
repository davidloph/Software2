package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import co.edu.uco.asistenciauco.application.mapper.entity.AsistenciaMapper;
import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.SesionConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Sesion;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;



@Service
public class ValidarQueAsistenciaDentroDelPlazo implements Validator<Sesion, ValidationResultVO>{

	private final SesionRepository sesionRepository;
	private final MessageCatalog messageCatalog;
	private final AsistenciaMapper asistenciaMapper;

	public ValidarQueAsistenciaDentroDelPlazo(final SesionRepository sesionRepository, final MessageCatalog messageCatalog, AsistenciaMapper asistenciaMapper) {

		this.sesionRepository = sesionRepository;
		this.messageCatalog=messageCatalog;
        this.asistenciaMapper = asistenciaMapper;
    }

	@Override
	public ValidationResultVO validate(Sesion sesion) {
		
		var resultadoValidacion = new ValidationResultVO();

		SesionEntity sesionEntity = asistenciaMapper.toSesionEntity(sesion);

		if(!sesionRepository.existsByIdAndFechaBefore(sesionEntity.getId(), SesionConstants.COLUMN_FECHA_LIMITE)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDARQIEASISTENCIADENTRODEPLAZOPARTEUNO) + sesionEntity.getId() + messageCatalog.getMessage(RedisConstants.VALIDARQIEASISTENCIADENTRODEPLAZOPARTEDOS));
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEVALIDATORUSECASE);
			String technicalMessage = messageCatalog.getMessage(RedisConstants.VALIDARQIEASISTENCIADENTRODEPLAZOPARTEUNO) + sesionEntity.getId() + messageCatalog.getMessage(RedisConstants.VALIDARQIEASISTENCIADENTRODEPLAZOPARTEDOS);
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
