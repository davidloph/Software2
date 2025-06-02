package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, UUID>{

    @Query("""
    SELECT COUNT(s) > 0
    FROM SesionEntity s
    JOIN s.grupo g
    JOIN EstudianteGrupoEntity eg ON eg.grupo.id = g.id
    WHERE eg.estudiante.id = :idEstudiante AND s.id = :idSesion
""")
    boolean existsEstudianteInSesionGrupo(@Param("idEstudiante") UUID idEstudiante, @Param("idSesion") UUID idSesion);

    @Query("""
        SELECT u.correo
        FROM EstudianteEntity e
        JOIN e.usuario u
        WHERE e.id = :id
    """)
    String obtenerCorreoPorIdEstudiante(@Param("id") UUID id);

}
