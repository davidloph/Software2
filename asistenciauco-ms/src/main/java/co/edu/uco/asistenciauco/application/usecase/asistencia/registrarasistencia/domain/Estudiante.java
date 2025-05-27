package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class Estudiante {

	private UUID id;
	private Usuario usuario;

	public Estudiante() {
		setDefaultId();
		setDefaultUsuario();
	}

	public Estudiante (UUID id) {
		setId(id);
		setDefaultUsuario();
	}

	public Estudiante(final UUID id, final Usuario usuario) {
		setId(id);
		setUsuario(usuario);
	}

	public UUID getId() {
		return id;
	}
	private void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	private void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	private void setUsuario(Usuario usuario) {
		this.usuario = ObjectHelper.getDefault(usuario, new Usuario());
	}

	private void setDefaultUsuario() {

		setUsuario(new Usuario());
	}
	
}
