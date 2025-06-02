package co.edu.uco.utilidades_ms.application.usecase;

import co.edu.uco.utilidades_ms.dominio.estudiante.EstudianteGrupo;
import co.edu.uco.utilidades_ms.dominio.estudiante.ObtenerEstudiantesGrupoDomain;

import java.util.List;

public interface ObtenerEstudiantesGrupoUsecase {
    List<EstudianteGrupo> ejecutar(ObtenerEstudiantesGrupoDomain domain);
}