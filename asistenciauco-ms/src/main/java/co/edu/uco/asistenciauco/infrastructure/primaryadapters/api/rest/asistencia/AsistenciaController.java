package co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia;

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
	
	
	
	public AsistenciaController(RegistrarAsistenciaInteractor registrarAsistenciaInteractor) {
		super();
		this.registrarAsistenciaInteractor = registrarAsistenciaInteractor;
	}

	@PostMapping
	public ResponseEntity<GenericResponse> registrarAsistencia(@RequestBody RegistrarAsistenciaRequestDTO dto) {
		var message = new ArrayList<String>();
		try {
			var responseRegistrarAsistenciaDTO = registrarAsistenciaInteractor.ejecutar(dto);
			if (responseRegistrarAsistenciaDTO.isTransaccionExitosa()) {
				responseRegistrarAsistenciaDTO.getMensajes().add("El registro de la asistencia se realizó de forma satisfactoria");
				return GeneratedResponse.generateSuccessResponse(responseRegistrarAsistenciaDTO.getMensajes());
			} else {
				responseRegistrarAsistenciaDTO.getMensajes().add("El registro de la asistencia se realizó de forma exitosa. Algunos estudiantes no fueron válidos para el registro.");
				return GeneratedResponse.generateSuccessResponse(responseRegistrarAsistenciaDTO.getMensajes());
			}
		}catch (ApplicationAsisteUcoException exception){
			message.add(exception.getUserMessage());
			return GeneratedResponse.generateFailedResponse(new ArrayList<>(List.of(exception.getUserMessage())));

		}catch(AsisteUcoException exception) {
			message.add(exception.getUserMessage());
			exception.printStackTrace();
			return GeneratedResponse.generateFailedResponse(new ArrayList<>(List.of(exception.getUserMessage())));

		}catch( final Exception exception){
			message.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo la asistencia de los estudiantes...");
			return GeneratedResponse.generateFailedResponse(message);
		}
	}
}
