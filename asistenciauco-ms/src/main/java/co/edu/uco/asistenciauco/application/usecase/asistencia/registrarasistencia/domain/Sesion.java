package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public final class Sesion {

	private UUID id;

	public Sesion() {
		setDefaultId();
	}


	public Sesion(final UUID id) {
		setId(id);
	}

	public Sesion(final UUID id, final Grupo grupo, final LocalDateTime fechaHora) {
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
