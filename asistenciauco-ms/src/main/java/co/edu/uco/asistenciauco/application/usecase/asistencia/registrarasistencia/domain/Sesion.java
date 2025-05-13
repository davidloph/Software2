package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

public class Sesion {

	private UUID id;

	public Sesion(final UUID id) {
		setId(id);
	}

	private UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = id;
	}
	
	
}
