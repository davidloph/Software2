package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity, UUID>{

    boolean existsByProfesor_IdAndId(UUID idProfesor, UUID idGrupo);

    @Query(value = """
    SELECT EXISTS(
        SELECT 1
        FROM estudiante_grupo eg
        JOIN grupo g ON eg.grupo_id = g.id
        WHERE g.sesion_id = :idSesion
          AND eg.activo = true
    )
""", nativeQuery = true)
    boolean existsBySesionActiva(@Param("idSesion") UUID idSesion);
}
