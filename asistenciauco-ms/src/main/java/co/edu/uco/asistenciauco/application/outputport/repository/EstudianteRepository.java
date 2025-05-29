package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, UUID>{

    @Query("""
    SELECT COUNT(eg) > 0
    FROM EstudianteGrupoEntity eg
    JOIN SesionEntity s ON s.grupo.id = eg.grupo.id
    WHERE s.id = :idSesion AND eg.estudiante.id = :idEstudiante
""")
    boolean existsEstudianteInSesionGrupo(@Param("idSesion") UUID idSesion, @Param("idEstudiante") UUID idEstudiante);
}
