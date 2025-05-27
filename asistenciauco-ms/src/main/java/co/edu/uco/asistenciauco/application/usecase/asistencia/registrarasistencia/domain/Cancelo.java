package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.CanceloConstants;
import co.edu.uco.crosscutting.helpers.DateHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

public class Cancelo {

	private UUID id;
	private EstudianteGrupo estudianteGrupo;
	private LocalDate fecha;
	private String motivo;
	private boolean activo = false;
	private boolean activoDefault = true;




	public Cancelo() {
		setDefaultId();
		setDefaultEstudianteGrupo();
		setDefaultFecha();
		setDefaultMotivo();
	}


	public Cancelo(final UUID id) {
		setId(id);
		setDefaultEstudianteGrupo();
		setDefaultFecha();
		setDefaultMotivo();
	}

	public Cancelo(final UUID id, final EstudianteGrupo estudianteGrupo, final LocalDate fecha, final String motivo, final Boolean activo) {
		setId(id);
		setEstudianteGrupo(estudianteGrupo);
		setFecha(fecha);
		setMotivo(motivo);
		setActivo(activo);
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(final boolean activo) {
		this.activo = activo;
		this.activoDefault = false;
	}

	public EstudianteGrupo getEstudianteGrupo() {
		return estudianteGrupo;
	}

	public void setEstudianteGrupo(final EstudianteGrupo estudianteGrupo) {
		this.estudianteGrupo = ObjectHelper.getDefault(estudianteGrupo, new EstudianteGrupo());
	}

	public void setDefaultEstudianteGrupo() {
		this.estudianteGrupo = new EstudianteGrupo();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(final LocalDate fecha) {
		this.fecha = ObjectHelper.getDefault(fecha, DateHelper.getDefault());
	}

	public void setDefaultFecha(){
		this.fecha = DateHelper.getDefault();
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
