package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EstudianteGrupoRepository extends JpaRepository<EstudianteGrupoEntity, UUID>{

    boolean existsByEstudiante_IdAndGrupo_Id(UUID idGrupo, UUID idEstudiante);

    @Query("SELECT eg.estudiante.id FROM EstudianteGrupoEntity eg WHERE eg.grupo.id = :idGrupo")
    List<UUID> findEstudiante_IdByGrupo_Id(UUID idGrupo);

}
