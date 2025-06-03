package co.edu.uco.asistenciauco.application.outputport.repository;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.repository.criteria.AsistenciaCriteriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;

@Repository
public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, UUID>, AsistenciaCriteriaRepository {

    boolean existsBySesion_Id(UUID idSesion);


}