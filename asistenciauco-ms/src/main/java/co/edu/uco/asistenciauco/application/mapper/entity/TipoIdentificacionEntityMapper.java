package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.TipoIdentificacionEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.TipoIdentificacion;

@Mapper(componentModel = "spring")
public interface TipoIdentificacionEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "clave", target = "clave"),
		@Mapping(source = "nombre", target = "nombre")
	})
	TipoIdentificacion toTipoIdentificacion(TipoIdentificacionEntity tipoIdentificacionEntity);
	List<TipoIdentificacion> toTipoIdentificacions(List<TipoIdentificacionEntity> tiposIdentificacionEntity);
	
	@InheritInverseConfiguration
	TipoIdentificacionEntity toTipoIdentificacionEntity(TipoIdentificacion tipoIdentificacion);
	List<TipoIdentificacionEntity> toTipoIdentificacionsEntity(List<TipoIdentificacion> tiposIdentificacion);
}
