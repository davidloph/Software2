package co.edu.uco.asistenciauco.application.outputport.dto;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public final class MateriaDTO {

	private String id;
	private String clave;
	private String nombre;
	
	public MateriaDTO() {
		setDefaultId();
		setDefaultClave();
		setDefaultNombre();
	}
	
	
	public MateriaDTO(final String id) {
		setId(id);
		setDefaultClave();
		setDefaultNombre();
	}
	
	public MateriaDTO(final String id, final String clave, final String nombre) {
		setId(id);
		setClave(clave);
		setNombre(nombre);
	}

	
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = TextHelper.applyTrim(id);
	}
	
	private void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		String defaultValue = UUIDHelper.getDefaultAsString();
		setId(defaultValue);
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(final String clave) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.clave = TextHelper.applyTrim(clave);
	}
	private void setDefaultClave() {
		setClave(TextHelper.EMPTY);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.******
		this.nombre = TextHelper.applyTrim(nombre);
	}
	private void setDefaultNombre() {
		//TODO: OBTENER VALOR POR DEFECTO???
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??
		String defaultValue = TextHelper.EMPTY;
		setNombre(defaultValue);
	}
	
	
}
