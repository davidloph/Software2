package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.dto.AsistenciaDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;

@Mapper(componentModel = "spring")
public interface EstudianteDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion"),
		@Mapping(source = "numeroIdentificacion", target = "numeroIdentificacion"),
		@Mapping(source = "nombresCompletos", target = "nombresCompletos"),
	})
	Asistencia toAsistencia(AsistenciaDTO asistenciaDTO);
	List<Asistencia> toAsistencias(List<AsistenciaDTO> asistenciasDTO);
	
	@InheritInverseConfiguration
	AsistenciaDTO toAsistenciaDTO(Asistencia asistencia);
	List<AsistenciaDTO> toAsistenciasDTO(List<Asistencia> asistencias);
}
