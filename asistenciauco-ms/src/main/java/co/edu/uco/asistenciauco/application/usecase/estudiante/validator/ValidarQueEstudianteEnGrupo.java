package co.edu.uco.asistenciauco.application.usecase.estudiante.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueEstudianteEnGrupo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private final EstudianteRepository estudianteRepository;
	private final MessageCatalog messageCatalog;

	public ValidarQueEstudianteEnGrupo(final EstudianteRepository estudianteRepository, final MessageCatalog messageCatalog) {
		this.estudianteRepository = estudianteRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!estudianteRepository.existsEstudianteInSesionGrupo(data.get(0), data.get(1))) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueestudianteengrupoparteuno") + data.get(1) + messageCatalog.getMessage("validarqueestudianteengrupopartedos")+ data.get(0) + ".");
		}

		return resultadoValidacion;
	}

}
