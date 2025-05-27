package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.CanceloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CanceloRepository extends JpaRepository<CanceloEntity, UUID>{

    boolean existsByEstudianteGrupo_IdAndActivoTrue(UUID idEstudianteGrupo);

    @Query("SELECT eg.estudiante.id FROM CanceloEntity c JOIN c.estudianteGrupo eg " +
            "WHERE c.activo = false AND eg.grupo.id = :idGrupo")
    List<UUID> findIdEstudiantesCancelaronByGrupo(UUID idGrupo);
}
