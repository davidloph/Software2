package co.edu.uco.asistenciauco.application.outputport.repository.criteria.impl;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.EstudianteGrupoCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class EstudianteGrupoCriteriaRepositoryImpl implements EstudianteGrupoCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existsBySesionAndEstudianteNoCancelo(UUID idEstudiante, UUID idSesion) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);

        Root<EstudianteGrupoEntity> root = query.from(EstudianteGrupoEntity.class);
        Join<EstudianteGrupoEntity, ?> grupo = root.join("grupo");
        Subquery<UUID> subquerySesion = query.subquery(UUID.class);
        Root<SesionEntity> sesionRoot = subquerySesion.from(SesionEntity.class);

        subquerySesion.select(sesionRoot.get("grupo").get("id"))
                .where(cb.equal(sesionRoot.get("id"), idSesion));

        query.select(cb.count(root)).where(cb.and(
                cb.equal(root.get("estudiante").get("id"), idEstudiante),
                cb.equal(grupo.get("id"), subquerySesion),
                cb.isFalse(root.get("cancelo"))
        ));

        return entityManager.createQuery(query).getSingleResult() > 0;
    }
}
