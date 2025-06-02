package co.edu.uco.asistenciauco.application.outputport.dto;


import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class UsuarioDTO {
	private String id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombresCompletos;
	private String correo;

	public UsuarioDTO() {
		setDefaultId();
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
		setDefaultCorreo();
	}
	
	
	public UsuarioDTO(final String id) {
		setId(id);
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
		setDefaultCorreo();
	}
	
	public UsuarioDTO(final String id, final TipoIdentificacionDTO tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos, final String correo) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombresCompletos(nombresCompletos);
		setCorreo(correo);
	}

	
	public String getId() {
		return id;
	}
	protected void setId(final String id) {
		this.id = TextHelper.getDefault(TextHelper.applyTrim(id), UUIDHelper.getDefaultAsString());
	}

	protected void setDefaultId() {
		String defaultValue = UUIDHelper.getDefaultAsString();
		setId(defaultValue);
	}
	
	public TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	protected void setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = ObjectHelper.getDefault(tipoIdentificacion, new TipoIdentificacionDTO());
	}
	protected void setDefaultTipoIdentificacion() {
		setTipoIdentificacion(new TipoIdentificacionDTO());
	}
	
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	protected void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = TextHelper.applyTrim(TextHelper.getDefault(numeroIdentificacion));
	}
	protected void setDefaultNumeroIdentificacion() {
		String defaultValue = TextHelper.EMPTY;
		setNumeroIdentificacion(defaultValue);
	}
	
	public String getNombresCompletos() {
		return nombresCompletos;
	}
	protected void setNombresCompletos(final String nombresCompletos) {
		this.nombresCompletos = TextHelper.applyTrim(TextHelper.getDefault(nombresCompletos));
	}
	protected void setDefaultNombresCompletos() {
		String defaultValue = TextHelper.EMPTY;
		setNombresCompletos(defaultValue);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = TextHelper.applyTrim(TextHelper.getDefault(correo));
	}

	protected void setDefaultCorreo() {
		String defaultValue = TextHelper.EMPTY;
		setCorreo(defaultValue);
	}
}
