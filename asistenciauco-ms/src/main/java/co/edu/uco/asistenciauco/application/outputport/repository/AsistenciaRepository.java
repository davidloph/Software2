package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;

@Repository
public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, UUID> {

    boolean existsBySesion_Id(UUID idSesion);

    @Modifying
    @Query(value = """
        INSERT INTO asistencia (
            id,
            sesion_id,
            estudiante_grupo_id,
            asistio
        )
        SELECT
            gen_random_uuid(),
            :idSesion,
            eg.id,
            :asistio
        FROM estudiante_grupo eg
        JOIN grupo g ON eg.grupo_id = g.id
        JOIN sesion s ON s.grupo_id = g.id
        WHERE eg.estudiante_id = :idEstudiante
          AND s.id = :idSesion
        """, nativeQuery = true)
    void insertarAsistencia(
            @Param("idEstudiante") UUID idEstudiante,
            @Param("idSesion") UUID idSesion,
            @Param("asistio") boolean asistio
    );
}