package co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia;

import org.springframework.web.bind.annotation.*;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.RegistrarAsistenciaInteractor;
import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;

@RestController
@RequestMapping("/api/v1/asistencias")
public class AsistenciaController {

	private RegistrarAsistenciaInteractor registrarAsistenciaInteractor;
	
	
	
	public AsistenciaController(RegistrarAsistenciaInteractor registrarAsistenciaInteractor) {
		super();
		this.registrarAsistenciaInteractor = registrarAsistenciaInteractor;
	}



	//Quien define qué retorna y cómo lo retorna al usuario es tarea de todos
	// Valide objeto ResponseEntity
	@PostMapping
	public String registrarAsistencia(@RequestBody RegistrarAsistenciaRequestDTO dto) {
		registrarAsistenciaInteractor.ejecutar(dto);
		return "Success";
	}
}
