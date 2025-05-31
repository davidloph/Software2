package co.edu.uco.asistenciauco.application.mapper.dto;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.response.RegistrarAsistenciaResponseDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.RegistrarAsistenciaResponseVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistrarAsistenciaResponseDTOMapper {

	@Mappings({
		@Mapping(source = "mensajes", target = "mensajes"),
		@Mapping(target = "transaccionExitosa", expression = "java(source.isValidacionCorrecta())")
	})
	RegistrarAsistenciaResponseDTO toAsistenciaTest(RegistrarAsistenciaResponseVO asistenciaRequestDTO);
	List<RegistrarAsistenciaResponseDTO> toAsistenciasTest(List<RegistrarAsistenciaResponseVO> asistenciasRequestDTO);
	
	@InheritInverseConfiguration
	RegistrarAsistenciaResponseVO toAsistenciaRequestDTO(RegistrarAsistenciaResponseDTO asistenciaTest);
	List<RegistrarAsistenciaResponseVO> toAsistenciasRequestDTO(List<RegistrarAsistenciaResponseDTO> asistenciasTest);
}
