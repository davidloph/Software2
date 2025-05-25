package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import co.edu.uco.crosscutting.helpers.BooleanHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class Asistencia {
	private UUID id;
	private EstudianteGrupo estudianteGrupo;
	private Sesion sesion;
	private boolean asistio;
	private boolean asistioDefault = true;


	public Asistencia() {
		setDefaultId();
		setDefaultEstudianteGrupo();
		setDefaultSesion();
		setDefaultAsistio();
	}


	public Asistencia(final UUID id) {
		setId(id);
		setDefaultEstudianteGrupo();
		setDefaultSesion();
		setDefaultAsistio();
	}

	public Asistencia(final UUID id, final EstudianteGrupo estudianteGrupo, final Sesion sesion, final Boolean asistio) {
		setId(id);
		setEstudianteGrupo(estudianteGrupo);
		setSesion(sesion);
		setAsistio(asistio);
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
	
	public EstudianteGrupo getEstudianteGrupo() {
		return estudianteGrupo;
	}
	public void setEstudianteGrupo(final EstudianteGrupo estudianteGrupo) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.estudianteGrupo = ObjectHelper.getDefault(estudianteGrupo, new EstudianteGrupo());
	}
	private void setDefaultEstudianteGrupo() {
		setEstudianteGrupo(new EstudianteGrupo());
	}
	
	public Sesion getSesion() {
		return sesion;
	}
	public void setSesion(final Sesion sesion) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.sesion = ObjectHelper.getDefault(sesion, new Sesion());
	}
	private void setDefaultSesion() {
		setSesion(new Sesion());
	}
	
	public Boolean isAsistio() {
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
