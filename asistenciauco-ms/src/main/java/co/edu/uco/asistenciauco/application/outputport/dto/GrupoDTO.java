package co.edu.uco.asistenciauco.application.outputport.dto;

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

public final class GrupoDTO {

	private String id;
	private ProfesorDTO profesor;
	private MateriaDTO materia;
	private Integer cantidadEstudiantes;
	
	public GrupoDTO() {
		setDefaultId();
		setDefaultProfesor();
		setDefaultMateria();
		setDefaultCantidadEstudiantes();
	}
	
	
	public GrupoDTO(final UUID id) {
		setId(id);
		setDefaultProfesor();
		setDefaultMateria();
		setDefaultCantidadEstudiantes();
	}
	
	public GrupoDTO(final String id, final ProfesorDTO profesor, final MateriaDTO materia, final int cantidadEstudiantes) {
		setId(id);
		setProfesor(profesor);
		setMateria(materia);
		setCantidadEstudiantes(cantidadEstudiantes);
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
	
	public ProfesorDTO getProfesor() {
		return profesor;
	}
	public void setProfesor(final ProfesorDTO profesor) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.*****
		this.profesor = ObjectHelper.getDefault(profesor, new ProfesorDTO());
	}
	private void setDefaultProfesor() {
		setProfesor(new ProfesorDTO());
	}
	
	public MateriaDTO getMateria() {
		return materia;
	}
	public void setMateria(final MateriaDTO materia) {
		//TODO: CUIDADO CON LA LIMPIEZA DE DATOS PARA EVITAR DATOS NULOS.******
		this.materia = ObjectHelper.getDefault(materia, new MateriaDTO());
	}
	private void setDefaultMateria() {
		//TODO: OBTENER VALOR POR DEFECTO???
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.??
		setMateria(new MateriaDTO());
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
