package co.edu.uco.utilidades_ms.application.usecase.impl;

import co.edu.uco.utilidades_ms.application.outputport.repository.SesionRepository;
import co.edu.uco.utilidades_ms.application.usecase.ObtenerSesionesGrupoUsecase;
import co.edu.uco.utilidades_ms.dominio.sesion.ObtenerSesionesGrupoDomain;
import co.edu.uco.utilidades_ms.dominio.sesion.SesionGrupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerSesionesGrupoUsecaseImpl implements ObtenerSesionesGrupoUsecase {

    @Autowired
    private SesionRepository repository;

    @Override
    public List<SesionGrupo> ejecutar(ObtenerSesionesGrupoDomain domain) {
        return repository.obtenerSesionesPorGrupo(domain.getGrupoId());
    }
}