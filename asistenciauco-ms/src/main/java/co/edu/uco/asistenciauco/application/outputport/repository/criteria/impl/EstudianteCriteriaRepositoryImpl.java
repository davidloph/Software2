package co.edu.uco.asistenciauco.application.outputport.repository.criteria.impl;

import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.EstudianteCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.util.UUID;

public class EstudianteCriteriaRepositoryImpl implements EstudianteCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existsEstudianteInSesionGrupo(UUID idSesion, UUID idEstudiante) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<SesionEntity> sesion = query.from(co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity.class);

        // Subquery para obtener los grupos del estudiante
        Subquery<UUID> subquery = query.subquery(UUID.class);
        Root<co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity> eg = subquery.from(co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity.class);
        subquery.select(eg.get("grupo").get("id"))
                .where(cb.equal(eg.get("estudiante").get("id"), idEstudiante));

        // Consulta principal: verificar si hay una sesión con ese id y grupo en la subconsulta
        query.select(cb.count(sesion))
                .where(
                        cb.equal(sesion.get("id"), idSesion),
                        sesion.get("grupo").get("id").in(subquery)
                );

        Long count = entityManager.createQuery(query).getSingleResult();
        return count != null && count > 0;
    }

    @Override
    public String obtenerCorreoPorIdEstudiante(UUID idEstudiante) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery(String.class);

        Root<EstudianteEntity> estudiante = query.from(EstudianteEntity.class);
        Join<?, ?> usuario = estudiante.join("usuario"); // Asumiendo que el campo se llama 'usuario'

        query.select(usuario.get("correo").as(String.class))
                .where(cb.equal(estudiante.get("id"), idEstudiante));

        return entityManager.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();
    }
}
