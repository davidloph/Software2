package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Profesor;
import co.edu.uco.asistenciauco.application.outputport.dto.ProfesorDTO;

@Mapper(componentModel = "spring", uses = TipoIdentificacionDTOMapper.class)
public interface ProfesorDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion"),
		@Mapping(source = "numeroIdentificacion", target = "numeroIdentificacion"),
		@Mapping(source = "nombresCompletos", target = "nombresCompletos")
	})
	Profesor toProfesor(ProfesorDTO profesorDTO);
	List<Profesor> toProfesors(List<ProfesorDTO> profesorsDTO);
	
	@InheritInverseConfiguration
	ProfesorDTO toProfesorDTO(Profesor profesor);
	List<ProfesorDTO> toProfesorDTO(List<Profesor> profesorDTO);
}
