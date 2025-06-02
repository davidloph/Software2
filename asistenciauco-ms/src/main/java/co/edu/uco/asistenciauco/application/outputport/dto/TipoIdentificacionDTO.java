package co.edu.uco.asistenciauco.application.outputport.dto;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;


public final class TipoIdentificacionDTO {

	private String id;
	private String clave;
	private String nombre;
	
	public TipoIdentificacionDTO() {
		setDefaultId();
		setDefaultClave();
		setDefaultNombre();
	}
	
	
	public TipoIdentificacionDTO(final String id) {
		setId(id);
		setDefaultClave();
		setDefaultNombre();
	}
	
	public TipoIdentificacionDTO(final String id, final String clave, final String nombre) {
		setId(id);
		setClave(clave);
		setNombre(nombre);
	}


	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = TextHelper.getDefault(TextHelper.applyTrim(id), UUIDHelper.getDefaultAsString());
	}
	public String getClave() {
		return clave;
	}
	public void setClave(final String clave) {
		this.clave = TextHelper.applyTrim(TextHelper.getDefault(clave));
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(TextHelper.getDefault(nombre));
	}
	
	private void setDefaultId() {
		String defaultValue = UUIDHelper.getDefaultAsString();
		setId(defaultValue);
	}
	public void setDefaultClave() {
		var defaultValue = TextHelper.EMPTY;
		setClave(defaultValue);
	}
	
	public void setDefaultNombre() {
		var defaultValue = TextHelper.EMPTY;
		setNombre(defaultValue);
	}
}
