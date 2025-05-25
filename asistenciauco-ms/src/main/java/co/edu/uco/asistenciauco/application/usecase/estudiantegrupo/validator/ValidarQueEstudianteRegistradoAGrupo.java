package co.edu.uco.asistenciauco.application.usecase.estudiantegrupo.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteGrupoRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueEstudianteRegistradoAGrupo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private EstudianteGrupoRepository estudianteGrupoRepository;



	public ValidarQueEstudianteRegistradoAGrupo(EstudianteGrupoRepository estudianteGrupoRepository) {
		this.estudianteGrupoRepository = estudianteGrupoRepository;
	}



	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!estudianteGrupoRepository.existsByEstudiante_IdAndGrupo_Id(data.get(0), data.get(1))) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe un estudiante con el identificador " + data.get(0) + " en el grupo con identificador " + data.get(1));
		}
		
		return resultadoValidacion;
	}

}
