package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.GrupoEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Grupo;

@Mapper(componentModel = "spring")
public interface GrupoEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "profesor", target = "profesor"),
		@Mapping(source = "materia", target = "materia"),
		@Mapping(source = "cantidadEstudiantes", target = "cantidadEstudiantes")
	})
	Grupo toGrupo(GrupoEntity grupoEntity);
	List<Grupo> toGrupos(List<GrupoEntity> gruposEntity);
	
	@InheritInverseConfiguration
	GrupoEntity toGrupoEntity(Grupo grupo);
	List<GrupoEntity> toGruposEntity(List<Grupo> grupos);
}
