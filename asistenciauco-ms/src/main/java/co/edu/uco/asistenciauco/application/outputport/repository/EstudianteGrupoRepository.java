package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudianteGrupoRepository extends JpaRepository<EstudianteGrupoEntity, UUID>{

    boolean existsByEstudiante_IdAndGrupo_Id(UUID idGrupo, UUID idEstudiante);

    @Query("""
    SELECT eg.cancelo
    FROM EstudianteGrupoEntity eg
    JOIN eg.grupo g
    JOIN SesionEntity s ON s.grupo.id = g.id
    WHERE eg.estudiante.id = :idEstudiante AND s.id = :idSesion
""")
    boolean existsBySesionAndEstudianteNoCancelo(@Param("idEstudiante") UUID idEstudiante, @Param("idSesion") UUID idSesion);
}
