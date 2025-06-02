package co.edu.uco.utilidades_ms.infrastructure.primaryadapters.api.rest.utilidades;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.ObtenerEstudiantesGrupoInteractor;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.dto.request.ObtenerEstudiantesGrupoRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.dto.response.ObtenerEstudiantesGrupoResponseDTO;
import co.edu.uco.utilidades_ms.application.mapper.dto.ObtenerEstudiantesGrupoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ObtenerEstudiantesGrupoController {

    @Autowired
    private ObtenerEstudiantesGrupoInteractor interactor;

    @PostMapping("/obtenerEstudiantes")
    public ObtenerEstudiantesGrupoResponseDTO obtener(@RequestBody ObtenerEstudiantesGrupoRequestDTO request) {
        var domain = ObtenerEstudiantesGrupoMapper.toDomain(request);
        var estudiantes = interactor.obtener(domain);
        return ObtenerEstudiantesGrupoMapper.toDTO(estudiantes);
    }
}
