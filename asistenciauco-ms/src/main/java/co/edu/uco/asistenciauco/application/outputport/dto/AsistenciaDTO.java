package co.edu.uco.asistenciauco.application.outputport.dto;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

public final class AsistenciaDTO {

	private String id;
	private EstudianteGrupoDTO estudianteGrupo;
	private SesionDTO sesion;
	private boolean asistio;
	private boolean asistioDefault = true;
	
	
	public AsistenciaDTO() {
		setDefaultId();
		setDefaultEstudianteGrupo();
		setDefaultSesion();
		setDefaultAsistio();
	}
	
	
	public AsistenciaDTO(final String id) {
		setId(id);
		setDefaultEstudianteGrupo();
		setDefaultSesion();
		setDefaultAsistio();
	}
	
	public AsistenciaDTO(final String id, final EstudianteGrupoDTO estudianteGrupo, final SesionDTO sesion, final boolean asistio) {
		setId(id);
		setEstudianteGrupo(estudianteGrupo);
		setSesion(sesion);
		setAsistio(asistio);
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
	
	public EstudianteGrupoDTO getEstudianteGrupo() {
		return estudianteGrupo;
	}
	public void setEstudianteGrupo(final EstudianteGrupoDTO estudianteGrupo) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.estudianteGrupo = ObjectHelper.getDefault(estudianteGrupo, new EstudianteGrupoDTO());
	}
	private void setDefaultEstudianteGrupo() {
		setEstudianteGrupo(new EstudianteGrupoDTO());
	}
	
	public SesionDTO getSesion() {
		return sesion;
	}
	public void setSesion(final SesionDTO sesion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.sesion = ObjectHelper.getDefault(sesion, new SesionDTO());
	}
	private void setDefaultSesion() {
		setSesion(new SesionDTO());
	}
	
	public Boolean getAsistio() {
		return asistio;
	}
	public void setAsistio(final boolean asistio) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.asistio = ObjectHelper.getDefault(asistio, BooleanHelper.FALSE);
		asistioDefault = false;
	}
	private void setDefaultAsistio() {
		setAsistio(BooleanHelper.FALSE);
	}
}
