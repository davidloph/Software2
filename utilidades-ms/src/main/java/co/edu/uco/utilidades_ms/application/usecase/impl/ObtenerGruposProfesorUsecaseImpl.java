package co.edu.uco.utilidades_ms.application.usecase.impl;

import co.edu.uco.utilidades_ms.application.outputport.repository.GrupoRepository;
import co.edu.uco.utilidades_ms.application.usecase.ObtenerGruposProfesorUsecase;
import co.edu.uco.utilidades_ms.dominio.grupo.Grupo;
import co.edu.uco.utilidades_ms.dominio.grupo.GrupoConProfesor;
import co.edu.uco.utilidades_ms.dominio.grupo.ObtenerGruposProfesorDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerGruposProfesorUsecaseImpl implements ObtenerGruposProfesorUsecase {

    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public List<GrupoConProfesor> ejecutar(ObtenerGruposProfesorDomain domain) {
        return grupoRepository.obtenerGruposYProfesorPorCorreo(domain.getEmail());
    }
}
