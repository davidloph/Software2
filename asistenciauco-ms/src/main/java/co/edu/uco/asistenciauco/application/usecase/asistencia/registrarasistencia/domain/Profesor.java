package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.UUIDHelper;

public final class Profesor {

	private UUID id;

	public Profesor() {
		setDefaultId();
	}

	public Profesor(final UUID id) {
		setId(id);
	}

	public UUID getId() {
		return id;
	}
	private void setId(final UUID id) {

		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	private void setDefaultId() {
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}
}
