package co.edu.uco.asistenciauco.application.usecase.cancelo.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.CanceloRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueNoCancelo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private CanceloRepository canceloRepository;
	
	
	
	public ValidarQueNoCancelo(CanceloRepository canceloRepository) {
		this.canceloRepository = canceloRepository;
	}



	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!canceloRepository.estudianteCanceloInactivo(data.get(0), data.get(1))) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("El estudiante con identificador " + data.get(0) + " ha cancelado la materia.");
		}
		
		return resultadoValidacion;
	}

}
