package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class Estudiante {

	private UUID id;
	private boolean asistio;
	private boolean asistioDefault = true;

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

	private void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public boolean isAsistio() {
		return asistio;
	}

	private void setAsistio(final boolean asistio) {
		this.asistio = asistio;
		asistioDefault = false;
	}
	
	private void setDefaultAsistio() {
		this.asistio = BooleanHelper.FALSE;
	}
	
	private void setDefaultId() {
		this.id = UUIDHelper.getDefault();
	}
	
	
}
