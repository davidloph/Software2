package co.edu.uco.asistenciauco.application.usecase.materia.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.MateriaRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueMateriaExista implements Validator<UUID, ValidationResultVO>{

	private MateriaRepository materiaRepository;
	
	
	
	public ValidarQueMateriaExista(MateriaRepository materiaRepository) {

		this.materiaRepository = materiaRepository;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!materiaRepository.existsById(data)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe una materia con el identificador " + data);
		}
		
		return resultadoValidacion;
	}

}
