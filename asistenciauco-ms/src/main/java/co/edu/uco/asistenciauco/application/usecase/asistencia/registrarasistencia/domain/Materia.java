package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class Materia {

	private UUID id;
	private String clave;
	private String nombre;

	public Materia() {
		setDefaultId();
		setDefaultClave();
		setDefaultNombre();
	}


	public Materia(final UUID id) {
		setId(id);
		setDefaultClave();
		setDefaultNombre();
	}

	public Materia(final UUID id, final String clave, final String nombre) {
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
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}

	public String getClave() {
		return clave;
	}
	public void setClave(final String clave) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.clave = TextHelper.applyTrim(TextHelper.getDefault(clave));;
	}
	private void setDefaultClave() {
		setClave(TextHelper.EMPTY);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.******
		this.nombre = TextHelper.applyTrim(TextHelper.getDefault(nombre));;
	}
	private void setDefaultNombre() {
		//TODO: OBTENER VALOR POR DEFECTO???
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??
		String defaultValue = TextHelper.EMPTY;
		setNombre(defaultValue);
	}
}
