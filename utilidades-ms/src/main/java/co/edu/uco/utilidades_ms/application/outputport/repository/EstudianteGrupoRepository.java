package co.edu.uco.utilidades_ms.application.outputport.repository;

import co.edu.uco.utilidades_ms.dominio.estudiante.EstudianteGrupo;

import java.util.List;

public interface EstudianteGrupoRepository {
    List<EstudianteGrupo> obtenerEstudiantesPorGrupo(String grupoId);
}