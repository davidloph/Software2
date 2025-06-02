package co.edu.uco.utilidades_ms.application.usecase;

import co.edu.uco.utilidades_ms.dominio.sesion.ObtenerSesionesGrupoDomain;
import co.edu.uco.utilidades_ms.dominio.sesion.SesionGrupo;

import java.util.List;

public interface ObtenerSesionesGrupoUsecase {
    List<SesionGrupo> ejecutar(ObtenerSesionesGrupoDomain domain);
}