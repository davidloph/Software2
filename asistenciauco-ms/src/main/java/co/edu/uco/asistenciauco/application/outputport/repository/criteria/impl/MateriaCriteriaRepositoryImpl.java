package co.edu.uco.asistenciauco.application.outputport.repository.criteria.impl;

import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.MateriaCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MateriaCriteriaRepositoryImpl implements MateriaCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String findNombreMateriaBySesionId(UUID idSesion) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery(String.class);

        Root<SesionEntity> sesionRoot = query.from(SesionEntity.class);
        Join<?, ?> grupo = sesionRoot.join("grupo");
        Join<?, ?> materia = grupo.join("materia");

        query.select(materia.get("nombre").as(String.class))
                .where(cb.equal(sesionRoot.get("id"), idSesion));

        return entityManager.createQuery(query).getSingleResult();
    }
}
