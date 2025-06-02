package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.impl;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.ObtenerSesionesGrupoInteractor;
import co.edu.uco.utilidades_ms.application.usecase.ObtenerSesionesGrupoUsecase;
import co.edu.uco.utilidades_ms.dominio.sesion.ObtenerSesionesGrupoDomain;
import co.edu.uco.utilidades_ms.dominio.sesion.SesionGrupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObtenerSesionesGrupoInteractorImpl implements ObtenerSesionesGrupoInteractor {

    @Autowired
    private ObtenerSesionesGrupoUsecase usecase;

    @Override
    public List<SesionGrupo> obtener(ObtenerSesionesGrupoDomain domain) {
        return usecase.ejecutar(domain);
    }
}