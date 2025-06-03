package co.edu.uco.asistenciauco.application.usecase.estudiante.validator;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.mapper.entity.AsistenciaMapper;
import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueEstudianteExista implements Validator<Estudiante, ValidationResultVO>{

	private final EstudianteRepository estudianteRepository;
	private final MessageCatalog messageCatalog;
	private final AsistenciaMapper asistenciaMapper;

	public ValidarQueEstudianteExista(final EstudianteRepository estudianteRepository, final MessageCatalog messageCatalog, AsistenciaMapper asistenciaMapper) {
		this.estudianteRepository = estudianteRepository;
		this.messageCatalog=messageCatalog;
        this.asistenciaMapper = asistenciaMapper;
    }

	@Override
	public ValidationResultVO validate(Estudiante estudiante) {
		
		var resultadoValidacion = new ValidationResultVO();
		EstudianteEntity estudianteEntity = asistenciaMapper.toEstudianteEntity(estudiante);

		if(!estudianteRepository.existsById(estudianteEntity.getId())) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage(RedisConstants.VALIDARQUEESTUDIANTEEXISTA)+ estudianteEntity.getId());
		}
		
		return resultadoValidacion;
	}

}
