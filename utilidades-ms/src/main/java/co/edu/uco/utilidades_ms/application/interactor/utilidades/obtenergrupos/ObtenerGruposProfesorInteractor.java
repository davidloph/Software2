package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos;

import co.edu.uco.utilidades_ms.dominio.grupo.Grupo;
import co.edu.uco.utilidades_ms.dominio.grupo.GrupoConProfesor;
import co.edu.uco.utilidades_ms.dominio.grupo.ObtenerGruposProfesorDomain;

import java.util.List;

public interface ObtenerGruposProfesorInteractor {
    List<GrupoConProfesor> obtenerGrupos(ObtenerGruposProfesorDomain domain);
}


