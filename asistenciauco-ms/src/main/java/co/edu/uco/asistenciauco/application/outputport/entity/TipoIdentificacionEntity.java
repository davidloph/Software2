package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
@Table(name = TipoIdentificacionConstants.TABLE_TIPO_IDENTIFICACION)
public final class TipoIdentificacionEntity {
	@Id
	@Column(name = TipoIdentificacionConstants.COLUMN_ID)
	private UUID id;
	@Column(name = TipoIdentificacionConstants.COLUMN_CLAVE)
	private String clave;
	@Column(name = TipoIdentificacionConstants.COLUMN_NOMBRE)
	private String nombre;
	
	public TipoIdentificacionEntity() {
		setDefaultId();
		setDefaultClave();
		setDefaultNombre();
	}
	
	
	public TipoIdentificacionEntity(final UUID id) {
		setId(id);
		setDefaultClave();
		setDefaultNombre();
	}
	
	public TipoIdentificacionEntity(final UUID id, final String clave, final String nombre) {
		setId(id);
		setClave(clave);
		setNombre(nombre);
	}


	public UUID getId() {
		return id;
	}
	public void setId(final UUID id) {
		this.id = id;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(final String clave) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		this.nombre = nombre;
	}
	
	private void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = null;
		setId(defaultValue);
	}
	public void setDefaultClave() {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		var defaultValue = "";
		setClave(defaultValue);
	}
	
	public void setDefaultNombre() {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		var defaultValue = "";
		setNombre(defaultValue);
	}
}
