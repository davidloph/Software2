package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.entity.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity, UUID>{
    boolean existePorCorreo(String correo);
}
