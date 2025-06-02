package co.edu.uco.asistenciauco.application.outputport.dto;



import co.edu.uco.crosscutting.helpers.NumericHelper;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;


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
	
	
	public GrupoDTO(final String id) {
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
		String defaultValue = UUIDHelper.getDefaultAsString();
		setId(defaultValue);
	}
	
	public ProfesorDTO getProfesor() {
		return profesor;
	}
	public void setProfesor(final ProfesorDTO profesor) {
		this.profesor = ObjectHelper.getDefault(profesor, new ProfesorDTO());
	}
	private void setDefaultProfesor() {
		setProfesor(new ProfesorDTO());
	}
	
	public MateriaDTO getMateria() {
		return materia;
	}
	public void setMateria(final MateriaDTO materia) {
		this.materia = ObjectHelper.getDefault(materia, new MateriaDTO());
	}
	private void setDefaultMateria() {
		setMateria(new MateriaDTO());
	}
	
	public Integer getCantidadEstudiantes() {
		return cantidadEstudiantes;
	}
	public void setCantidadEstudiantes(final Integer cantidadEstudiantes) {
		this.cantidadEstudiantes = ObjectHelper.getDefault(cantidadEstudiantes, NumericHelper.ZERO);
	}
	private void setDefaultCantidadEstudiantes() {
		Integer defaultValue = NumericHelper.ZERO;
		setCantidadEstudiantes(defaultValue);
	}
}
