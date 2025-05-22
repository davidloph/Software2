package co.edu.uco.asistenciauco.application.usecase.tipoidentificacion.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueTipoIdentificacionExista implements Validator<UUID, ValidationResultVO>{

	private EstudianteRepository estudianteRepository;



	public ValidarQueTipoIdentificacionExista(EstudianteRepository estudianteRepository) {
		this.estudianteRepository = estudianteRepository;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!estudianteRepository.existsById(data)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe un estudiante con el identificador " + data);
		}
		
		return resultadoValidacion;
	}

}
