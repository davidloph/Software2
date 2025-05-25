package co.edu.uco.asistenciauco.application.outputport.dto;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

public final class EstudianteDTO extends UsuarioDTO{

	private UsuarioDTO usuario;

	public EstudianteDTO() {
		super();
		setDefaultUsuario();
	}


	public EstudianteDTO(final String id) {
		super(id);
		setDefaultUsuario();
	}

	public EstudianteDTO(final String id, final TipoIdentificacionDTO tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos, final String correo, final UsuarioDTO usuario) {
		super(id, tipoIdentificacion, numeroIdentificacion, nombresCompletos, correo);
		setUsuario(usuario);
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = ObjectHelper.getDefault(usuario, new UsuarioDTO());
	}

	private void setDefaultUsuario() {

		setUsuario(new UsuarioDTO());
	}
}
