package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.GrupoConstants;
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
@Table(name = GrupoConstants.TABLE_GRUPO)
public final class GrupoEntity {
	@Id
	@Column(name = GrupoConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
    @JoinColumn(name = GrupoConstants.COLUMN_PROFESOR)
	private ProfesorEntity profesor;
	@ManyToOne
	@JoinColumn(name = GrupoConstants.COLUMN_MATERIA)
	private MateriaEntity materia;
	@Column(name = GrupoConstants.COLUMN_CANTIDADESTUDIANTES)
	private Integer cantidadEstudiantes;
	@Column(name = GrupoConstants.COLUMN_ACTIVO)
	private boolean activo;
	
	public GrupoEntity() {
		setDefaultId();
		setDefaultProfesor();
		setDefaultMateria();
		setDefaultCantidadEstudiantes();
	}
	
	
	public GrupoEntity(final UUID id) {
		setId(id);
		setDefaultProfesor();
		setDefaultMateria();
		setDefaultCantidadEstudiantes();
	}
	
	public GrupoEntity(final UUID id, final ProfesorEntity profesor, final MateriaEntity materia, final int cantidadEstudiantes) {
		setId(id);
		setProfesor(profesor);
		setMateria(materia);
		setCantidadEstudiantes(cantidadEstudiantes);
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
	
	public ProfesorEntity getProfesor() {
		return profesor;
	}
	public void setProfesor(final ProfesorEntity profesor) {
		this.profesor = ObjectHelper.getDefault(profesor, new ProfesorEntity());
	}
	private void setDefaultProfesor() {
		setProfesor(new ProfesorEntity());
	}
	
	public MateriaEntity getMateria() {
		return materia;
	}
	public void setMateria(final MateriaEntity materia) {
		this.materia = ObjectHelper.getDefault(materia, new MateriaEntity());
	}
	private void setDefaultMateria() {
		setMateria(new MateriaEntity());
	}
	
	public Integer getCantidadEstudiantes() {
		return cantidadEstudiantes;
	}
	public void setCantidadEstudiantes(final Integer cantidadEstudiantes) {
		this.cantidadEstudiantes = ObjectHelper.getDefault(cantidadEstudiantes, NumericHelper.ZERO);
	}
	private void setDefaultCantidadEstudiantes() {
		Integer defaultValue = NumericHelper.ZERO;
		setCantidadEstudiantes(defaultValue);
	}
}
