package co.edu.uco.utilidades_ms.application.outputport.repository.impl;

import co.edu.uco.utilidades_ms.application.outputport.repository.GrupoRepository;
import co.edu.uco.utilidades_ms.dominio.grupo.Grupo;
import co.edu.uco.utilidades_ms.dominio.grupo.GrupoConProfesor;
import co.edu.uco.utilidades_ms.dominio.profesor.Profesor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GrupoRepositoryImpl implements GrupoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GrupoConProfesor> obtenerGruposYProfesorPorCorreo(String correo) {
        String sql = """
        SELECT CAST(g.id AS TEXT), m.nombre, g.cantidad_estudiantes, CAST(p.id AS TEXT)
        FROM grupo g
        JOIN profesor p ON g.profesor_id = p.id
        JOIN usuario u ON p.usuario_id = u.id
        JOIN materia m ON g.materia_id = m.id
        WHERE u.correo = :correo
    """;

        var query = entityManager.createNativeQuery(sql).setParameter("correo", correo);
        List<Object[]> resultados = query.getResultList();

        List<GrupoConProfesor> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            Grupo grupo = new Grupo((String) fila[0], (String) fila[1], (int) fila[2]);
            Profesor profesor = new Profesor((String) fila[3]);
            lista.add(new GrupoConProfesor(grupo, profesor));
        }

        return lista;
    }

}