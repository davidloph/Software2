package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.dto;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class EstudianteDTO extends DomainDTO{
	private boolean asistio;

	public EstudianteDTO() {
		super(UUIDHelper.getDefaultAsString());
		setAsistio(BooleanHelper.FALSE);
	}
	
	public static final EstudianteDTO create() {
		return new EstudianteDTO();
	}
	
	@Override
	public String getId() {
		return super.getId();
	}
	
	public EstudianteDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}

	private boolean isAsistio() {
		return asistio;
	}

	private EstudianteDTO setAsistio(final boolean asistio) {
		this.asistio = asistio;
		return this;
	}
	
	
}
