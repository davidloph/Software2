package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;

@Mapper(componentModel = "spring", uses = TipoIdentificacionEntityMapper.class)
public interface EstudianteEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion"),
		@Mapping(source = "numeroIdentificacion", target = "numeroIdentificacion"),
		@Mapping(source = "nombresCompletos", target = "nombresCompletos"),
	})
	Estudiante toEstudiante(EstudianteEntity asistenciaEntity);
	List<Estudiante> toEstudiantes(List<EstudianteEntity> estudiantesEntity);
	
	@InheritInverseConfiguration
	EstudianteEntity toEstudianteEntity(Estudiante estudiante);
	List<EstudianteEntity> toEstudiantesEntity(List<Estudiante> estudiantes);
}
