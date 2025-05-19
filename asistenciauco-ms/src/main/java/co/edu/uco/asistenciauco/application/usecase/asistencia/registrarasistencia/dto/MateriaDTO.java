package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.dto;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class MateriaDTO extends DomainDTO{

	private String clave;
	private String nombre;
	
	public MateriaDTO() {
		super(UUIDHelper.getDefaultAsString());
	}
	
	public static final MateriaDTO create() {
		return new MateriaDTO();
	}
	
	@Override
	public String getId() {
		return super.getId();
	}
	
	public MateriaDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
}
