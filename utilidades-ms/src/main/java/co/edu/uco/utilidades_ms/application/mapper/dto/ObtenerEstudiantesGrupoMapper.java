package co.edu.uco.utilidades_ms.application.mapper.dto;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.dto.request.ObtenerEstudiantesGrupoRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.dto.response.EstudianteResponseDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.dto.response.ObtenerEstudiantesGrupoResponseDTO;
import co.edu.uco.utilidades_ms.dominio.estudiante.EstudianteGrupo;
import co.edu.uco.utilidades_ms.dominio.estudiante.ObtenerEstudiantesGrupoDomain;

import java.util.List;
import java.util.stream.Collectors;

public class ObtenerEstudiantesGrupoMapper {

    public static ObtenerEstudiantesGrupoDomain toDomain(ObtenerEstudiantesGrupoRequestDTO dto) {
        return new ObtenerEstudiantesGrupoDomain(dto.getGrupo());
    }

    public static EstudianteResponseDTO toDTO(EstudianteGrupo estudiante) {
        return new EstudianteResponseDTO(
                estudiante.getId(),
                estudiante.getTipoIdentificacion(),
                estudiante.getNumeroIdentificacion(),
                estudiante.getNombresCompletos()
        );
    }

    public static ObtenerEstudiantesGrupoResponseDTO toDTO(List<EstudianteGrupo> estudiantes) {
        List<EstudianteResponseDTO> lista = estudiantes.stream()
                .map(ObtenerEstudiantesGrupoMapper::toDTO)
                .collect(Collectors.toList());
        return new ObtenerEstudiantesGrupoResponseDTO(lista);
    }
}