package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

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
	private Cancelo cancelo;

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

	public EstudianteGrupo(final UUID id, final Grupo grupo, final Estudiante estudiante,  final Cancelo canelo) {
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
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}

	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(final Grupo grupo) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.grupo = ObjectHelper.getDefault(grupo, new Grupo());
	}
	private void setDefaultGrupo() {
		setGrupo(new Grupo());
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(final Estudiante estudiante) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.estudiante = ObjectHelper.getDefault(estudiante, new Estudiante());
	}
	private void setDefaultEstudiante() {
		setEstudiante(new Estudiante());
	}

	public Cancelo getCancelo() {
		return cancelo;
	}
	public void setCancelo(final Cancelo cancelo) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.cancelo = ObjectHelper.getDefault(cancelo, new Cancelo());
	}
	private void setDefaultCancelo() {
		setCancelo(new Cancelo());
	}


}
