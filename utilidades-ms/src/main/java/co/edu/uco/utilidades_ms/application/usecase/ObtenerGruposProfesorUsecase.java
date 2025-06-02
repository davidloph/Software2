package co.edu.uco.utilidades_ms.application.usecase;

import co.edu.uco.utilidades_ms.dominio.grupo.Grupo;
import co.edu.uco.utilidades_ms.dominio.grupo.GrupoConProfesor;
import co.edu.uco.utilidades_ms.dominio.grupo.ObtenerGruposProfesorDomain;

import java.util.List;

public interface ObtenerGruposProfesorUsecase {
    List<GrupoConProfesor> ejecutar(ObtenerGruposProfesorDomain domain);
}
