package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.CanceloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CanceloRepository extends JpaRepository<CanceloEntity, UUID>{

    boolean existsByEstudianteGrupoAndActivoTrue(UUID idEstudianteGrupo);
}
