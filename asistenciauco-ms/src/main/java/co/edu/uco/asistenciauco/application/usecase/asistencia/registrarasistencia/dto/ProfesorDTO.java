package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.dto;

import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class ProfesorDTO extends DomainDTO{
	
	public ProfesorDTO() {
		super(UUIDHelper.getDefaultAsString());
	}
	
	public static final ProfesorDTO create() {
		return new ProfesorDTO();
	}
	
	@Override
	public String getId() {
		return super.getId();
	}
	
	public ProfesorDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
}
