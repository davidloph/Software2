package co.edu.uco.utilidades_ms.application.usecase.impl;

import co.edu.uco.utilidades_ms.application.outputport.repository.EstudianteGrupoRepository;
import co.edu.uco.utilidades_ms.application.usecase.ObtenerEstudiantesGrupoUsecase;
import co.edu.uco.utilidades_ms.dominio.estudiante.EstudianteGrupo;
import co.edu.uco.utilidades_ms.dominio.estudiante.ObtenerEstudiantesGrupoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerEstudiantesGrupoUsecaseImpl implements ObtenerEstudiantesGrupoUsecase {

    @Autowired
    private EstudianteGrupoRepository repository;

    @Override
    public List<EstudianteGrupo> ejecutar(ObtenerEstudiantesGrupoDomain domain) {
        return repository.obtenerEstudiantesPorGrupo(domain.getGrupoId());
    }
}