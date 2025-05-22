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

public final class EstudianteGrupoDTO {

	private String id;
	private GrupoDTO grupo;
	private EstudianteDTO estudiante;
	private CanceloDTO cancelo;
	
	public EstudianteGrupoDTO() {
		setDefaultId();
		setDefaultGrupo();
		setDefaultEstudiante();
	}
	
	
	public EstudianteGrupoDTO(final String id) {
		setId(id);
		setDefaultGrupo();
		setDefaultEstudiante();
	}
	
	public EstudianteGrupoDTO(final String id, final GrupoDTO grupo, final EstudianteDTO estudiante) {
		setId(id);
		setGrupo(grupo);
		setEstudiante(estudiante);
	}

	
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = TextHelper.getDefault(TextHelper.applyTrim(id), UUIDHelper.getDefaultAsString());
	}
	
	private void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		String defaultValue = UUIDHelper.getDefaultAsString();
		setId(defaultValue);
	}
	
	public GrupoDTO getGrupo() {
		return grupo;
	}
	public void setGrupo(final GrupoDTO grupo) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.grupo = ObjectHelper.getDefault(grupo, new GrupoDTO());
	}
	private void setDefaultGrupo() {
		setGrupo(new GrupoDTO());
	}
	
	public EstudianteDTO getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(final EstudianteDTO estudiante) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.estudiante = ObjectHelper.getDefault(estudiante, new EstudianteDTO());
	}
	private void setDefaultEstudiante() {
		setEstudiante(new EstudianteDTO());
	}

	public CanceloDTO getCancelo() {
		return cancelo;
	}

	public void setCancelo(final CanceloDTO cancelo) {
		this.cancelo = ObjectHelper.getDefault(cancelo, new CanceloDTO());
	}

	public void setDefaultCancelo(final CanceloDTO cancelo) {
		this.cancelo = new CanceloDTO();
	}
}
