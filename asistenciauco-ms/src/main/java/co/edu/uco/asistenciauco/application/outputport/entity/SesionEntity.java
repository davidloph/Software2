package co.edu.uco.asistenciauco.application.outputport.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.crosscutting.helpers.NumericHelper;
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
@Table(name = SesionConstants.TABLE_SESION)
public final class SesionEntity {
	@Id
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = SesionConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
    @JoinColumn(name = SesionConstants.COLUMN_GRUPO)
	private GrupoEntity grupo;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = SesionConstants.COLUMN_FECHA_HORA)
	private LocalDateTime fechaHora;
	
	public SesionEntity() {
		setDefaultId();
		setDefaultGrupo();
		setDefaultFechaHora();
	}
	
	
	public SesionEntity(final UUID id) {
		setId(id);
		setDefaultGrupo();
		setDefaultFechaHora();
	}
	
	public SesionEntity(final UUID id, final GrupoEntity grupo, final LocalDateTime fechaHora) {
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
	
	public GrupoEntity getGrupo() {
		return grupo;
	}
	public void setGrupo(final GrupoEntity grupo) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.grupo = ObjectHelper.getDefault(grupo, new GrupoEntity());
	}
	private void setDefaultGrupo() {
		setGrupo(new GrupoEntity());
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
