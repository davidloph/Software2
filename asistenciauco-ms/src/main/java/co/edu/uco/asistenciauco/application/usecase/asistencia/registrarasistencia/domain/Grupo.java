package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.NumericHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class Grupo {

	private UUID id;
	private Profesor profesor;
	private Materia materia;
	private Integer cantidadEstudiantes;

	public Grupo() {
		setDefaultId();
		setDefaultProfesor();
		setDefaultMateria();
		setDefaultCantidadEstudiantes();
	}


	public Grupo(final UUID id) {
		setId(id);
		setDefaultProfesor();
		setDefaultMateria();
		setDefaultCantidadEstudiantes();
	}

	public Grupo(final UUID id, final Profesor profesor, final Materia materia, final int cantidadEstudiantes) {
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
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}

	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(final Profesor profesor) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.profesor = ObjectHelper.getDefault(profesor, new Profesor());
	}
	private void setDefaultProfesor() {
		setProfesor(new Profesor());
	}

	public Materia getMateria() {
		return materia;
	}
	public void setMateria(final Materia materia) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.******
		this.materia = ObjectHelper.getDefault(materia, new Materia());
	}
	private void setDefaultMateria() {
		//TODO: OBTENER VALOR POR DEFECTO???
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??
		setMateria(new Materia());
	}

	public Integer getCantidadEstudiantes() {
		return cantidadEstudiantes;
	}
	public void setCantidadEstudiantes(final Integer cantidadEstudiantes) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.?????????
		this.cantidadEstudiantes = ObjectHelper.getDefault(cantidadEstudiantes, NumericHelper.ZERO);
	}
	private void setDefaultCantidadEstudiantes() {
		//TODO: OBTENER VALOR POR DEFECTO???????????
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??????
		Integer defaultValue = NumericHelper.ZERO;
		setCantidadEstudiantes(defaultValue);
	}
}
