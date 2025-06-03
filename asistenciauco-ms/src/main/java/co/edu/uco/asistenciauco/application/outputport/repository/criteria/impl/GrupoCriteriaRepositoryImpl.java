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
        CriteriaBuilder cb= entityManager.getCriteriaBuilder();
        CriteriaQuery<Boolean> query = cb.createQuery(Boolean.class);

        Root<SesionEntity> sesionRoot = query.from(SesionEntity.class);
        Join<SesionEntity, GrupoEntity> grupoJoin = sesionRoot.join("grupo");

        query.select(grupoJoin.get("activo"))
                .where(cb.equal(sesionRoot.get("id"), idSesion));
        Boolean resultado = entityManager.createQuery(query)
                .setMaxResults(1) // Por si acaso
                .getSingleResult();

        return Boolean.TRUE.equals(resultado);
    }
}
