package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;

import java.util.UUID;

public class ValidarSesionAsociadaAGrupoActivo implements Validator<UUID, ValidationResultVO> {

    private SesionRepository sesionRepository;

    public ValidarSesionAsociadaAGrupoActivo(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    @Override
    public ValidationResultVO validate(UUID data) {
        var resultadoValidacion = new ValidationResultVO();

        if(!sesionRepository.isGrupoActivoBySesionId(data)) {
            //TODO: El mensaje debería estar en el catálogo de mensajes.
            resultadoValidacion.agregarMensaje("No existe una sesión con grupo activo con el identificador " + data + ".");
        }

        return resultadoValidacion;
    }


}
