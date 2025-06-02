package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto;

import co.edu.uco.utilidades_ms.dominio.sesion.ObtenerSesionesGrupoDomain;
import co.edu.uco.utilidades_ms.dominio.sesion.SesionGrupo;

import java.util.List;

public interface ObtenerSesionesGrupoInteractor {
    List<SesionGrupo> obtener(ObtenerSesionesGrupoDomain domain);
}