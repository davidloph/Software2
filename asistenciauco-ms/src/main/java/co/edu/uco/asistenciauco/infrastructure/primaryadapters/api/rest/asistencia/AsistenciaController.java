package co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.crosscutting.exceptions.ApplicationAsisteUcoException;
import co.edu.uco.asistenciauco.crosscutting.exceptions.AsisteUcoException;
import co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia.response.GeneratedResponse;
import co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia.response.concrete.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.RegistrarAsistenciaInteractor;
import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/asistencias")
public class AsistenciaController {

	private RegistrarAsistenciaInteractor registrarAsistenciaInteractor;
	private final MessageCatalog messageCatalog;
	
	public AsistenciaController(RegistrarAsistenciaInteractor registrarAsistenciaInteractor, MessageCatalog messageCatalog) {
		super();
		this.registrarAsistenciaInteractor = registrarAsistenciaInteractor;
		this.messageCatalog = messageCatalog;
	}

	@PostMapping
	public ResponseEntity<GenericResponse> registrarAsistencia(@RequestBody RegistrarAsistenciaRequestDTO dto) {

		var message = new ArrayList<String>();

		try {
			var responseRegistrarAsistenciaDTO = registrarAsistenciaInteractor.ejecutar(dto);
			boolean isTransaccionExitosa = responseRegistrarAsistenciaDTO.isTransaccionExitosa();
			var cantidadEstudiantes = dto.getEstudiantes().size();
			if (isTransaccionExitosa) {
				responseRegistrarAsistenciaDTO.getMensajes().add(messageCatalog.getMessage(RedisConstants.CONTROLLERSITRANSACCIONESEXITOSA));
				return GeneratedResponse.generateSuccessResponse(responseRegistrarAsistenciaDTO.getMensajes());
			} else if (cantidadEstudiantes > responseRegistrarAsistenciaDTO.getMensajes().size()) {
				responseRegistrarAsistenciaDTO.getMensajes().add(messageCatalog.getMessage(RedisConstants.CONTROLLERSITRANSACCIONNOESEXITOSA));
				return GeneratedResponse.generateSuccessResponse(responseRegistrarAsistenciaDTO.getMensajes());
			} else {
				responseRegistrarAsistenciaDTO.getMensajes().add(messageCatalog.getMessage(RedisConstants.CONTROLLERSITRANSACCIONFALLIDA));
				return GeneratedResponse.generateFailedResponse(responseRegistrarAsistenciaDTO.getMensajes());
			}
		}catch (ApplicationAsisteUcoException exception){
			message.add(exception.getUserMessage());
			return GeneratedResponse.generateFailedResponse(new ArrayList<>(List.of(exception.getUserMessage())));

		}catch(AsisteUcoException exception) {
			message.add(exception.getUserMessage());
			exception.printStackTrace();
			return GeneratedResponse.generateFailedResponse(new ArrayList<>(List.of(exception.getUserMessage())));

		}catch( final Exception exception){
			exception.printStackTrace();
			message.add(messageCatalog.getMessage(RedisConstants.EXCEPTIONASISTENCIACONTROLLER));
			return GeneratedResponse.generateFailedResponse(message);
		}
	}
}
