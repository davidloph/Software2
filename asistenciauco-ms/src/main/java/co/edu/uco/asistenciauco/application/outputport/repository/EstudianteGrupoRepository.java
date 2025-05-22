package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudianteGrupoRepository extends JpaRepository<EstudianteGrupoEntity, UUID>{

    boolean existsByEstudianteAndGrupo(UUID grupo, UUID estudiante);
}
