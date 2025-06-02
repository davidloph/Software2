package co.edu.uco.asistenciauco.application.outputport.dto;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public final class EstudianteGrupoDTO {

	private String id;
	private GrupoDTO grupo;
	private EstudianteDTO estudiante;
	private boolean cancelo;
	
	public EstudianteGrupoDTO() {
		setDefaultId();
		setDefaultGrupo();
		setDefaultEstudiante();
		setDefaultCancelo();
	}
	
	
	public EstudianteGrupoDTO(final String id) {
		setId(id);
		setDefaultGrupo();
		setDefaultEstudiante();
		setDefaultCancelo();
	}
	
	public EstudianteGrupoDTO(final String id, final GrupoDTO grupo, final EstudianteDTO estudiante, final boolean cancelo) {
		setId(id);
		setGrupo(grupo);
		setEstudiante(estudiante);
		setCancelo(cancelo);
	}

	
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = TextHelper.getDefault(TextHelper.applyTrim(id), UUIDHelper.getDefaultAsString());
	}
	
	private void setDefaultId() {
		String defaultValue = UUIDHelper.getDefaultAsString();
		setId(defaultValue);
	}
	
	public GrupoDTO getGrupo() {
		return grupo;
	}
	public void setGrupo(final GrupoDTO grupo) {
		this.grupo = ObjectHelper.getDefault(grupo, new GrupoDTO());
	}
	private void setDefaultGrupo() {
		setGrupo(new GrupoDTO());
	}
	
	public EstudianteDTO getEstudiante() {
		return estudiante;
	}
	private void setEstudiante(final EstudianteDTO estudiante) {
		this.estudiante = ObjectHelper.getDefault(estudiante, new EstudianteDTO());
	}
	private void setDefaultEstudiante() {
		setEstudiante(new EstudianteDTO());
	}

	public boolean getCancelo() {
		return cancelo;
	}

	private void setCancelo(final boolean cancelo) {
		this.cancelo = ObjectHelper.getDefault(cancelo, BooleanHelper.FALSE);
	}

	private void setDefaultCancelo() {
		this.cancelo = BooleanHelper.FALSE;
	}
}
