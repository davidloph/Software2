package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;

@Repository
public interface ProfesorRepository extends JpaRepository<EstudianteEntity, UUID>{

}
