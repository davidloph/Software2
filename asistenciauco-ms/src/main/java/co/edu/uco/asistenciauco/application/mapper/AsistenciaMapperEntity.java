package co.edu.uco.asistenciauco.application.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.entity.AsistenciaEntity;

@Mapper(componentModel = "spring")
public interface AsistenciaMapperEntity {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "sesion", target = "sesion"),
		@Mapping(source = "profesor", target = "profesor"),
		@Mapping(source = "estudiantes", target = "estudiantes"),
	})
	Asistencia toAsistencia(AsistenciaEntity asistenciaEntity);
	
	@InheritInverseConfiguration
	AsistenciaEntity toAsistenciaEntity(Asistencia asistencia);
}
