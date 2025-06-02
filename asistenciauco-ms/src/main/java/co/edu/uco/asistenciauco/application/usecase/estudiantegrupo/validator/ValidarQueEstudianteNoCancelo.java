package co.edu.uco.asistenciauco.application.usecase.estudiantegrupo.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteGrupoRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.MessageCatalogImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueEstudianteNoCancelo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private EstudianteGrupoRepository estudianteGrupoRepository;
	private MessageCatalog messageCatalog;

	public ValidarQueEstudianteNoCancelo(final EstudianteGrupoRepository estudianteGrupoRepository, final MessageCatalog messageCatalog) {
		this.estudianteGrupoRepository = estudianteGrupoRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(estudianteGrupoRepository.existsBySesionAndEstudianteNoCancelo(data.get(0), data.get(1))) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueestudiantenocanceloparteuno") + data.get(0) + messageCatalog.getMessage("validarqueestudiantenocancelopartedos"));
		}
		
		return resultadoValidacion;
	}

}
