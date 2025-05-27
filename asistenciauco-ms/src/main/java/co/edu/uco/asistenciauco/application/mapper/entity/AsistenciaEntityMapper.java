package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.AsistenciaDomainTest;

@Mapper(componentModel = "spring", uses = {SesionEntityMapper.class, ProfesorEntityMapper.class, EstudianteEntityMapper.class})
public interface AsistenciaEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "estudianteGrupo", target = "estudianteGrupo"),
		@Mapping(source = "sesion", target = "sesion"),
		@Mapping(source = "asistio", target = "asistio"),
	})
    AsistenciaDomainTest toAsistencia(AsistenciaEntity asistenciaEntity);
	List<AsistenciaDomainTest> toAsistencias(List<AsistenciaEntity> asistenciasEntity);
	
	@InheritInverseConfiguration
	AsistenciaEntity toAsistenciaEntity(AsistenciaDomainTest asistencia);
	List<AsistenciaEntity> toAsistenciasEntity(List<AsistenciaDomainTest> asistencias);
}
