package co.edu.uco.asistenciauco.application.outputport.dto;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

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
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		this.clave = TextHelper.applyTrim(TextHelper.getDefault(clave));
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		this.nombre = TextHelper.applyTrim(TextHelper.getDefault(nombre));
	}
	
	private void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		String defaultValue = UUIDHelper.getDefaultAsString();
		setId(defaultValue);
	}
	public void setDefaultClave() {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		var defaultValue = TextHelper.EMPTY;
		setClave(defaultValue);
	}
	
	public void setDefaultNombre() {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		var defaultValue = TextHelper.EMPTY;
		setNombre(defaultValue);
	}
}
