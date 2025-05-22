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

	private String id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombresCompletos;

	public EstudianteDTO() {
		setDefaultId();
		setDefaultNumeroIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
	}


	public EstudianteDTO(final String id) {
		setId(id);
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
	}

	public EstudianteDTO(final String id, final TipoIdentificacionDTO tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombresCompletos(nombresCompletos);
	}
}
