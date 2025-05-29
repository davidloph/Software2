package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.CanceloEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
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

    @Query("""
    SELECT eg.estudiante
    FROM CanceloEntity c
    JOIN c.estudianteGrupo eg
    JOIN eg.grupo g
    JOIN SesionEntity s ON s.grupo.id = g.id
    WHERE c.activo = true AND s.id = :idSesion
""")
    List<Estudiante> findIdEstudiantesNoCancelaronBySesion(UUID idSesion);
}
