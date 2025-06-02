package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EstudianteDTORequestMapper {

	// Método principal que usará la implementación manual
	public abstract Estudiante toEstudiante(RegistrarAsistenciaRequestDTO.EstudianteDTORequest estudianteDTO);

	public List<Estudiante> toEstudiantes(List<RegistrarAsistenciaRequestDTO.EstudianteDTORequest> estudiantesDTO) {
		if (estudiantesDTO == null) {
			return null;
		}
		return estudiantesDTO.stream()
				.map(this::mapEstudiante)
				.collect(Collectors.toList());
	}

	private Estudiante mapEstudiante(RegistrarAsistenciaRequestDTO.EstudianteDTORequest dto) {
		if (dto == null) {
			return null;
		}
		return new Estudiante(dto.getId(), dto.isAsistio());
	}
}