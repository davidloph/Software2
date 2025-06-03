package co.edu.uco.asistenciauco.application.outputport.repository.criteria;

import java.util.UUID;

public interface AsistenciaCriteriaRepository {

    void insertarAsistencia(UUID idEstudiante, UUID idSesion, boolean asistio);


}
