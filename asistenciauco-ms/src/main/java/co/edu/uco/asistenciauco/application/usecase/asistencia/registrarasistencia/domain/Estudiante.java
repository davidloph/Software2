package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public final class Estudiante {

	private UUID id;
	private boolean asistio;

	public Estudiante() {
		setDefaultId();
		setDefaultAsistio();
	}

	public Estudiante (final UUID id) {
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

	private void setDefaultId() {
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}

	public boolean isAsistio() {
		return asistio;
	}

	private void setAsistio(final boolean asistio) {
		this.asistio = ObjectHelper.getDefault(asistio, BooleanHelper.FALSE);
	}

	private void setDefaultAsistio() {
		setAsistio(BooleanHelper.FALSE);
	}
}
