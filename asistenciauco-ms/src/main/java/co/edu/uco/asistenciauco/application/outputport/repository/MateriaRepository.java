package co.edu.uco.asistenciauco.application.outputport.repository;

import co.edu.uco.asistenciauco.application.outputport.entity.MateriaEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.MateriaCriteriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, UUID>, MateriaCriteriaRepository {

}
