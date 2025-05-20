package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Materia;
import co.edu.uco.asistenciauco.application.outputport.dto.AsistenciaDTO;
import co.edu.uco.asistenciauco.application.outputport.dto.MateriaDTO;

@Mapper(componentModel = "spring")
public interface MateriaDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "clave", target = "clave"),
		@Mapping(source = "nombre", target = "nombre")
	})
	Materia toMateria(MateriaDTO materiaDTO);
	List<Materia> toMaterias(List<MateriaDTO> materiasDTO);
	
	@InheritInverseConfiguration
	MateriaDTO toMateriaDTO(Materia materia);
	List<MateriaDTO> toMateriaDTO(List<Materia> materiaDTO);
}