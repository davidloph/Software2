package co.edu.uco.asistenciauco.application.usecase.grupo.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.GrupoRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueGrupoEstaActivo implements Validator<UUID, ValidationResultVO>{

	private GrupoRepository grupoRepository;



	public ValidarQueGrupoEstaActivo(GrupoRepository grupoRepository) {
		this.grupoRepository = grupoRepository;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!grupoRepository.existsByIdAndActivoTrue(data)) {
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe un grupo activo con el identificador " + data);
		}
		
		return resultadoValidacion;
	}

}
