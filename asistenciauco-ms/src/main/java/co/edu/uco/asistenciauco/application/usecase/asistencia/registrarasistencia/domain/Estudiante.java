package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

public class Estudiante {

	private UUID id;
	private boolean asistio;

	public Estudiante(final UUID id, final boolean asistio) {
		setId(id);
		setAsistio(asistio);
	}

	private UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = id;
	}

	private boolean isAsistio() {
		return asistio;
	}

	private void setAsistio(final boolean asistio) {
		this.asistio = asistio;
	}
	
	
}
