package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes;

import co.edu.uco.utilidades_ms.dominio.estudiante.EstudianteGrupo;
import co.edu.uco.utilidades_ms.dominio.estudiante.ObtenerEstudiantesGrupoDomain;

import java.util.List;

public interface ObtenerEstudiantesGrupoInteractor {
    List<EstudianteGrupo> obtener(ObtenerEstudiantesGrupoDomain domain);
}