package co.edu.uco.asistenciauco.application.outputport.repository.criteria;


import java.util.UUID;

public interface GrupoCriteriaRepository {

    boolean existsBySesionActiva(UUID idSesion);

}
