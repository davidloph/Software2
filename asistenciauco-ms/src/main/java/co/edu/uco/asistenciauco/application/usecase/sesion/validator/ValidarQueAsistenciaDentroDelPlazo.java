package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.SesionConstants;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class ValidarQueAsistenciaDentroDelPlazo implements Validator<UUID, ValidationResultVO>{

	private SesionRepository sesionRepository;



	public ValidarQueAsistenciaDentroDelPlazo(SesionRepository sesionRepository) {

		this.sesionRepository = sesionRepository;
	}

	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!sesionRepository.existsByIdAndFechaBefore(data, SesionConstants.COLUMN_FECHA_LIMITE)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("El plazo para registrar asistencia en la sesión con identificador " + data + " ha caducado.");
		}
		
		return resultadoValidacion;
	}

}
