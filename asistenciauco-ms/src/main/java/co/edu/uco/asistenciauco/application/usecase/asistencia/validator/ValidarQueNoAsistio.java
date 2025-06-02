package co.edu.uco.asistenciauco.application.usecase.asistencia.validator;


import co.edu.uco.asistenciauco.application.outputport.notificationservice.SendGridService;
import co.edu.uco.asistenciauco.application.outputport.repository.AsistenciaRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.infrastructure.secondaryadaptersJ.info.EmailMessage;
import co.edu.uco.asistenciauco.infrastructure.secondaryadaptersJ.notificationservice.SendGridServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidarQueNoAsistio implements Validator<UUID, ValidationResultVO> {

    private AsistenciaRepository asistenciaRepository;

    public ValidarQueNoAsistio(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }

    @Override
    public ValidationResultVO validate(UUID idEstudianteGrupo) {

        var resultadoValidacion = new ValidationResultVO();
        if(asistenciaRepository.existsByIdAndAsistioFalse(idEstudianteGrupo)){
            resultadoValidacion.agregarMensaje("El estudiante con id: " + idEstudianteGrupo);
            EmailMessage message = EmailMessage.create(
                    "correo del que falto",
                    "inasistencia registrada",
                    "mensaje"
            );

            SendGridServiceImpl service = new SendGridServiceImpl();
            service.send(message);

        }
        return resultadoValidacion;
    }
}
