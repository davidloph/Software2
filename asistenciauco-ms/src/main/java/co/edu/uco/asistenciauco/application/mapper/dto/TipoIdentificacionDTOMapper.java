package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.dto.TipoIdentificacionDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.TipoIdentificacion;

@Mapper(componentModel = "spring")
public interface TipoIdentificacionDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "clave", target = "clave"),
		@Mapping(source = "nombre", target = "nombre")
	})
	TipoIdentificacion toTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO);
	List<TipoIdentificacion> toTipoIdentificacions(List<TipoIdentificacionDTO> tiposIdentificacionDTO);
	
	@InheritInverseConfiguration
	TipoIdentificacionDTO toTipoIdentificacionDTO(TipoIdentificacion tipoIdentificacion);
	List<TipoIdentificacionDTO> toTipoIdentificacionsDTO(List<TipoIdentificacion> tiposIdentificacion);
}
