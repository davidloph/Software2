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

    @Query(value ="""
        SELECT CANCELO FROM ESTUDIANTE_GRUPO WHERE ESTUDIANTE_ID = ? AND GRUPO_ID = (SELECT GRUPO_ID FROM SESION WHERE ID= ?)
""", nativeQuery = true)
    boolean existsBySesionAndEstudianteNoCancelo(@Param("idEstudiante") UUID idEstudiante, @Param("idSesion") UUID idSesion);
}
