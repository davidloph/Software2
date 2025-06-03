package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.GrupoEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.GrupoCriteriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity, UUID>, GrupoCriteriaRepository {

    boolean existsByProfesor_IdAndId(UUID idProfesor, UUID idGrupo);
}
