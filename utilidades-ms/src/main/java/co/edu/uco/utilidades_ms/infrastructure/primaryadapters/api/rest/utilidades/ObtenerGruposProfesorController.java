package co.edu.uco.utilidades_ms.infrastructure.primaryadapters.api.rest.utilidades;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.ObtenerGruposProfesorInteractor;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.dto.request.ObtenerGruposProfesorRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.dto.response.ObtenerGruposProfesorResponseDTO;
import co.edu.uco.utilidades_ms.application.mapper.dto.ObtenerGruposProfesorMapper;
import co.edu.uco.utilidades_ms.dominio.grupo.ObtenerGruposProfesorDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/obtenerGrupos")
public class ObtenerGruposProfesorController {

    @Autowired
    private ObtenerGruposProfesorInteractor interactor;

    @PostMapping
    public ResponseEntity<ObtenerGruposProfesorResponseDTO> obtenerGrupos(@RequestBody ObtenerGruposProfesorRequestDTO request) {
        ObtenerGruposProfesorDomain domain = ObtenerGruposProfesorMapper.toDomain(request);
        var resultado = interactor.obtenerGrupos(domain);
        var respuesta = ObtenerGruposProfesorMapper.toDTO(resultado);
        return ResponseEntity.ok(respuesta);
    }
}