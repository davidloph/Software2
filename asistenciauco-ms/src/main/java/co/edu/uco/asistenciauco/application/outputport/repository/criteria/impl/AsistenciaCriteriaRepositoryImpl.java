package co.edu.uco.asistenciauco.application.outputport.repository.criteria.impl;

import co.edu.uco.asistenciauco.application.outputport.entity.AsistenciaEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteGrupoEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.SesionEntity;
import co.edu.uco.asistenciauco.application.outputport.repository.criteria.AsistenciaCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AsistenciaCriteriaRepositoryImpl implements AsistenciaCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertarAsistencia(UUID idEstudiante, UUID idSesion, boolean asistio) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EstudianteGrupoEntity> query = cb.createQuery(EstudianteGrupoEntity.class);
        Root<EstudianteGrupoEntity> root = query.from(EstudianteGrupoEntity.class);

        Predicate predicate = cb.equal(root.get("estudiante").get("id"), idEstudiante);
        query.select(root).where(predicate);

        EstudianteGrupoEntity estudianteGrupo = entityManager.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();

        SesionEntity sesion = entityManager.getReference(SesionEntity.class, idSesion);

        AsistenciaEntity asistencia = new AsistenciaEntity();
        asistencia.setId(UUID.randomUUID());
        asistencia.setSesion(sesion);
        asistencia.setEstudianteGrupo(estudianteGrupo);
        asistencia.setAsistio(asistio);

        entityManager.persist(asistencia);
    }
}
