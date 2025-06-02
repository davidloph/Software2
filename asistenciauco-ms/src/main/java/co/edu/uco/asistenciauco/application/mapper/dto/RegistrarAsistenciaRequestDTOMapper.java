package co.edu.uco.asistenciauco.application.mapper.dto;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Profesor;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Sesion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {Sesion.class, Profesor.class, UUID.class}, uses = EstudianteDTORequestMapper.class)
public interface RegistrarAsistenciaRequestDTOMapper {

	@Mapping(target = "sesion", expression = "java(new Sesion(asistenciaRequestDTO.getSesion()))")
	@Mapping(target = "profesor", expression = "java(new Profesor(asistenciaRequestDTO.getProfesor()))")
	@Mapping(source = "estudiantes", target = "estudiantes")
	Asistencia toAsistenciaTest(RegistrarAsistenciaRequestDTO asistenciaRequestDTO);

	List<Asistencia> toAsistenciasTest(List<RegistrarAsistenciaRequestDTO> asistenciasRequestDTO);
}
