package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

public class Profesor {

	private UUID id;

	public Profesor(final UUID id) {
		super();
		setId(id);
	}

	private UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = id;
	}
	
	
}
