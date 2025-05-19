package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class Materia {

	private UUID id;

	public Materia () {
		setDefaultId();
	}
	
	public Materia(final UUID id) {
		setId(id);
	}

	private UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	
	private void setDefaultId() {
		this.id = UUIDHelper.getDefault();
	}
	
	
}
