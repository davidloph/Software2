package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public final class Profesor {

	private UUID id;

	public Profesor() {
		setDefaultId();
	}

	public Profesor(UUID id) {
		setId(id);
	}

	public Profesor(final UUID id, final Usuario usuario) {
		setId(id);
	}

	public UUID getId() {

		return id;
	}
	private void setId(final UUID id) {

		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	private void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}
}
