package co.edu.uco.utilidades_ms.infrastructure.primaryadapters.api.rest.utilidades;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.ObtenerSesionesGrupoInteractor;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.request.ObtenerSesionesGrupoRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.response.ObtenerSesionesGrupoResponseDTO;
import co.edu.uco.utilidades_ms.application.mapper.dto.ObtenerSesionesGrupoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ObtenerSesionesGrupoController {

    @Autowired
    private ObtenerSesionesGrupoInteractor interactor;

    @PostMapping("/obtenerSesiones")
    public ObtenerSesionesGrupoResponseDTO obtener(@RequestBody ObtenerSesionesGrupoRequestDTO request) {
        var domain = ObtenerSesionesGrupoMapper.toDomain(request);
        var sesiones = interactor.obtener(domain);
        return ObtenerSesionesGrupoMapper.toDTO(sesiones);
    }
}