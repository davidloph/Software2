package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.EstudianteGrupo;

@Mapper(componentModel = "spring", uses = {GrupoEntityMapper.class, EstudianteEntityMapper.class})
public interface EstudianteGrupoEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "grupo", target = "grupo"),
		@Mapping(source = "estudiante", target = "estudiante"),
		@Mapping(source = "cancelo", target = "cancelo")
	})
	EstudianteGrupo toEstudianteGrupo(EstudianteGrupoEntity estudianteGrupoEntity);
	List<EstudianteGrupo> toEstudianteGrupos(List<EstudianteGrupoEntity> estudianteGruposEntity);
	
	@InheritInverseConfiguration
	EstudianteGrupoEntity toEstudianteGrupoEntity(EstudianteGrupo estudianteGrupo);
	List<EstudianteGrupoEntity> toEstudianteGruposEntity(List<EstudianteGrupo> estudianteGrupos);
}
