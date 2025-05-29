package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity, UUID>{

    boolean existsByIdAndActivoTrue(UUID idGrupo);

    boolean existsByProfesor_IdAndId(UUID idProfesor, UUID idGrupo);

  /*  @Query("""
    SELECT COUNT(s) > 0
    FROM SesionEntity s
    WHERE s.id = :idSesion AND s.activo IS NOT FALSE
""")
    boolean existsWithGrupo(@Param("idSesion") UUID idSesion);*/
}
