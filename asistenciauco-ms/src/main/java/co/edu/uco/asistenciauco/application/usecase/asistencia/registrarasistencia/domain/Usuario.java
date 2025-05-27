package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import co.edu.uco.asistenciauco.application.outputport.entity.TipoIdentificacionEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.UsuarioConstants;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class Usuario {

	private UUID id;
	private TipoIdentificacion tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombresCompletos;
	private String correo;

	public Usuario() {
		setDefaultId();
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
		setDefaultCorreo();
	}


	public Usuario(final UUID id) {
		setId(id);
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
		setDefaultCorreo();
	}

	public Usuario(final UUID id, final TipoIdentificacion tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos, final String correo) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombresCompletos(nombresCompletos);
		setCorreo(correo);
	}


	public UUID getId() {
		return id;
	}
	protected void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	protected void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	protected void setTipoIdentificacion(final TipoIdentificacion tipoIdentificacion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.tipoIdentificacion = ObjectHelper.getDefault(tipoIdentificacion, new TipoIdentificacion());
	}
	protected void setDefaultTipoIdentificacion() {
		setTipoIdentificacion(new TipoIdentificacion());
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	protected void setNumeroIdentificacion(final String numeroIdentificacion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.******
		this.numeroIdentificacion = TextHelper.applyTrim(TextHelper.getDefault(numeroIdentificacion));
	}
	protected void setDefaultNumeroIdentificacion() {
		//TODO: OBTENER VALOR POR DEFECTO???
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??
		String defaultValue = TextHelper.EMPTY;
		setNumeroIdentificacion(defaultValue);
	}

	public String getNombresCompletos() {
		return nombresCompletos;
	}
	protected void setNombresCompletos(final String nombresCompletos) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.******
		this.nombresCompletos = TextHelper.applyTrim(TextHelper.getDefault(nombresCompletos));
	}
	protected void setDefaultNombresCompletos() {
		//TODO: OBTENER VALOR POR DEFECTO???????????
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??????
		String defaultValue = TextHelper.EMPTY;
		setNombresCompletos(defaultValue);
	}

	public String getCorreo() {
		return correo;
	}

	protected void setCorreo(String correo) {
		this.correo = TextHelper.applyTrim(TextHelper.getDefault(correo));
	}

	protected void setDefaultCorreo() {
		this.correo = TextHelper.EMPTY;
	}

}
