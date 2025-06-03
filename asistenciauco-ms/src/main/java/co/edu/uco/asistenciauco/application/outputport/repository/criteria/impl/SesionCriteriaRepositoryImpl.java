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

        Root<SesionEntity> sesion = query.from(SesionEntity.class);

        Predicate porId = cb.equal(sesion.get("id"), id);
        Predicate antesDeFecha = cb.lessThanOrEqualTo(sesion.get("fechaHora"), fechaLimite);

        query.select(cb.count(sesion))
                .where(cb.and(porId, antesDeFecha));

        Long count = entityManager.createQuery(query)
                .getSingleResult();

        return count != null && count > 0;
    }

    @Override
    public boolean findProfesorIdBySesionId(UUID idSesion, UUID idProfesor) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);

        Root<SesionEntity> sesion = query.from(SesionEntity.class);
        Join<?, ?> grupo = sesion.join("grupo");

        Predicate sesionMatch = cb.equal(sesion.get("id"), idSesion);
        Predicate profesorMatch = cb.equal(grupo.get("profesor").get("id"), idProfesor);

        query.select(cb.count(sesion))
                .where(cb.and(sesionMatch, profesorMatch));

        Long count = entityManager.createQuery(query).getSingleResult();
        return count != null && count > 0;
    }

    @Override
    public boolean isGrupoActivoBySesionId(UUID idSesion) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);

        Root<SesionEntity> sesion = query.from(SesionEntity.class);

        Predicate sesionIdMatch = cb.equal(sesion.get("id"), idSesion);
        Predicate grupoActivo = cb.isTrue(sesion.get("grupo").get("activo"));

        query.select(cb.count(sesion))
                .where(cb.and(sesionIdMatch, grupoActivo));

        Long count = entityManager.createQuery(query).getSingleResult();
        return count != null && count > 0;
    }


    @Override
    public LocalDateTime findFechaHoraBySesionId(UUID idSesion) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LocalDateTime> query = cb.createQuery(LocalDateTime.class);

        Root<SesionEntity> sesion = query.from(SesionEntity.class);

        query.select(sesion.get("fechaHora"))
                .where(cb.equal(sesion.get("id"), idSesion));

        return entityManager.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();
    }

}
