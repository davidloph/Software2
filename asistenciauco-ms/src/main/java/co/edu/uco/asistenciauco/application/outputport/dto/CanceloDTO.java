package co.edu.uco.asistenciauco.application.outputport.dto;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.AsistenciaConstants;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.CanceloConstants;
import co.edu.uco.crosscutting.helpers.DateHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

public final class CanceloDTO {
	private String id;
	private EstudianteGrupoDTO estudianteGrupo;
	private String fecha;
	private String motivo;
	private boolean activo = false;
	private boolean activoDefault = true;




	public CanceloDTO() {
		setDefaultId();
		setDefaultEstudianteGrupo();
		setDefaultFecha();
		setDefaultMotivo();
	}


	public CanceloDTO(final String id) {
		setId(id);
		setDefaultEstudianteGrupo();
		setDefaultFecha();
		setDefaultMotivo();
	}

	public CanceloDTO(final String id, final EstudianteGrupoDTO estudianteGrupo, final String fecha, final String motivo, final Boolean activo) {
		setId(id);
		setEstudianteGrupo(estudianteGrupo);
		setFecha(fecha);
		setMotivo(motivo);
		setActivo(activo);
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(final boolean activo) {
		this.activo = activo;
		this.activoDefault = false;
	}

	public EstudianteGrupoDTO getEstudianteGrupo() {
		return estudianteGrupo;
	}

	public void setEstudianteGrupo(final EstudianteGrupoDTO estudianteGrupo) {
		this.estudianteGrupo = ObjectHelper.getDefault(estudianteGrupo, new EstudianteGrupoDTO());
	}

	public void setDefaultEstudianteGrupo() {
		this.estudianteGrupo = new EstudianteGrupoDTO();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(final String fecha) {
		this.fecha = ObjectHelper.getDefault(fecha, DateHelper.getDefaultAsString());
	}

	public void setDefaultFecha(){
		this.fecha = DateHelper.getDefaultAsString();
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
