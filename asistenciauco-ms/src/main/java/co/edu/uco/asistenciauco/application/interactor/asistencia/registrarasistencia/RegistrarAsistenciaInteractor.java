package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia;

import co.edu.uco.asistenciauco.application.interactor.InteractorConRetorno;
import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.response.RegistrarAsistenciaResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface RegistrarAsistenciaInteractor 
	extends InteractorConRetorno<RegistrarAsistenciaRequestDTO, RegistrarAsistenciaResponseDTO>{

}
