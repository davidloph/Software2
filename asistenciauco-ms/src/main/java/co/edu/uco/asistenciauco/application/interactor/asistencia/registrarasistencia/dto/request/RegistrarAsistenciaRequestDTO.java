package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class RegistrarAsistenciaRequestDTO {

	private UUID sesion;
	private UUID profesor;
	private List<EstudianteDTORequest> estudiantes;

	public RegistrarAsistenciaRequestDTO() {
		setDefaultSesion();
		setDefaultProfesor();
		setdefaultEstudiantes();
	}

	public RegistrarAsistenciaRequestDTO(final UUID sesion, final UUID profesor,final List<EstudianteDTORequest> estudiantes) {
		setSesion(sesion);
		setProfesor(profesor);
		setEstudiantes(estudiantes);
	}

	public UUID getSesion() {
		return sesion;
	}


	private void setSesion(final UUID sesion) {
		this.sesion = ObjectHelper.getDefault(sesion, UUIDHelper.getDefault());
	}


	public UUID getProfesor() {
		return profesor;
	}


	private void setProfesor(final UUID profesor) {
		this.profesor = UUIDHelper.getDefault(profesor, UUIDHelper.getDefault());
	}


	public List<EstudianteDTORequest> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(final List<EstudianteDTORequest> estudiantes) {
		this.estudiantes = ObjectHelper.getDefault(estudiantes,new ArrayList<>());

	}

	public void setDefaultSesion() {
		UUID defaultValue = UUIDHelper.getDefault();
		setSesion(defaultValue);
	}

	public void setDefaultProfesor() {
		UUID defaultValue = UUIDHelper.getDefault();
		setProfesor(defaultValue);
	}

	public void setdefaultEstudiantes(){
		this.estudiantes = new ArrayList<>();

	}

	public static class EstudianteDTORequest {
		private UUID id;
		private boolean asistio;

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
			this.id = ObjectHelper.getDefault(id, UUIDHelper.getDefault());
		}

		public void setDefaultId() {
			UUID defaultValue = UUIDHelper.getDefault();
			setId(defaultValue);
		}

		public boolean isAsistio() {
			return asistio;
		}

		public void setAsistio(final boolean asistio) {
			this.asistio = ObjectHelper.getDefault(asistio, BooleanHelper.FALSE);
		}

		public void setDefaultAsistio() {
			this.asistio = BooleanHelper.FALSE;
		}

	}
}
