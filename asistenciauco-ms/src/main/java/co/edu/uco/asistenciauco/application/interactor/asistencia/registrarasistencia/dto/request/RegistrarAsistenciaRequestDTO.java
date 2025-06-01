package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

import java.util.List;
import java.util.UUID;

public final class RegistrarAsistenciaRequestDTO {

	private UUID sesion;
	private UUID profesor;
	private List<EstudianteDTORequest> estudiantes;
	
	public RegistrarAsistenciaRequestDTO() {
		super();
	}
	
	public UUID getSesion() {
		return sesion;
	}


	public void setSesion(final UUID sesion) {
		this.sesion = sesion;
	}


	public UUID getProfesor() {
		return profesor;
	}


	private void setProfesor(final UUID profesor) {
		this.profesor = profesor;
	}


	public List<EstudianteDTORequest> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(final List<EstudianteDTORequest> estudiantes) {
		this.estudiantes = estudiantes;

	}


	public class EstudianteDTORequest {
		private UUID id;
		private boolean asistio;
		private boolean asistioFlag = BooleanHelper.FALSE;
		//TODO: SABER SI EL "ASISTIÓ" FUE POR DEFECTO O REALMENTE NO ASISTIÓ.

		public EstudianteDTORequest() {
			setDefaultId();
			setDefaultAsistio();
		}
		
		public EstudianteDTORequest(final UUID id) {
			setId(id);
			setDefaultAsistio();
		}

		public EstudianteDTORequest(final UUID id, final boolean asistio) {
			setId(id);
			setAsistio(asistio);
		}

		public UUID getId() {
			return id;
		}

		public void setId(final UUID id) {
			this.id = id;
		}

		public void setDefaultId() {
			UUID defaultValue = UUIDHelper.getDefault();
			setId(defaultValue);
		}

		public boolean isAsistio() {
			return asistio;
		}

		public void setAsistio(final boolean asistio) {
			this.asistioFlag = BooleanHelper.TRUE;
			this.asistio = asistio;
		}
		
		public void setDefaultAsistio() {
			this.asistioFlag = BooleanHelper.FALSE;
			this.asistio = asistio;
		}

		public boolean isAsistioFlag() {
			return asistioFlag;
		}
		
	}
}
