package co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	// Valide objeto ResopnseEntity
	@PostMapping
	public String registrarAsistencia(@RequestBody RegistrarAsistenciaRequestDTO dto) {
		registrarAsistenciaInteractor.ejecutar(dto);
		return "Success";
	}
}
