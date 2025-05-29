package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.UsuarioConstants;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.UsuarioConstants;
import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = UsuarioConstants.TABLE_USUARIO)
public class UsuarioEntity {
	@Id
	@Column(name = UsuarioConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
    @JoinColumn(name = UsuarioConstants.COLUMN_TIPO_IDENTIFICACION)
	private TipoIdentificacionEntity tipoIdentificacion;
	@Column(name = UsuarioConstants.COLUMN_NUMERO_IDENTIFICACION)
	private String numeroIdentificacion;
	@Column(name = UsuarioConstants.COLUMN_NOMBRES_COMPLETOS)
	private String nombresCompletos;
	@Column(name = UsuarioConstants.COLUMN_CORREO)
	private String correo;
	
	public UsuarioEntity() {
		setDefaultId();
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
		setDefaultCorreo();
	}
	
	
	public UsuarioEntity(final UUID id) {
		setId(id);
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
		setDefaultCorreo();
	}
	
	public UsuarioEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos, final String correo) {
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
	
	public TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	protected void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.tipoIdentificacion = ObjectHelper.getDefault(tipoIdentificacion, new TipoIdentificacionEntity());
	}
	protected void setDefaultTipoIdentificacion() {
		setTipoIdentificacion(new TipoIdentificacionEntity());
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
