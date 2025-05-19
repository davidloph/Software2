package co.edu.uco.asistenciauco.application.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.MateriaEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Materia;

@Mapper(componentModel = "spring")
public interface ProfesorMapperEntity {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion"),
		@Mapping(source = "numeroIdentificacion", target = "numeroIdentificacion"),
		@Mapping(source = "nombresCompletos", target = "nombresCompletos")
	})
	Materia toMateria(MateriaEntity MateriaEntity);
	List<Materia> toMaterias(List<MateriaEntity> MateriasEntity);
	
	@InheritInverseConfiguration
	MateriaEntity toMateriaEntity(Materia Materia);
	List<MateriaEntity> toMateriasEntity(List<Materia> Materias);
}
