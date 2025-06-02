package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.impl;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.ObtenerEstudiantesGrupoInteractor;
import co.edu.uco.utilidades_ms.application.usecase.ObtenerEstudiantesGrupoUsecase;
import co.edu.uco.utilidades_ms.dominio.estudiante.EstudianteGrupo;
import co.edu.uco.utilidades_ms.dominio.estudiante.ObtenerEstudiantesGrupoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObtenerEstudiantesGrupoInteractorImpl implements ObtenerEstudiantesGrupoInteractor {

    @Autowired
    private ObtenerEstudiantesGrupoUsecase usecase;

    @Override
    public List<EstudianteGrupo> obtener(ObtenerEstudiantesGrupoDomain domain) {
        return usecase.ejecutar(domain);
    }
}
