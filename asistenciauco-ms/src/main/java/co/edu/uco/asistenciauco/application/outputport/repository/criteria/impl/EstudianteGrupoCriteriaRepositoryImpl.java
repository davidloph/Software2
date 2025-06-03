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
        CriteriaQuery<Boolean> query = cb.createQuery(Boolean.class);

        Root<EstudianteGrupoEntity> eg = query.from(EstudianteGrupoEntity.class);
        Join<?, ?> grupo = eg.join("grupo");
        Root<SesionEntity> sesion = query.from(SesionEntity.class);

        Predicate estudianteMatch = cb.equal(eg.get("estudiante").get("id"), idEstudiante);
        Predicate sesionMatch = cb.equal(sesion.get("id"), idSesion);
        Predicate grupoMatch = cb.equal(sesion.get("grupo").get("id"), grupo.get("id"));

        query.select(eg.get("cancelo").as(Boolean.class))
                .where(cb.and(estudianteMatch, sesionMatch, grupoMatch));

        Boolean cancelo = entityManager.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();

        return cancelo != null && cancelo;
    }
}
