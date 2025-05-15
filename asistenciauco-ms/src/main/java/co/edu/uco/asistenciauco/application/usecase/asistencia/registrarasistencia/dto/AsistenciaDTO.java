package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class AsistenciaDTO extends DomainDTO{

	private SesionDTO sesion;
	private ProfesorDTO profesor;
	private List<EstudianteDTO> estudiantes;
	
	protected AsistenciaDTO() {
		super(UUIDHelper.getDefaultAsString());
		setSesion(SesionDTO.create());
		setProfesor(ProfesorDTO.create());
		setEstudiantes(new ArrayList<EstudianteDTO>());
	}
	
	public static final AsistenciaDTO create() {
		return new AsistenciaDTO();
	}

	public SesionDTO getSesion() {
		return sesion;
	}

	public AsistenciaDTO setSesion(SesionDTO sesion) {
		this.sesion = sesion;
		return this;
	}

	public ProfesorDTO getProfesor() {
		return profesor;
	}

	public AsistenciaDTO setProfesor(ProfesorDTO profesor) {
		this.profesor = profesor;
		return this;
	}

	public List<EstudianteDTO> getEstudiantes() {
		return estudiantes;
	}

	public AsistenciaDTO setEstudiantes(List<EstudianteDTO> estudiantes) {
		this.estudiantes = estudiantes;
		return this;
	}
	
	
}
