package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.List;
import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class Asistencia {

	private UUID id;
	private Sesion sesion;
	private Profesor profesor;
	private List<Estudiante> estudiantes;
	
	

	public Asistencia(final UUID id, final Sesion sesion, final Profesor profesor, final List<Estudiante> estudiantes) {
		setId(id);
		setSesion(sesion);
		setProfesor(profesor);
		setEstudiantes(estudiantes);
	}



	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}



	public Sesion getSesion() {
		return sesion;
	}



	private void setSesion(final Sesion sesion) {
		this.sesion = ObjectHelper.getDefault(sesion, new Sesion());
	}



	public Profesor getProfesor() {
		return profesor;
	}



	private void setProfesor(final Profesor profesor) {
		this.profesor = profesor;
	}



	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}



	private void setEstudiantes(final List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	
	
	
}
