package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.CanceloEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = UsuarioEntityMapper.class)
public interface EstudianteEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(expression = "java(source.getAsistio())", target = "asistio"),
	})
	Estudiante toEstudiante(EstudianteEntity estudianteEntity, AsistenciaEntity asistenciaEntity);
	List<Estudiante> toEstudiantes(List<EstudianteEntity> estudiantesEntity, List<AsistenciaEntity> asistenciaEntities);
	
	@InheritInverseConfiguration
	EstudianteEntity toEstudianteEntity(Estudiante estudiante);
	List<EstudianteEntity> toEstudiantesEntity(List<Estudiante> estudiantes);
}
