package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import java.util.UUID;


import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

@Service
public class ValidarQueSesionExista implements Validator<UUID, ValidationResultVO>{

	private SesionRepository sesionRepository;
	private MessageCatalog messageCatalog;
	
	
	
	public ValidarQueSesionExista(final SesionRepository sesionRepository, final MessageCatalog messageCatalog) {

		this.sesionRepository = sesionRepository;
		this.messageCatalog=messageCatalog;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!sesionRepository.existsById(data)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarquesesionexista") + data);
		}
		
		return resultadoValidacion;
	}

}
