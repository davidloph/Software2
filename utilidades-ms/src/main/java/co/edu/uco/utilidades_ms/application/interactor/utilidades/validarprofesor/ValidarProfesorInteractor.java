package co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.request.ValidarProfesorRequestDTO;
import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.response.ValidarProfesorResponseDTO;

public interface ValidarProfesorInteractor {

    ValidarProfesorResponseDTO ejecutar(ValidarProfesorRequestDTO dto);

}
