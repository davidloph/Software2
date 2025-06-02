package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.impl;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.ObtenerGruposProfesorInteractor;
import co.edu.uco.utilidades_ms.application.usecase.ObtenerGruposProfesorUsecase;
import co.edu.uco.utilidades_ms.dominio.grupo.GrupoConProfesor;
import co.edu.uco.utilidades_ms.dominio.grupo.ObtenerGruposProfesorDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObtenerGruposProfesorInteractorImpl implements ObtenerGruposProfesorInteractor {

    @Autowired
    private ObtenerGruposProfesorUsecase usecase;

    @Override
    public List<GrupoConProfesor> obtenerGrupos(ObtenerGruposProfesorDomain domain) {
        return usecase.ejecutar(domain);
    }
}
