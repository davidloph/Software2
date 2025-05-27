package co.edu.uco.asistenciauco.application.usecase.asistencia.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.AsistenciaRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueAsistenciaNoRegistradaParaSesion implements Validator<UUID, ValidationResultVO>{

	private AsistenciaRepository asistenciaRepository;



	public ValidarQueAsistenciaNoRegistradaParaSesion(AsistenciaRepository asistenciaRepository) {

		this.asistenciaRepository = asistenciaRepository;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(asistenciaRepository.existsBySesion_Id(data)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("Ya existe una asistencia para la sesión con el identificador " + data);
		}
		
		return resultadoValidacion;
	}

}
