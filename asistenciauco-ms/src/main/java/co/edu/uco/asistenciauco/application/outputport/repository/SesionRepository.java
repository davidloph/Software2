package co.edu.uco.asistenciauco.application.outputport.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;

@Repository
public interface SesionRepository extends JpaRepository<SesionEntity, UUID>{

    @Query("SELECT COUNT(s) > 0 FROM Sesion s WHERE s.id = :id AND s.fechaHora <= :fechaLimite")
    boolean existsByIdAndFechaBefore(@Param("id") UUID id, @Param("fechaLimite") String fechaLimite);
}
