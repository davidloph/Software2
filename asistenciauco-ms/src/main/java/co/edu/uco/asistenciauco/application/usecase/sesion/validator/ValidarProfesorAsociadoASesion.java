package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarProfesorAsociadoASesion implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private SesionRepository sesionRepository;



	public ValidarProfesorAsociadoASesion(SesionRepository sesionRepository) {

		this.sesionRepository = sesionRepository;
	}



	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(sesionRepository.findProfesorIdBySesionId(data.get(0)) == data.get(1)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("La sesión con identificador " + data.get(0) + " no tiene un profesor asociado con el identificador " + data.get(1) + ".");
		}
		
		return resultadoValidacion;
	}

}
