package co.edu.uco.utilidades_ms.application.outputport.repository;

import co.edu.uco.utilidades_ms.dominio.grupo.Grupo;
import co.edu.uco.utilidades_ms.dominio.grupo.GrupoConProfesor;

import java.util.List;

public interface GrupoRepository {
    List<GrupoConProfesor> obtenerGruposYProfesorPorCorreo(String correo);
}