package co.edu.uco.asistenciauco.application.outputport.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;

@Repository
public interface SesionRepository extends JpaRepository<SesionEntity, UUID>{

    @Query("SELECT COUNT(s) > 0 FROM SesionEntity s WHERE s.id = :id AND s.fechaHora <= :fechaLimite")
    boolean existsByIdAndFechaBefore(@Param("id") UUID id, @Param("fechaLimite") LocalDateTime fechaLimite);

    @Query(value = """
            SELECT
                EXISTS (
                    SELECT 1
                    FROM Sesion s
                    JOIN Grupo g ON s.grupo_id = g.id
                    WHERE s.id = ?
                      AND g.profesor_id = ?
                ) AS profesor_asociado;
""", nativeQuery = true)
    boolean findProfesorIdBySesionId(@Param("idSesion") UUID idSesion, @Param("idProfesor") UUID idProfesor);

    @Query("""
        SELECT COUNT(s) > 0
        FROM SesionEntity s
        WHERE s.id = :idSesion
          AND s.grupo.activo = true
    """)
    boolean isGrupoActivoBySesionId(@Param("idSesion") UUID idSesion);
}
