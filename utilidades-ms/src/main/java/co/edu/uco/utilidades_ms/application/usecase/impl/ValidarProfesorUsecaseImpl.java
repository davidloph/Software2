package co.edu.uco.utilidades_ms.application.usecase.impl;

import co.edu.uco.utilidades_ms.application.outputport.repository.ProfesorRepository;
import co.edu.uco.utilidades_ms.application.usecase.ValidarProfesorUsecase;
import co.edu.uco.utilidades_ms.dominio.profesor.ValidarProfesor;
import org.springframework.stereotype.Service;

@Service
public class ValidarProfesorUsecaseImpl implements ValidarProfesorUsecase {

    private final ProfesorRepository profesorRepository;

    public ValidarProfesorUsecaseImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public boolean ejecutar(ValidarProfesor validarProfesor) {
        return profesorRepository.existePorCorreo(validarProfesor.getEmail());
    }
}
