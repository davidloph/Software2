package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.dto.EstudianteGrupoDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.EstudianteGrupo;

@Mapper(componentModel = "spring", uses = {GrupoDTOMapper.class, EstudianteDTOMapper.class, CanceloDTOMapper.class})
public interface EstudianteGrupoDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "grupo", target = "grupo"),
		@Mapping(source = "estudiante", target = "estudiante"),
		@Mapping(source = "cancelo", target = "cancelo")
	})
	EstudianteGrupo toEstudianteGrupo(EstudianteGrupoDTO estudianteGrupoDTO);
	List<EstudianteGrupo> toEstudianteGrupos(List<EstudianteGrupoDTO> estudianteGruposDTO);
	
	@InheritInverseConfiguration
	EstudianteGrupoDTO toEstudianteGrupoDTO(EstudianteGrupo estudianteGrupo);
	List<EstudianteGrupoDTO> toEstudianteGruposDTO(List<EstudianteGrupo> estudianteGrupos);
}
