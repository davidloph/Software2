package co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.impl;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.ValidarProfesorInteractor;
import co.edu.uco.utilidades_ms.application.mapper.dto.ValidarProfesorMapper;
import co.edu.uco.utilidades_ms.application.usecase.ValidarProfesorUsecase;   // <- interfaz
import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.request.ValidarProfesorRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.response.ValidarProfesorResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ValidarProfesorInteractorImpl implements ValidarProfesorInteractor {

    private final ValidarProfesorUsecase useCase;
    private final ValidarProfesorMapper mapper;

    // Inyectamos la interfaz, no la clase concreta
    public ValidarProfesorInteractorImpl(ValidarProfesorUsecase useCase,
                                         ValidarProfesorMapper mapper) {
        this.useCase = useCase;
        this.mapper  = mapper;
    }

    @Override
    public ValidarProfesorResponseDTO ejecutar(ValidarProfesorRequestDTO dto) {
        boolean esProfesor = useCase.ejecutar(mapper.toDomainFromDto(dto));
        return new ValidarProfesorResponseDTO(esProfesor);
    }
}
