package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.MateriaConstants;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = MateriaConstants.TABLE_MATERIA)
public final class MateriaEntity {
	@Id
	@Column(name = MateriaConstants.COLUMN_ID)
	private UUID id;

    @Column(name = MateriaConstants.COLUMN_CLAVE)
	private String clave;

	@Column(name = MateriaConstants.COLUMN_NOMBRE)
	private String nombre;
	
	public MateriaEntity() {
		setDefaultId();
		setDefaultClave();
		setDefaultNombre();
	}
	
	
	public MateriaEntity(final UUID id) {
		setId(id);
		setDefaultClave();
		setDefaultNombre();
	}
	
	public MateriaEntity(final UUID id, final String clave, final String nombre) {
		setId(id);
		setClave(clave);
		setNombre(nombre);
	}

	
	public UUID getId() {
		return id;
	}
	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	
	private void setDefaultId() {
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(final String clave) {

		this.clave = TextHelper.applyTrim(TextHelper.getDefault(clave));
	}
	private void setDefaultClave() {
		setClave(TextHelper.EMPTY);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {

		this.nombre = TextHelper.applyTrim(TextHelper.getDefault(nombre));;
	}
	private void setDefaultNombre() {
		String defaultValue = TextHelper.EMPTY;
		setNombre(defaultValue);
	}
	
	
}
