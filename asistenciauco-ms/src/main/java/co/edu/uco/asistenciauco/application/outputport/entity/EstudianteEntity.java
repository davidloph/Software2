package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
@Table(name = "Estudiante")
public final class EstudianteEntity {
	@Id
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = "id")
	private UUID id;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
    @JoinColumn(name = "tipo_identificacion")
	private TipoIdentificacionEntity tipoIdentificacion;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = "numeroIdentificacion")
	private String numeroIdentificacion;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = "nombresCompletos")
	private String nombresCompletos;
	
	public EstudianteEntity() {
		setDefaultId();
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
	}
	
	
	public EstudianteEntity(final UUID id) {
		setId(id);
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
	}
	
	public EstudianteEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombresCompletos(nombresCompletos);
	}

	
	public UUID getId() {
		return id;
	}
	public void setId(final UUID id) {
		this.id = id;
	}
	
	private void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = null;
		setId(defaultValue);
	}
	
	public TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		this.tipoIdentificacion = tipoIdentificacion;
	}
	private void setDefaultTipoIdentificacion() {
		setTipoIdentificacion(new TipoIdentificacionEntity());
	}
	
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(final String numeroIdentificacion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		this.numeroIdentificacion = numeroIdentificacion;
	}
	private void setDefaultNumeroIdentificacion() {
		//TODO: OBTENER VALOR POR DEFECTO
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		String defaultValue = "";
		setNumeroIdentificacion(defaultValue);
	}
	
	public String getNombresCompletos() {
		return nombresCompletos;
	}
	public void setNombresCompletos(final String nombresCompletos) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.
		this.nombresCompletos = nombresCompletos;
	}
	private void setDefaultNombresCompletos() {
		//TODO: OBTENER VALOR POR DEFECTO
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		String defaultValue = "";
		setNombresCompletos(defaultValue);
	}
}
