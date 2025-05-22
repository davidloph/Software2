package co.edu.uco.asistenciauco.application.mapper.dto;

import co.edu.uco.asistenciauco.application.outputport.dto.CanceloDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Cancelo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = EstudianteGrupoDTOMapper.class)
public interface CanceloDTOMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "estudianteGrupo", target = "estudianteGrupo"),
		@Mapping(source = "fecha", target = "fecha"),
		@Mapping(source = "motivo", target = "motivo"),
		@Mapping(source = "activo", target = "activo")
	})
	Cancelo toCancelo(CanceloDTO cancelo);
	List<Cancelo> toCancelos(List<CanceloDTO> cancelos);
	
	@InheritInverseConfiguration
	CanceloDTO toCanceloDTO(Cancelo cancelo);
	List<CanceloDTO> toCanceloDTOs(List<Cancelo> cancelos);
}
