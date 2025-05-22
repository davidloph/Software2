package co.edu.uco.asistenciauco.application.usecase.profesor.validator;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.ProfesorRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueProfesorExista implements Validator<UUID, ValidationResultVO>{

	private ProfesorRepository profesorRepository;
	
	
	
	public ValidarQueProfesorExista(ProfesorRepository profesorRepository) {
		this.profesorRepository = profesorRepository;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!profesorRepository.existsById(data)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe un profesor con el identificador " + data);
		}
		
		return resultadoValidacion;
	}

}
