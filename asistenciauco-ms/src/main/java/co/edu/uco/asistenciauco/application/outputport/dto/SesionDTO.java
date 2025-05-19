package co.edu.uco.asistenciauco.application.outputport.dto;

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
	
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(final String fechaHora) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.?????????
		this.fechaHora = TextHelper.applyTrim(ObjectHelper.getDefault(fechaHora, LocalDateTime.now().toString()));
	}
	private void setDefaultFechaHora() {
		//TODO: OBTENER VALOR POR DEFECTO???????????
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??????
		String defaultValue = LocalDateTime.now().toString();
		setFechaHora(defaultValue);
	}
}
