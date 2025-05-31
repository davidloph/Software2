package co.edu.uco.asistenciauco.application.usecase.asistencia.validator;


import co.edu.uco.asistenciauco.application.outputport.notificationservice.SendGridService;
import co.edu.uco.asistenciauco.application.outputport.repository.AsistenciaRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
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
            SendGridService emailService = new SendGridService();
            emailService.sendEmail("juanest006@gmail.com", "Registro de inasistencia", "Hola , se ha registrado una asistencia");

        }
        return resultadoValidacion;
    }
}
