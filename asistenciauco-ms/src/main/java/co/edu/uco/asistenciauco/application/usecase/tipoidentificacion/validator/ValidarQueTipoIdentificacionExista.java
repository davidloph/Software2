package co.edu.uco.asistenciauco.application.usecase.tipoidentificacion.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.TipoIdentificacionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueTipoIdentificacionExista implements Validator<UUID, ValidationResultVO>{

	private TipoIdentificacionRepository tipoIdentificacionRepository;



	public ValidarQueTipoIdentificacionExista(TipoIdentificacionRepository tipoIdentificacionRepository) {
		this.tipoIdentificacionRepository = tipoIdentificacionRepository;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!tipoIdentificacionRepository.existsById(data)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe un tipo de identificación con el identificador " + data);
		}
		
		return resultadoValidacion;
	}

}
