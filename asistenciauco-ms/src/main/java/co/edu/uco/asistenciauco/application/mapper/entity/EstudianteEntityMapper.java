package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;

@Mapper(componentModel = "spring")
public interface EstudianteEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion"),
		@Mapping(source = "numeroIdentificacion", target = "numeroIdentificacion"),
		@Mapping(source = "nombresCompletos", target = "nombresCompletos"),
	})
	Asistencia toAsistencia(AsistenciaEntity asistenciaEntity);
	List<Asistencia> toAsistencias(List<AsistenciaEntity> asistenciasEntity);
	
	@InheritInverseConfiguration
	AsistenciaEntity toAsistenciaEntity(Asistencia asistencia);
	List<AsistenciaEntity> toAsistenciasEntity(List<Asistencia> asistencias);
}
