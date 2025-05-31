package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import co.edu.uco.asistenciauco.application.outputport.entity.GrupoEntity;
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
		@Mapping(expression = "java(source.getProfesor())", target = "profesor"),
	})
    AsistenciaDomainTest toAsistencia(AsistenciaEntity asistenciaEntity, GrupoEntity grupoEntity);
	List<AsistenciaDomainTest> toAsistencias(List<AsistenciaEntity> asistenciasEntity, List<GrupoEntity> grupoEntities);



	@Mapping(source = "id",target = "id")
	AsistenciaEntity toAsistenciaEntity(AsistenciaDomainTest asistencia);

	@Mapping(source = "sesion", target = "sesion")
	AsistenciaEntity toAsistenciasEntity(AsistenciaDomainTest asistencias);

}
