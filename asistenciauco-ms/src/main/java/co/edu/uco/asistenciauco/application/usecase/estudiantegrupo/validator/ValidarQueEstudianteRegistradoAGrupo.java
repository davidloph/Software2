package co.edu.uco.asistenciauco.application.usecase.estudiantegrupo.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteGrupoRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueEstudianteRegistradoAGrupo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private final EstudianteGrupoRepository estudianteGrupoRepository;
	private final MessageCatalog messageCatalog;

	public ValidarQueEstudianteRegistradoAGrupo(final EstudianteGrupoRepository estudianteGrupoRepository, final MessageCatalog messageCatalog) {
		this.estudianteGrupoRepository = estudianteGrupoRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!estudianteGrupoRepository.existsByEstudiante_IdAndGrupo_Id(data.get(0), data.get(1))) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueestudianteregistradoagrupoparteuno") + data.get(0) + messageCatalog.getMessage("validarqueestudianteregistradoagrupopartedos") + data.get(1));
			String userMessage = messageCatalog.getMessage("usermessagevalidatorusecase");
			String technicalMessage = messageCatalog.getMessage("validarqueestudianteregistradoagrupoparteuno") + data.get(0) + messageCatalog.getMessage("validarqueestudianteregistradoagrupopartedos") + data.get(1);
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
