package co.edu.uco.asistenciauco.application.usecase.estudiante.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueEstudianteEnGrupo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private EstudianteRepository estudianteRepository;



	public ValidarQueEstudianteEnGrupo(EstudianteRepository estudianteRepository) {
		this.estudianteRepository = estudianteRepository;
	}



	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!estudianteRepository.existsEstudianteInSesionGrupo(data.get(0), data.get(1))) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe un estudiante con el identificador " + data.get(1) + " para el grupo perteneciente a la sesión " + data.get(0) + ".");
		}
		
		return resultadoValidacion;
	}

}
