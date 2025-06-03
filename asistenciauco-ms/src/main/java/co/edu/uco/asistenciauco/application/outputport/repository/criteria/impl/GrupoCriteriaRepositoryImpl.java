package co.edu.uco.asistenciauco.application.outputport.repository.criteria.impl;

import co.edu.uco.asistenciauco.application.outputport.entity.GrupoEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.GrupoCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class GrupoCriteriaRepositoryImpl implements GrupoCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existsBySesionActiva(UUID idSesion) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boolean> query = cb.createQuery(Boolean.class);

        Root<SesionEntity> sesion = query.from(SesionEntity.class);
        Join<?, ?> grupo = sesion.join("grupo");

        query.select(grupo.get("activo").as(Boolean.class))
                .where(cb.equal(sesion.get("id"), idSesion));

        Boolean activo = entityManager.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();

        return Boolean.TRUE.equals(activo);
    }
}
