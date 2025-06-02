package co.edu.uco.utilidades_ms.application.mapper.dto;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.dto.request.ObtenerGruposProfesorRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.dto.response.GrupoResponseDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.dto.response.ObtenerGruposProfesorResponseDTO;
import co.edu.uco.utilidades_ms.dominio.grupo.Grupo;
import co.edu.uco.utilidades_ms.dominio.grupo.GrupoConProfesor;
import co.edu.uco.utilidades_ms.dominio.grupo.ObtenerGruposProfesorDomain;

import java.util.List;
import java.util.stream.Collectors;

public class ObtenerGruposProfesorMapper {

    public static ObtenerGruposProfesorDomain toDomain(ObtenerGruposProfesorRequestDTO dto) {
        return new ObtenerGruposProfesorDomain(dto.getEmail());
    }

    public static ObtenerGruposProfesorResponseDTO toDTO(List<GrupoConProfesor> gruposConProfesor) {
        List<GrupoResponseDTO> grupos = gruposConProfesor.stream()
                .map(gcp -> new GrupoResponseDTO(
                        gcp.getGrupo().getId(),
                        gcp.getGrupo().getNombreMateria(),
                        gcp.getGrupo().getCantidadEstudiantes()))
                .collect(Collectors.toList());

        String idProfesor = gruposConProfesor.isEmpty() ? null : gruposConProfesor.get(0).getProfesor().getId();
        return new ObtenerGruposProfesorResponseDTO(idProfesor, grupos);
    }

}