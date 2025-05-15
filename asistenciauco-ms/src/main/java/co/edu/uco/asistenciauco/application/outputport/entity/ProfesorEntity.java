package co.edu.uco.asistenciauco.application.outputport.entity;

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

@Entity
//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
@Table(name = ProfesorConstants.TABLE_PROFESOR)
public final class ProfesorEntity {
	@Id
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = ProfesorConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
    @JoinColumn(name = ProfesorConstants.COLUMN_TIPO_IDENTIFICACION)
	private TipoIdentificacionEntity tipoIdentificacion;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = ProfesorConstants.COLUMN_NUMERO_IDENTIFICACION)
	private String numeroIdentificacion;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = ProfesorConstants.COLUMN_NOMBRES_COMPLETOS)
	private String nombresCompletos;
	
	public ProfesorEntity() {
		setDefaultId();
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
	}
	
	
	public ProfesorEntity(final UUID id) {
		setId(id);
		setDefaultTipoIdentificacion();
		setDefaultNumeroIdentificacion();
		setDefaultNombresCompletos();
	}
	
	public ProfesorEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombresCompletos(nombresCompletos);
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
	
	public TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.tipoIdentificacion = ObjectHelper.getDefault(tipoIdentificacion, new TipoIdentificacionEntity());
	}
	private void setDefaultTipoIdentificacion() {
		setTipoIdentificacion(new TipoIdentificacionEntity());
	}
	
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(final String numeroIdentificacion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.******
		this.numeroIdentificacion = TextHelper.applyTrim(numeroIdentificacion);
	}
	private void setDefaultNumeroIdentificacion() {
		//TODO: OBTENER VALOR POR DEFECTO???
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??
		String defaultValue = TextHelper.EMPTY;
		setNumeroIdentificacion(defaultValue);
	}
	
	public String getNombresCompletos() {
		return nombresCompletos;
	}
	public void setNombresCompletos(final String nombresCompletos) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.******
		this.nombresCompletos = TextHelper.applyTrim(nombresCompletos);
	}
	private void setDefaultNombresCompletos() {
		//TODO: OBTENER VALOR POR DEFECTO???????????
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??????
		String defaultValue = TextHelper.EMPTY;
		setNombresCompletos(defaultValue);
	}
}
