package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.CanceloEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CanceloRepository extends JpaRepository<CanceloEntity, UUID>{

    boolean existsByEstudianteGrupo_IdAndActivoTrue(UUID idEstudianteGrupo);

    @Query("""
    SELECT COUNT(c) > 0
    FROM CanceloEntity c
    WHERE c.estudianteGrupo.estudiante.id = :idEstudiante
      AND c.estudianteGrupo.grupo.id = (
            SELECT s.grupo.id
            FROM SesionEntity s
            WHERE s.id = :idSesion
      )
      AND c.activo = false
""")
    boolean estudianteCanceloInactivo(@Param("idEstudiante") UUID idEstudiante, @Param("idSesion") UUID idSesion);
}
