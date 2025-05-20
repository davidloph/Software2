package co.edu.uco.asistenciauco.application.mapper.entity;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.ProfesorEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Profesor;

@Mapper(componentModel = "spring")
public interface ProfesorEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion"),
		@Mapping(source = "numeroIdentificacion", target = "numeroIdentificacion"),
		@Mapping(source = "nombresCompletos", target = "nombresCompletos")
	})
	Profesor toProfesor(ProfesorEntity profesorEntity);
	List<Profesor> toProfesors(List<ProfesorEntity> profesoresEntity);
	
	@InheritInverseConfiguration
	ProfesorEntity toProfesorEntity(Profesor profesor);
	List<ProfesorEntity> toProfesorsEntity(List<Profesor> profesores);
}
