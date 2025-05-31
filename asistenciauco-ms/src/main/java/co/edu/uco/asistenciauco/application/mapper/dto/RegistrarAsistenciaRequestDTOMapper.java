package co.edu.uco.asistenciauco.application.mapper.dto;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = EstudianteDTOMapper.class)
public interface RegistrarAsistenciaRequestDTOMapper {

	@Mappings({
		@Mapping(source = "sesion", target = "sesion"),
		@Mapping(source = "profesor", target = "profesor"),
		@Mapping(source = "estudiantes", target = "estudiantes")
	})
    Asistencia toAsistenciaTest(RegistrarAsistenciaRequestDTO asistenciaRequestDTO);
	List<Asistencia> toAsistenciasTest(List<RegistrarAsistenciaRequestDTO> asistenciasRequestDTO);
	
	@InheritInverseConfiguration
	RegistrarAsistenciaRequestDTO toAsistenciaRequestDTO(Asistencia asistenciaTest);
	List<RegistrarAsistenciaRequestDTO> toAsistenciasRequestDTO(List<Asistencia> asistenciasTest);
}
