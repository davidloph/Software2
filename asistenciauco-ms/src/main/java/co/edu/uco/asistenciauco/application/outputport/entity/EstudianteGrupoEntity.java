package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.EstudianteGrupoConstants;
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
@Table(name = EstudianteGrupoConstants.TABLE_ESTUDIANTE_GRUPO)
public final class EstudianteGrupoEntity {
	@Id
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = EstudianteGrupoConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
    @JoinColumn(name = EstudianteGrupoConstants.COLUMN_GRUPO)
	private GrupoEntity grupo;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = EstudianteGrupoConstants.COLUMN_ESTUDIANTE)
	private EstudianteEntity estudiante;
	
	public EstudianteGrupoEntity() {
		setDefaultId();
		setDefaultGrupo();
		setDefaultEstudiante();
	}
	
	
	public EstudianteGrupoEntity(final UUID id) {
		setId(id);
		setDefaultGrupo();
		setDefaultEstudiante();
	}
	
	public EstudianteGrupoEntity(final UUID id, final GrupoEntity grupo, final EstudianteEntity estudiante) {
		setId(id);
		setGrupo(grupo);
		setEstudiante(estudiante);
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
	
	public EstudianteEntity getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(final EstudianteEntity estudiante) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.estudiante = ObjectHelper.getDefault(estudiante, new EstudianteEntity());
	}
	private void setDefaultEstudiante() {
		setEstudiante(new EstudianteEntity());
	}
}
