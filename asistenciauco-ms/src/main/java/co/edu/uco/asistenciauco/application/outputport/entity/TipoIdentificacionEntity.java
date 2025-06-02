package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.TipoIdentificacionConstants;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
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
		this.id = ObjectHelper.getDefault(id, UUIDHelper.getDefault());
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
		UUID defaultValue = UUIDHelper.getDefault();
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
