package co.edu.uco.asistenciauco.application.mapper.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EstudianteDTORequestMapper {


	public List<Estudiante> toEstudiantes(List<RegistrarAsistenciaRequestDTO.EstudianteDTORequest> estudiantesDTO) {
		if (estudiantesDTO == null) {
			return new ArrayList<>();
		}
		return estudiantesDTO.stream()
				.map(this::mapEstudiante)
				.toList();
	}

	private Estudiante mapEstudiante(RegistrarAsistenciaRequestDTO.EstudianteDTORequest dto) {
		if (dto == null) {
			return new Estudiante();
		}
		return new Estudiante(dto.getId(), dto.isAsistio());
	}
}