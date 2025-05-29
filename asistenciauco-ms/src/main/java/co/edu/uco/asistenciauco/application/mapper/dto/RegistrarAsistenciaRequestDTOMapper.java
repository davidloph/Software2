package co.edu.uco.asistenciauco.application.mapper.dto;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.AsistenciaDomainTest;
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
    AsistenciaDomainTest toAsistenciaTest(RegistrarAsistenciaRequestDTO asistenciaRequestDTO);
	List<AsistenciaDomainTest> toAsistenciasTest(List<RegistrarAsistenciaRequestDTO> asistenciasRequestDTO);
	
	@InheritInverseConfiguration
	RegistrarAsistenciaRequestDTO toAsistenciaRequestDTO(AsistenciaDomainTest asistenciaTest);
	List<RegistrarAsistenciaRequestDTO> toAsistenciasRequestDTO(List<AsistenciaDomainTest> asistenciasTest);
}
