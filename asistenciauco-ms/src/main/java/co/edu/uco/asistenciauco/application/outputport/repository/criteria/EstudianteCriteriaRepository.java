package co.edu.uco.asistenciauco.application.outputport.repository.criteria;

import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface EstudianteCriteriaRepository {

    boolean existsEstudianteInSesionGrupo(UUID idSesion, UUID idEstudiante);

    String obtenerCorreoPorIdEstudiante(UUID id);

}
