/*package co.edu.uco.asistenciauco.application.mapper.dto;

import co.edu.uco.asistenciauco.application.outputport.dto.AsistenciaDTO;
import co.edu.uco.asistenciauco.application.outputport.dto.EstudianteDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsuarioDTOMapper.class)
public interface AsistenciaDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(target = "asistio", expression = ("java()"))
	})
    Asistencia toAsistencia(AsistenciaDTO asistenciaDTO);
	List<Asistencia> toEstudiantes(List<EstudianteDTO> estudiantesDTO);
	
	@InheritInverseConfiguration
	EstudianteDTO toEstudianteDTO(Estudiante estudiante);
	List<EstudianteDTO> toEstudiantesDTO(List<Estudiante> estudiantes);
}
*/