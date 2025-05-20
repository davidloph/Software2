package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.application.outputport.dto.AsistenciaDTO;

@Mapper(componentModel = "spring", uses = {SesionDTOMapper.class, ProfesorDTOMapper.class, EstudianteDTOMapper.class})
public interface AsistenciaDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "sesion", target = "sesion"),
		@Mapping(source = "profesor", target = "profesor"),
		@Mapping(source = "estudiantes", target = "estudiantes"),
	})
	Asistencia toAsistencia(AsistenciaDTO asistenciaDTO);
	List<Asistencia> toAsistencias(List<AsistenciaDTO> asistenciasDTO);
	
	@InheritInverseConfiguration
	AsistenciaDTO toAsistenciaDTO(Asistencia asistencia);
	List<AsistenciaDTO> toAsistenciasDTO(List<Asistencia> asistenciasDTO);
}
