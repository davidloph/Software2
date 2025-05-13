package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.TipoIdentificacionEntity;

@Repository
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacionEntity, UUID>{

}
