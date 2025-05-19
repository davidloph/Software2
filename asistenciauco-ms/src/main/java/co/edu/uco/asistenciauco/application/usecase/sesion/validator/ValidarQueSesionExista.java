package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueSesionExista implements Validator<UUID, ValidationResultVO>{

	private SesionRepository sesionRepository;
	
	
	
	public ValidarQueSesionExista(SesionRepository sesionRepository) {
		this.sesionRepository = sesionRepository;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!sesionRepository.existsById(data)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe una sesión con el identificador " + data);
		}
		
		return resultadoValidacion;
	}

}
