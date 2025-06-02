package co.edu.uco.asistenciauco.application.usecase.grupo.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.GrupoRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
<<<<<<<< HEAD:asistenciauco-ms/src/main/java/co/edu/uco/asistenciauco/application/usecase/grupo/validator/ValidarQueGrupoEstaActivoBySesion.java
public class ValidarQueGrupoEstaActivoBySesion implements Validator<UUID, ValidationResultVO>{
========
public class ValidarQueGrupoActivo implements Validator<UUID, ValidationResultVO>{
>>>>>>>> refs/heads/dev:asistenciauco-ms/src/main/java/co/edu/uco/asistenciauco/application/usecase/grupo/validator/ValidarQueGrupoActivo.java

	private GrupoRepository grupoRepository;



<<<<<<<< HEAD:asistenciauco-ms/src/main/java/co/edu/uco/asistenciauco/application/usecase/grupo/validator/ValidarQueGrupoEstaActivoBySesion.java
	public ValidarQueGrupoEstaActivoBySesion(GrupoRepository grupoRepository) {
========
	public ValidarQueGrupoActivo(GrupoRepository grupoRepository) {
>>>>>>>> refs/heads/dev:asistenciauco-ms/src/main/java/co/edu/uco/asistenciauco/application/usecase/grupo/validator/ValidarQueGrupoActivo.java
		this.grupoRepository = grupoRepository;
	}



	@Override
	public ValidationResultVO validate(UUID data) {
		
		var resultadoValidacion = new ValidationResultVO();
		
<<<<<<<< HEAD:asistenciauco-ms/src/main/java/co/edu/uco/asistenciauco/application/usecase/grupo/validator/ValidarQueGrupoEstaActivoBySesion.java
		if(!grupoRepository.existsWithGrupo(data)) {
========
		if(!grupoRepository.existsBySesionActiva(data)) {
>>>>>>>> refs/heads/dev:asistenciauco-ms/src/main/java/co/edu/uco/asistenciauco/application/usecase/grupo/validator/ValidarQueGrupoActivo.java
			//TODO: El mensaje debería estar en el catálogo de mensajes.
			resultadoValidacion.agregarMensaje("No existe una sesión con grupo activo con el identificador " + data + ".");
		}
		
		return resultadoValidacion;
	}

}
