package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.outputport.dto.SesionDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Sesion;

@Mapper(componentModel = "spring")
public interface SesionDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "grupo", target = "grupo"),
		@Mapping(source = "fechaHora", target = "fechaHora"),
	})
	Sesion toSesion(SesionDTO sesionDTO);
	List<Sesion> toSesions(List<SesionDTO> sesionesDTO);
	
	@InheritInverseConfiguration
	SesionDTO toSesionDTO(Sesion sesion);
	List<SesionDTO> toSesionsDTO(List<Sesion> sesiones);
}
