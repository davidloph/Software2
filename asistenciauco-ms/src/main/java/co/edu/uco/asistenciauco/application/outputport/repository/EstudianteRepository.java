package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, UUID>{

    @Query(value ="""
        SELECT EXISTS (SELECT 1 FROM SESION WHERE GRUPO_ID IN (SELECT GRUPO_ID FROM ESTUDIANTE_GRUPO WHERE ESTUDIANTE_ID = ?) AND ID = ?)
""", nativeQuery = true)
    boolean existsEstudianteInSesionGrupo(UUID idSesion, UUID idEstudiante);

    @Query("""
        SELECT u.correo
        FROM EstudianteEntity e
        JOIN e.usuario u
        WHERE e.id = :id
    """)
    String obtenerCorreoPorIdEstudiante(@Param("id") UUID id);

}
