package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.MessageCatalogImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ValidarProfesorAsociadoASesion implements Validator<ArrayList<UUID>, ValidationResultVO>{

	private SesionRepository sesionRepository;
	private MessageCatalog messageCatalog;


	public ValidarProfesorAsociadoASesion(final SesionRepository sesionRepository, final MessageCatalog messageCatalog) {

		this.sesionRepository = sesionRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(ArrayList<UUID> data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(sesionRepository.findProfesorIdBySesionId(data.get(0)) == data.get(1)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarprofesorasociadoasesionparteuno")+ data.get(0) + messageCatalog.getMessage("validarprofesorasociadoasesionpartedos") + data.get(1) + ".");
		}
		
		return resultadoValidacion;
	}

}
