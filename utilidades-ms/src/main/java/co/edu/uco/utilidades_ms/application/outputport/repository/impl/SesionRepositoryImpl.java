package co.edu.uco.utilidades_ms.application.outputport.repository.impl;

import co.edu.uco.utilidades_ms.application.outputport.repository.SesionRepository;
import co.edu.uco.utilidades_ms.dominio.sesion.SesionGrupo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
public class SesionRepositoryImpl implements SesionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SesionGrupo> obtenerSesionesPorGrupo(String grupoId) {
        //TODO: Agregar constantes a Redis
        final int diasLimite = 3;

        String sql = """
    SELECT CAST(s.id AS TEXT), s.fecha_hora
    FROM sesion s
    WHERE s.grupo_id = CAST(:grupoId AS UUID)
    AND s.fecha_hora::date BETWEEN CURRENT_DATE - (:dias || ' days')::INTERVAL AND CURRENT_DATE
""";



        var query = entityManager.createNativeQuery(sql)
                .setParameter("grupoId", grupoId)
                .setParameter("dias", diasLimite);

        List<Object[]> resultados = query.getResultList();

        List<SesionGrupo> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            lista.add(new SesionGrupo(
                    (String) fila[0],
                    ((Timestamp) fila[1]).toLocalDateTime()
            ));
        }


        return lista;
    }

}
