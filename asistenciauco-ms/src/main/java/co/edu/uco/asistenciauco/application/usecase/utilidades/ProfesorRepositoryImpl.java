package co.edu.uco.asistenciauco.application.usecase.utilidades;

import co.edu.uco.asistenciauco.application.outputport.entity.ProfesorEntity;
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
