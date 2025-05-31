package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EstudianteGrupo {

	private UUID id;
	private Grupo grupo;
	private Estudiante estudiante;
	private boolean cancelo;

	public EstudianteGrupo() {
		setDefaultId();
		setDefaultGrupo();
		setDefaultEstudiante();
		setDefaultCancelo();
	}


	public EstudianteGrupo(final UUID id) {
		setId(id);
		setDefaultGrupo();
		setDefaultEstudiante();
		setDefaultCancelo();
	}

	public EstudianteGrupo(final UUID id, final Grupo grupo, final Estudiante estudiante,  final boolean cancelo) {
		setId(id);
		setGrupo(grupo);
		setEstudiante(estudiante);
		setCancelo(cancelo);
	}


	public UUID getId() {
		return id;
	}
	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	private void setDefaultId() {
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}

	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(final Grupo grupo) {
		this.grupo = ObjectHelper.getDefault(grupo, new Grupo());
	}
	private void setDefaultGrupo() {
		setGrupo(new Grupo());
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(final Estudiante estudiante) {
		this.estudiante = ObjectHelper.getDefault(estudiante, new Estudiante());
	}
	private void setDefaultEstudiante() {
		setEstudiante(new Estudiante());
	}

	public boolean getCancelo() {
		return cancelo;
	}
	public void setCancelo(final boolean cancelo) {
		this.cancelo = ObjectHelper.getDefault(cancelo, BooleanHelper.FALSE);
	}
	private void setDefaultCancelo() {
		setCancelo(BooleanHelper.FALSE);
	}

}
