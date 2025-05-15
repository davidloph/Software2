package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
@Table(name = AsistenciaConstants.TABLE_ASISTENCIA)
public final class AsistenciaEntity {
	@Id
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = AsistenciaConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
    @JoinColumn(name = AsistenciaConstants.COLUMN_ESTUDIANTE_GRUPO)
	private EstudianteGrupoEntity estudianteGrupo;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = AsistenciaConstants.COLUMN_SESION)
	private SesionEntity sesion;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = AsistenciaConstants.COLUMN_ASISTIO)
	private Boolean asistio;
	
	
	public AsistenciaEntity() {
		setDefaultId();
		setDefaultEstudianteGrupo();
		setDefaultSesion();
		setDefaultAsistio();
	}
	
	
	public AsistenciaEntity(final UUID id) {
		setId(id);
		setDefaultEstudianteGrupo();
		setDefaultSesion();
		setDefaultAsistio();
	}
	
	public AsistenciaEntity(final UUID id, final EstudianteGrupoEntity estudianteGrupo, final SesionEntity sesion, final Boolean asistio) {
		setId(id);
		setEstudianteGrupo(estudianteGrupo);
		setSesion(sesion);
		setAsistio(asistio);
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
	
	public EstudianteGrupoEntity getEstudianteGrupo() {
		return estudianteGrupo;
	}
	public void setEstudianteGrupo(final EstudianteGrupoEntity estudianteGrupo) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.estudianteGrupo = ObjectHelper.getDefault(estudianteGrupo, new EstudianteGrupoEntity());
	}
	private void setDefaultEstudianteGrupo() {
		setEstudianteGrupo(new EstudianteGrupoEntity());
	}
	
	public SesionEntity getSesion() {
		return sesion;
	}
	public void setSesion(final SesionEntity sesion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.sesion = ObjectHelper.getDefault(sesion, new SesionEntity());
	}
	private void setDefaultSesion() {
		setSesion(new SesionEntity());
	}
	
	public Boolean getAsistio() {
		return asistio;
	}
	public void setAsistio(final Boolean asistio) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.asistio = ObjectHelper.getDefault(asistio, BooleanHelper.FALSE);
	}
	private void setDefaultAsistio() {
		setAsistio(BooleanHelper.FALSE);
	}
}
