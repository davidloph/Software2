package co.edu.uco.asistenciauco.application.outputport.repository.criteria;


import java.time.LocalDateTime;
import java.util.UUID;

public interface SesionCriteriaRepository {

    boolean existsByIdAndFechaBefore(UUID id,LocalDateTime fechaLimite);

    boolean findProfesorIdBySesionId(UUID idSesion,UUID idProfesor);

    boolean isGrupoActivoBySesionId(UUID idSesion);

    LocalDateTime findFechaHoraBySesionId(UUID idSesion);

}
