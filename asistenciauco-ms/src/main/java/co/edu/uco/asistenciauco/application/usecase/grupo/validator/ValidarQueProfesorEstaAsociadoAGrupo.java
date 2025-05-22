package co.edu.uco.asistenciauco.application.usecase.grupo.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.GrupoRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.ProfesorRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueProfesorEstaAsociadoAGrupo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private GrupoRepository grupoRepository;



	public ValidarQueProfesorEstaAsociadoAGrupo(GrupoRepository grupoRepository) {
		this.grupoRepository = grupoRepository;
	}



	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!grupoRepository.existsByProfesorAndGrupo(data.get(0), data.get(1))) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe un profesor con el identificador " + data.get(0) + " en el grupo " + data.get(1));
		}
		
		return resultadoValidacion;
	}

}
