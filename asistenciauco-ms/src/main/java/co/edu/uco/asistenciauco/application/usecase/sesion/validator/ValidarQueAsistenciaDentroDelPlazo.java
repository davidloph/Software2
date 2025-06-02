package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.SesionConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class ValidarQueAsistenciaDentroDelPlazo implements Validator<UUID, ValidationResultVO>{

	private SesionRepository sesionRepository;
	private MessageCatalog messageCatalog;

	public ValidarQueAsistenciaDentroDelPlazo(final SesionRepository sesionRepository,final MessageCatalog messageCatalog) {

		this.sesionRepository = sesionRepository;
		this.messageCatalog=messageCatalog;
	}

	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if(!sesionRepository.existsByIdAndFechaBefore(data, SesionConstants.COLUMN_FECHA_LIMITE)) {
			resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarqueasistenciadentrodelplazoparteuno") + data + messageCatalog.getMessage("validarqueasistenciadentrodelplazopartedos"));
		}
		
		return resultadoValidacion;
	}

}
