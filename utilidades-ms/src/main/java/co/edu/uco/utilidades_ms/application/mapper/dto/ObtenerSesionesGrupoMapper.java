package co.edu.uco.utilidades_ms.application.mapper.dto;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.request.ObtenerSesionesGrupoRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.response.ObtenerSesionesGrupoResponseDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.response.SesionResponseDTO;
import co.edu.uco.utilidades_ms.dominio.sesion.ObtenerSesionesGrupoDomain;
import co.edu.uco.utilidades_ms.dominio.sesion.SesionGrupo;

import java.util.List;
import java.util.stream.Collectors;

import java.time.format.DateTimeFormatter;

public class ObtenerSesionesGrupoMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static ObtenerSesionesGrupoDomain toDomain(ObtenerSesionesGrupoRequestDTO dto) {
        return new ObtenerSesionesGrupoDomain(dto.getGrupo());
    }

    public static SesionResponseDTO toDTO(SesionGrupo sesion) {
        String fechaFormateada = sesion.getFechaHora().format(FORMATTER);
        return new SesionResponseDTO(sesion.getId(), fechaFormateada);
    }

    public static ObtenerSesionesGrupoResponseDTO toDTO(List<SesionGrupo> sesiones) {
        List<SesionResponseDTO> lista = sesiones.stream()
                .map(ObtenerSesionesGrupoMapper::toDTO)
                .collect(Collectors.toList());
        return new ObtenerSesionesGrupoResponseDTO(lista);
    }
}
