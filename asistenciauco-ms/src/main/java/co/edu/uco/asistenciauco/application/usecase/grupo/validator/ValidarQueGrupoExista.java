package co.edu.uco.asistenciauco.application.usecase.grupo.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.GrupoRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.MessageCatalogImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueGrupoExista implements Validator<UUID, ValidationResultVO>{

	private GrupoRepository grupoRepository;
	private MessageCatalog messageCatalog;

	public ValidarQueGrupoExista(final GrupoRepository grupoRepository,final MessageCatalog messageCatalog) {
		this.grupoRepository = grupoRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!grupoRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarquegrupoexista") + data);
		}
		
		return resultadoValidacion;
	}

}
