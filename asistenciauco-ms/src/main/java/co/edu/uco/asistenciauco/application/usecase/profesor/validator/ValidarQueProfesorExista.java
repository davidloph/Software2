package co.edu.uco.asistenciauco.application.usecase.profesor.validator;


import co.edu.uco.asistenciauco.application.mapper.entity.AsistenciaMapper;
import co.edu.uco.asistenciauco.application.outputport.entity.ProfesorEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Profesor;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.ProfesorRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueProfesorExista implements Validator<Profesor, ValidationResultVO>{

	private final ProfesorRepository profesorRepository;
	private final MessageCatalog messageCatalog;
	private final AsistenciaMapper asistenciaMapper;
	
	
	
	public ValidarQueProfesorExista(final ProfesorRepository profesorRepository, final MessageCatalog messageCatalog, AsistenciaMapper asistenciaMapper) {
		this.profesorRepository = profesorRepository;
		this.messageCatalog=messageCatalog;
        this.asistenciaMapper = asistenciaMapper;
    }



	@Override
	public ValidationResultVO validate(Profesor profesor) {
		
		var resultadoValidacion = new ValidationResultVO();

		ProfesorEntity profesorEntity = asistenciaMapper.toProfesorEntity(profesor);

		if(!profesorRepository.existsById(profesorEntity.getId())) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDARQUEPROFESOREXISTA) + profesorEntity.getId());
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEVALIDATORUSECASE);
			String technicalMessage = messageCatalog.getMessage(RedisConstants.VALIDARQUEPROFESOREXISTA) + profesorEntity.getId();
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
