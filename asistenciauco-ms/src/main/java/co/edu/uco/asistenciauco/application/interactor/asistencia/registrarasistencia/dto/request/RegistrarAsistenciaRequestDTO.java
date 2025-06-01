package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.UUID;

public final class RegistrarAsistenciaRequestDTO {

	private final UUID sesion;
	private final UUID profesor;
	private final List<EstudianteDTORequest> estudiantes;

	@JsonCreator
	public RegistrarAsistenciaRequestDTO(
			@JsonProperty("sesion") UUID sesion,
			@JsonProperty("profesor") UUID profesor,
			@JsonProperty("estudiantes") List<EstudianteDTORequest> estudiantes) {
		this.sesion = ObjectHelper.getDefault(sesion, UUIDHelper.getDefault());
		this.profesor = ObjectHelper.getDefault(profesor, UUIDHelper.getDefault());
		this.estudiantes = estudiantes;
	}

	public UUID getSesion() {
		return sesion;
	}

	public UUID getProfesor() {
		return profesor;
	}

	public List<EstudianteDTORequest> getEstudiantes() {
		return estudiantes;
	}

	public static class EstudianteDTORequest {
		private final UUID id;
		private final boolean asistio;
		private final boolean asistioFlag;

		@JsonCreator
		public EstudianteDTORequest(
				@JsonProperty("id") UUID id,
				@JsonProperty("asistio") boolean asistio) {
			this.id = ObjectHelper.getDefault(id, UUIDHelper.getDefault());
			this.asistio = ObjectHelper.getDefault(asistio, BooleanHelper.FALSE);
			this.asistioFlag = true; // como vino en el JSON, se marcó explícitamente
		}

		public UUID getId() {
			return id;
		}

		public boolean isAsistio() {
			return asistio;
		}

		public boolean isAsistioFlag() {
			return asistioFlag;
		}
	}
}
