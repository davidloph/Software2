package co.edu.uco.asistenciauco.application.usecase.estudiantegrupo.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteGrupoRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.MessageCatalogImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueEstudianteRegistradoAGrupo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private EstudianteGrupoRepository estudianteGrupoRepository;
	private MessageCatalog messageCatalog;

	public ValidarQueEstudianteRegistradoAGrupo(final EstudianteGrupoRepository estudianteGrupoRepository, final MessageCatalog messageCatalog) {
		this.estudianteGrupoRepository = estudianteGrupoRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!estudianteGrupoRepository.existsByEstudiante_IdAndGrupo_Id(data.get(0), data.get(1))) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueestudianteregistradoagrupoparteuno") + data.get(0) + messageCatalog.getMessage("validarqueestudianteregistradoagrupopartedos") + data.get(1));
		}
		
		return resultadoValidacion;
	}

}
