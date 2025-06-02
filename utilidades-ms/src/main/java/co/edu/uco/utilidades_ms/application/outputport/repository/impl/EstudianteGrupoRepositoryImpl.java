package co.edu.uco.utilidades_ms.application.outputport.repository.impl;

import co.edu.uco.utilidades_ms.application.outputport.repository.EstudianteGrupoRepository;
import co.edu.uco.utilidades_ms.dominio.estudiante.EstudianteGrupo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstudianteGrupoRepositoryImpl implements EstudianteGrupoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EstudianteGrupo> obtenerEstudiantesPorGrupo(String grupoId) {
        String sql = """
        SELECT CAST(e.id AS TEXT), ti.nombre, u.numero_identificacion, u.nombres_completos
        FROM estudiante_grupo eg
        JOIN estudiante e ON eg.estudiante_id = e.id
        JOIN usuario u ON e.usuario_id = u.id
        JOIN tipo_identificacion ti ON u.tipo_identificacion_id = ti.id
        WHERE eg.grupo_id = CAST(:grupoId AS UUID)
    """;

        var query = entityManager.createNativeQuery(sql).setParameter("grupoId", grupoId);
        List<Object[]> resultados = query.getResultList();

        List<EstudianteGrupo> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            lista.add(new EstudianteGrupo(
                    (String) fila[0],
                    (String) fila[1],
                    (String) fila[2],
                    (String) fila[3]
            ));
        }

        return lista;
    }

}