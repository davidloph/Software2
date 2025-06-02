package co.edu.uco.asistenciauco.application.usecase.grupo.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.GrupoRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ValidatorAsisteUcoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarQueProfesorEstaAsociadoAGrupo implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private final GrupoRepository grupoRepository;
	private final MessageCatalog messageCatalog;

	public ValidarQueProfesorEstaAsociadoAGrupo(final GrupoRepository grupoRepository,final MessageCatalog messageCatalog) {
		this.grupoRepository = grupoRepository;
		this.messageCatalog=messageCatalog;
	}


	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!grupoRepository.existsByProfesor_IdAndId(data.get(0), data.get(1))) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueprofesorestaasociadoagrupoparteuno") + data.get(0) + messageCatalog.getMessage("validarqueprofesorestaasociadoagrupopartedos") + data.get(1));
			String userMessage = messageCatalog.getMessage("usermessagevalidatorusecase");
			String technicalMessage = messageCatalog.getMessage("validarqueprofesorestaasociadoagrupoparteuno") + data.get(0) + messageCatalog.getMessage("validarqueprofesorestaasociadoagrupopartedos") + data.get(1);
			throw ValidatorAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		return resultadoValidacion;
	}

}
