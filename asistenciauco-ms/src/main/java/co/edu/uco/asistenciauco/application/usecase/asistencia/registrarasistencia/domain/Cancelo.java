package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import co.edu.uco.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class Cancelo {

	private UUID id;

	public Cancelo(final UUID id) {
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
