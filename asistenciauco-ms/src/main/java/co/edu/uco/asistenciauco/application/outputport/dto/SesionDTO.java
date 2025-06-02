package co.edu.uco.asistenciauco.application.outputport.dto;

import java.time.LocalDateTime;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;


public final class SesionDTO {

	private String id;
	private GrupoDTO grupo;
	private String fechaHora;
	
	public SesionDTO() {
		setDefaultId();
		setDefaultGrupo();
		setDefaultFechaHora();
	}
	
	
	public SesionDTO(final String id) {
		setId(id);
		setDefaultGrupo();
		setDefaultFechaHora();
	}
	
	public SesionDTO(final String id, final GrupoDTO grupo, final String fechaHora) {
		setId(id);
		setGrupo(grupo);
		setFechaHora(fechaHora);
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
	
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(final String fechaHora) {
		this.fechaHora = TextHelper.applyTrim(ObjectHelper.getDefault(fechaHora, LocalDateTime.now().toString()));
	}
	private void setDefaultFechaHora() {
		String defaultValue = LocalDateTime.now().toString();
		setFechaHora(defaultValue);
	}
}
