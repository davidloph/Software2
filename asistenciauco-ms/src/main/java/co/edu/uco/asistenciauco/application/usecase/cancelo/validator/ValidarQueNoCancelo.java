package co.edu.uco.asistenciauco.application.usecase.cancelo.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.CanceloRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueNoCancelo implements Validator<UUID, ValidationResultVO>{

	private CanceloRepository canceloRepository;
	
	
	
	public ValidarQueNoCancelo(CanceloRepository canceloRepository) {
		this.canceloRepository = canceloRepository;
	}



	@Override
	public ValidationResultVO validate(UUID idEstudianteGrupo) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!canceloRepository.existsByEstudianteGrupoAndActivoTrue(idEstudianteGrupo)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("El estudiante con identificador " + idEstudianteGrupo + " ha cancelado la materia.");
		}
		
		return resultadoValidacion;
	}

}
