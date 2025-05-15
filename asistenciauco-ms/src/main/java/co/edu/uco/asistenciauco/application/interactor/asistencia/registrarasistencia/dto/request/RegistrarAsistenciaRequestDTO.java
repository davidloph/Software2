package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request;

import java.util.List;
import java.util.UUID;

public final class RegistrarAsistenciaRequestDTO {

	private UUID sesion;
	private UUID profesor;
	private List<Estudiante> estudiantes;
	
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


	public void setProfesor(final UUID profesor) {
		this.profesor = profesor;
	}


	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(final List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}


	public class Estudiante {
		private UUID id;
		private boolean asistio;
		private boolean asistioFlag;
		//TODO: SABER SI EL "ASISTIÓ" FUE POR DEFECTO O REALMENTE NO ASISTIÓ.
		
		
		public Estudiante() {
			setDefaultId();
			setDefaultAsistio();
		}
		
		public Estudiante(final UUID id) {
			setId(id);
			setDefaultAsistio();
		}

		public Estudiante(final UUID id, final boolean asistio) {
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
			UUID defaultValue = null;
			setId(defaultValue);
		}

		public boolean isAsistio() {
			return asistio;
		}

		public void setAsistio(final boolean asistio) {
			this.asistioFlag = true;
			this.asistio = asistio;
		}
		
		public void setDefaultAsistio() {
			this.asistioFlag = false;
			this.asistio = asistio;
		}

		public boolean isAsistioFlag() {
			return asistioFlag;
		}
		
	}
}
