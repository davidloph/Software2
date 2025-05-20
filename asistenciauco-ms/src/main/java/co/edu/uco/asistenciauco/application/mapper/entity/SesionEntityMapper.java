package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Sesion;

@Mapper(componentModel = "spring")
public interface SesionEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "grupo", target = "grupo"),
		@Mapping(source = "fechaHora", target = "fechaHora"),
	})
	Sesion toSesion(SesionEntity sesionEntity);
	List<Sesion> toSesions(List<SesionEntity> sesionesEntity);
	
	@InheritInverseConfiguration
	SesionEntity toSesionEntity(Sesion sesion);
	List<SesionEntity> toSesionsEntity(List<Sesion> sesiones);
}
