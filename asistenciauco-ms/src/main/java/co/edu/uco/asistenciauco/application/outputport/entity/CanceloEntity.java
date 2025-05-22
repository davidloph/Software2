package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.AsistenciaConstants;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.CanceloConstants;
import co.edu.uco.crosscutting.helpers.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
@Table(name = CanceloConstants.TABLE_CANCELO)
public final class CanceloEntity {
	@Id
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = CanceloConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
    @JoinColumn(name = CanceloConstants.COLUMN_ESTUDIANTE_GRUPO)
	private EstudianteGrupoEntity estudianteGrupo;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = CanceloConstants.COLUMN_FECHA)
	private LocalDate fecha;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = CanceloConstants.COLUMN_MOTIVO)
	private String motivo;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = CanceloConstants.COLUMN_ACTIVO)
	private boolean activo = false;
	private boolean activoDefault = true;




	public CanceloEntity() {
		setDefaultId();
		setDefaultEstudianteGrupo();
		setDefaultFecha();
		setDefaultMotivo();
	}


	public CanceloEntity(final UUID id) {
		setId(id);
		setDefaultEstudianteGrupo();
		setDefaultFecha();
		setDefaultMotivo();
	}

	public CanceloEntity(final UUID id, final EstudianteGrupoEntity estudianteGrupo, final LocalDate fecha, final String motivo, final Boolean activo) {
		setId(id);
		setEstudianteGrupo(estudianteGrupo);
		setFecha(fecha);
		setMotivo(motivo);
		setActivo(activo);
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(final boolean activo) {
		this.activo = activo;
		this.activoDefault = false;
	}

	public EstudianteGrupoEntity getEstudianteGrupo() {
		return estudianteGrupo;
	}

	public void setEstudianteGrupo(final EstudianteGrupoEntity estudianteGrupo) {
		this.estudianteGrupo = ObjectHelper.getDefault(estudianteGrupo, new EstudianteGrupoEntity());
	}

	public void setDefaultEstudianteGrupo() {
		this.estudianteGrupo = new EstudianteGrupoEntity();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(final LocalDate fecha) {
		this.fecha = ObjectHelper.getDefault(fecha, DateHelper.getDefault());
	}

	public void setDefaultFecha(){
		this.fecha = DateHelper.getDefault();
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(final String motivo) {
		this.motivo = TextHelper.applyTrim(TextHelper.getDefault(motivo));
	}

	public void setDefaultMotivo() {
		this.motivo = TextHelper.EMPTY;
	}
}
