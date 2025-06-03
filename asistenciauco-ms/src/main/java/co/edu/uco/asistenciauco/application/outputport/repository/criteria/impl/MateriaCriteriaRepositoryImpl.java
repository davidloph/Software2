package co.edu.uco.asistenciauco.application.outputport.repository.criteria.impl;

import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.MateriaCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
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

        Root<SesionEntity> sesion = query.from(SesionEntity.class);
        Path<String> nombreMateria = sesion
                .get("grupo")        // Relación a GrupoEntity
                .get("materia")      // Relación a MateriaEntity
                .get("nombre");      // Atributo nombre

        query.select(nombreMateria)
                .where(cb.equal(sesion.get("id"), idSesion));

        return entityManager.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();
    }
}
