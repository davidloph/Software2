package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.EstudianteGrupoCriteriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudianteGrupoRepository extends JpaRepository<EstudianteGrupoEntity, UUID>, EstudianteGrupoCriteriaRepository {

    boolean existsByEstudiante_IdAndGrupo_Id(UUID idGrupo, UUID idEstudiante);
}
