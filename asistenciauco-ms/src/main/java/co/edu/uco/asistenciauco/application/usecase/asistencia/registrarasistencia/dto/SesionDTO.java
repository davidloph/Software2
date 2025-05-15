package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.dto;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class SesionDTO extends DomainDTO{

	public SesionDTO() {
		super(UUIDHelper.getDefaultAsString());
	}
	
	public static final SesionDTO create() {
		return new SesionDTO();
	}
	
	@Override
	public String getId() {
		return super.getId();
	}
	
	public SesionDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
}
