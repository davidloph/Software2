package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class Sesion {

	private UUID id;
	private Grupo grupo;
	private LocalDateTime fechaHora;

	public Sesion() {
		setDefaultId();
		setDefaultGrupo();
		setDefaultFechaHora();
	}


	public Sesion(final UUID id) {
		setId(id);
		setDefaultGrupo();
		setDefaultFechaHora();
	}

	public Sesion(final UUID id, final Grupo grupo, final LocalDateTime fechaHora) {
		setId(id);
		setGrupo(grupo);
		setFechaHora(fechaHora);
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

	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(final Grupo grupo) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.grupo = ObjectHelper.getDefault(grupo, new Grupo());
	}
	private void setDefaultGrupo() {
		setGrupo(new Grupo());
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(final LocalDateTime fechaHora) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.?????????
		this.fechaHora = ObjectHelper.getDefault(fechaHora, LocalDateTime.now());
	}
	private void setDefaultFechaHora() {
		//TODO: OBTENER VALOR POR DEFECTO???????????
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??????
		LocalDateTime defaultValue = LocalDateTime.now();
		setFechaHora(defaultValue);
	}
}
