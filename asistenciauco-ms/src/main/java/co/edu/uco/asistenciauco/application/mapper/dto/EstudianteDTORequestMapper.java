package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.outputport.dto.EstudianteDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EstudianteDTORequestMapper {

	@Mappings({
		@Mapping(target = "id", expression = ""),
		@Mapping(source = "asistio", target = "asistio")
	})
    Estudiante toEstudiante(RegistrarAsistenciaRequestDTO.EstudianteDTORequest estudianteDTO);
	List<Estudiante> toEstudiantes(List<RegistrarAsistenciaRequestDTO.EstudianteDTORequest> estudiantesDTO);
	
	@InheritInverseConfiguration
	RegistrarAsistenciaRequestDTO.EstudianteDTORequest toEstudianteDTO(Estudiante estudiante);
	List<RegistrarAsistenciaRequestDTO.EstudianteDTORequest> toEstudiantesDTO(List<Estudiante> estudiantes);
}
