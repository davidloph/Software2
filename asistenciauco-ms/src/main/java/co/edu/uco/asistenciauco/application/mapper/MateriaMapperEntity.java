package co.edu.uco.asistenciauco.application.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.entity.MateriaEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Materia;

@Mapper(componentModel = "spring")
public interface MateriaMapperEntity {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "clave", target = "clave"),
		@Mapping(source = "nombre", target = "nombre")
	})
	Materia toMateria(MateriaEntity materiaEntity);
	List<Materia> toMaterias(List<MateriaEntity> materiasEntity);
	
	@InheritInverseConfiguration
	MateriaEntity toMateriaEntity(Materia materia);
	List<MateriaEntity> toMateriasEntity(List<Materia> materias);
}
