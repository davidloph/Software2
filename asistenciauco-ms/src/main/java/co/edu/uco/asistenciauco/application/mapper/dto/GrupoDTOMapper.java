package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.dto.GrupoDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Grupo;

@Mapper(componentModel = "spring", uses = {ProfesorDTOMapper.class, MateriaDTOMapper.class})
public interface GrupoDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "profesor", target = "profesor"),
		@Mapping(source = "materia", target = "materia"),
		@Mapping(source = "cantidadEstudiantes", target = "cantidadEstudiantes")
	})
	Grupo toGrupo(GrupoDTO grupoDTO);
	List<Grupo> toGrupos(List<GrupoDTO> gruposDTO);
	
	@InheritInverseConfiguration
	GrupoDTO toGrupoDTO(Grupo grupo);
	List<GrupoDTO> toGruposDTO(List<Grupo> grupos);
}
