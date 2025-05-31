package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;

@Repository
public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, UUID>{

    boolean existsBySesion_Id(UUID idSesion);

    boolean existsByIdAndAsistioFalse(UUID idEstudianteGrupo);
}
