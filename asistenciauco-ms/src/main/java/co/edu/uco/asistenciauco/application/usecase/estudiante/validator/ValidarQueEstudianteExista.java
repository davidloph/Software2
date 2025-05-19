package co.edu.uco.asistenciauco.application.usecase.estudiante.validator;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueEstudianteExista implements Validator<UUID, ValidationResultVO>{

	private EstudianteRepository estudianteRepository;
	
	
	
	public ValidarQueEstudianteExista(EstudianteRepository estudianteRepository) {
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
