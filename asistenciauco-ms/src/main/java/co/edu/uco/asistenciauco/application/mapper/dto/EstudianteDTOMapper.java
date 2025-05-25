package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import co.edu.uco.asistenciauco.application.outputport.dto.EstudianteDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.AsistenciaDomainTest;

@Mapper(componentModel = "spring", uses = UsuarioDTOMapper.class)
public interface EstudianteDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "usuario", target = "usuario")
	})
    AsistenciaDomainTest toEstudiante(EstudianteDTO estudianteDTO);
	List<AsistenciaDomainTest> toEstudiantes(List<EstudianteDTO> estudiantesDTO);
	
	@InheritInverseConfiguration
	EstudianteDTO toEstudianteDTO(Estudiante estudiante);
	List<EstudianteDTO> toEstudiantesDTO(List<Estudiante> estudiantes);
}
