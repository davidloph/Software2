package co.edu.uco.asistenciauco.application.outputport.repository.criteria.impl;

import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.SesionCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public class SesionCriteriaRepositoryImpl implements SesionCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existsByIdAndFechaBefore(UUID id, LocalDateTime fechaLimite) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<SesionEntity> root = query.from(SesionEntity.class);

        Predicate idPredicate = cb.equal(root.get("id"), id);
        Predicate fechaPredicate = cb.lessThanOrEqualTo(root.get("fechaHora"), fechaLimite);

        query.select(cb.count(root)).where(cb.and(idPredicate, fechaPredicate));

        Long count = entityManager.createQuery(query).getSingleResult();
        return count > 0;

    }

    @Override
    public boolean findProfesorIdBySesionId(UUID idSesion, UUID idProfesor) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<SesionEntity> sesion = query.from(SesionEntity.class);
        Join<Object, Object> grupo = sesion.join("grupo");

        query.select(cb.count(sesion))
                .where(cb.and(
                        cb.equal(sesion.get("id"), idSesion),
                        cb.equal(grupo.get("profesor").get("id"), idProfesor)
                ));

        return entityManager.createQuery(query).getSingleResult() > 0;

    }

    @Override
    public boolean isGrupoActivoBySesionId(UUID idSesion) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<SesionEntity> root = query.from(SesionEntity.class);

        Predicate idPredicate = cb.equal(root.get("id"), idSesion);
        Predicate activoPredicate = cb.isTrue(root.get("grupo").get("activo"));

        query.select(cb.count(root)).where(cb.and(idPredicate, activoPredicate));

        Long count = entityManager.createQuery(query).getSingleResult();
        return count>0;

    }

    @Override
    public LocalDateTime findFechaHoraBySesionId(UUID idSesion) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LocalDateTime> query = cb.createQuery(LocalDateTime.class);
        Root<SesionEntity> sesion = query.from(SesionEntity.class);

        query.select(sesion.get("fechaHora"))
                .where(cb.equal(sesion.get("id"), idSesion));

        return entityManager.createQuery(query).getSingleResult();
    }
}
