package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.repository.criteria.EstudianteCriteriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, UUID>, EstudianteCriteriaRepository {

}
