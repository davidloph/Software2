package co.edu.uco.asistenciauco.application.usecase.sesion.validator;

import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.application.usecase.validator.Validator;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.MessageCatalogImpl;

import java.util.UUID;

public class ValidarSesionAsociadaAGrupoActivo implements Validator<UUID, ValidationResultVO> {

    private SesionRepository sesionRepository;
    private MessageCatalog messageCatalog;

    public ValidarSesionAsociadaAGrupoActivo(final SesionRepository sesionRepository,final MessageCatalog messageCatalog) {
        this.sesionRepository = sesionRepository;
        this.messageCatalog=messageCatalog;
    }

    @Override
    public ValidationResultVO validate(UUID data) {
        var resultadoValidacion = new ValidationResultVO();

        if(!sesionRepository.isGrupoActivoBySesionId(data)) {
            resultadoValidacion.agregarMensaje(messageCatalog.getMessage("validarsesionasociadaagrupoactiva") + data + ".");
        }

        return resultadoValidacion;
    }


}
