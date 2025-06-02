package co.edu.uco.utilidades_ms.infrastructure.primaryadapters.api.rest.utilidades;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.ValidarProfesorInteractor;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.request.ValidarProfesorRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.response.ValidarProfesorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ValidarProfesorController {

    private final ValidarProfesorInteractor interactor;

    public ValidarProfesorController(ValidarProfesorInteractor interactor) {
        this.interactor = interactor;
    }

    @PostMapping("/validarProfesor")
    public ResponseEntity<Void> validarProfesor(@RequestBody ValidarProfesorRequestDTO dto) {
        ValidarProfesorResponseDTO response = interactor.ejecutar(dto);
        return response.isEsProfesor()
                ? ResponseEntity.ok().build()
                : ResponseEntity.status(403).build();
    }
}
