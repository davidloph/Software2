package co.edu.uco.utilidades_ms.application.outputport.repository.impl;

import co.edu.uco.utilidades_ms.application.outputport.entity.ProfesorEntity;
import co.edu.uco.utilidades_ms.application.outputport.repository.ProfesorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existePorCorreo(String correo) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<ProfesorEntity> profesor = query.from(ProfesorEntity.class);
        Join<Object, Object> usuario = profesor.join("usuario");

        query.select(cb.count(profesor))
                .where(cb.equal(usuario.get("correo"), correo));

        Long count = entityManager.createQuery(query).getSingleResult();
        return count != null && count > 0;
    }
}