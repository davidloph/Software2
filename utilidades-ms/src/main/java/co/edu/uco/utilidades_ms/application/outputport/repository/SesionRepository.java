package co.edu.uco.utilidades_ms.application.outputport.repository;

import co.edu.uco.utilidades_ms.dominio.sesion.SesionGrupo;

import java.util.List;

public interface SesionRepository {
    List<SesionGrupo> obtenerSesionesPorGrupo(String grupoId);
}
