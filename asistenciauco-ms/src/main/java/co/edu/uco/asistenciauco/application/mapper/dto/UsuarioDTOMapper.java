package co.edu.uco.asistenciauco.application.mapper.dto;

import co.edu.uco.asistenciauco.application.outputport.dto.AsistenciaDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = TipoIdentificacionDTOMapper.class)
public interface UsuarioDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion"),
		@Mapping(source = "numeroIdentificacion", target = "numeroIdentificacion"),
		@Mapping(source = "nombresCompletos", target = "nombresCompletos"),
		@Mapping(source = "correo", target = "correo"),
	})
    Asistencia toAsistencia(AsistenciaDTO asistenciaDTO);
	List<Asistencia> toAsistencias(List<AsistenciaDTO> asistenciasDTO);
	
	@InheritInverseConfiguration
	AsistenciaDTO toAsistenciaDTO(Asistencia asistencia);
	List<AsistenciaDTO> toAsistenciasDTO(List<Asistencia> asistencias);
}
