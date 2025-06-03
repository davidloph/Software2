package co.edu.uco.asistenciauco.application.outputport.repository.criteria.impl;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.AsistenciaCriteriaRepository;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AsistenciaCriteriaRepositoryImpl implements AsistenciaCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertarAsistencia(UUID idEstudiante, UUID idSesion, boolean asistio) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EstudianteGrupoEntity> query = cb.createQuery(EstudianteGrupoEntity.class);

        Root<EstudianteGrupoEntity> eg = query.from(EstudianteGrupoEntity.class);
        Join<?, ?> grupo = eg.join("grupo");
        Root<SesionEntity> sesion = query.from(SesionEntity.class);

        Predicate estudianteMatch = cb.equal(eg.get("estudiante").get("id"), idEstudiante);
        Predicate sesionMatch = cb.equal(sesion.get("id"), idSesion);
        Predicate grupoMatch = cb.equal(sesion.get("grupo").get("id"), grupo.get("id"));

        query.select(eg)
                .where(cb.and(estudianteMatch, sesionMatch, grupoMatch));

        EstudianteGrupoEntity estudianteGrupo = entityManager.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();

        // Obtener referencia directa a la sesión
        SesionEntity sesionRef = entityManager.getReference(SesionEntity.class, idSesion);

        // Crear y persistir la asistencia
        AsistenciaEntity asistencia = new AsistenciaEntity();
        asistencia.setId(UUIDHelper.generate());
        asistencia.setSesion(sesionRef);
        asistencia.setEstudianteGrupo(estudianteGrupo);
        asistencia.setAsistio(asistio);

        entityManager.persist(asistencia);
    }
}
