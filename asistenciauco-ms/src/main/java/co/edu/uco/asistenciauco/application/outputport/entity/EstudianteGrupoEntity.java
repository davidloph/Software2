package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.EstudianteGrupoConstants;
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
@Table(name = EstudianteGrupoConstants.TABLE_ESTUDIANTE_GRUPO)
public final class EstudianteGrupoEntity {
	@Id
	@Column(name = EstudianteGrupoConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
    @JoinColumn(name = EstudianteGrupoConstants.COLUMN_GRUPO)
	private GrupoEntity grupo;
	@ManyToOne
	@JoinColumn(name = EstudianteGrupoConstants.COLUMN_ESTUDIANTE)
	private EstudianteEntity estudiante;
	@Column(name = EstudianteGrupoConstants.COLUMN_CANCELO)
	private boolean cancelo;
	
	public EstudianteGrupoEntity() {
		setDefaultId();
		setDefaultGrupo();
		setDefaultEstudiante();
		setDefaultCancelo();
	}
	
	
	public EstudianteGrupoEntity(final UUID id) {
		setId(id);
		setDefaultGrupo();
		setDefaultEstudiante();
		setDefaultCancelo();
	}
	
	public EstudianteGrupoEntity(final UUID id, final GrupoEntity grupo, final EstudianteEntity estudiante,  final boolean cancelo) {
		setId(id);
		setGrupo(grupo);
		setEstudiante(estudiante);
		setCancelo(cancelo);
	}

	
	public UUID getId() {
		return id;
	}
	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	
	private void setDefaultId() {
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}
	
	public GrupoEntity getGrupo() {
		return grupo;
	}
	public void setGrupo(final GrupoEntity grupo) {
		this.grupo = ObjectHelper.getDefault(grupo, new GrupoEntity());
	}
	private void setDefaultGrupo() {
		setGrupo(new GrupoEntity());
	}
	
	public EstudianteEntity getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(final EstudianteEntity estudiante) {
		this.estudiante = ObjectHelper.getDefault(estudiante, new EstudianteEntity());
	}
	private void setDefaultEstudiante() {
		setEstudiante(new EstudianteEntity());
	}

	public boolean getCancelo() {
		return cancelo;
	}
	public void setCancelo(final boolean cancelo) {
		this.cancelo = ObjectHelper.getDefault(cancelo, BooleanHelper.FALSE);
	}
	private void setDefaultCancelo() {
		setCancelo(BooleanHelper.FALSE);
	}

}
