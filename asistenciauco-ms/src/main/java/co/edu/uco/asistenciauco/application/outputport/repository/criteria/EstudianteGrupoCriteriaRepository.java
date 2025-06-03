package co.edu.uco.asistenciauco.application.outputport.repository.criteria;


import java.util.UUID;

public interface EstudianteGrupoCriteriaRepository {

    boolean existsBySesionAndEstudianteNoCancelo(UUID idEstudiante,UUID idSesion);

}
