package co.edu.uco.asistenciauco.application.usecase.implementacion.validarprofesor.impl;

import co.edu.uco.asistenciauco.application.outputport.repository.ProfesorRepository;
import co.edu.uco.asistenciauco.application.usecase.implementacion.validarprofesor.ValidarProfesorUseCase;
import co.edu.uco.asistenciauco.application.usecase.implementacion.validarprofesor.domain.profesor.ValidarProfesor;

public class ValidarProfesorUseCaseImpl implements ValidarProfesorUseCase {


    private final ProfesorRepository profesorRepository;

    public ValidarProfesorUseCaseImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }


    @Override
    public boolean ejecutar(ValidarProfesor validarProfesor) {
        return profesorRepository.existePorCorreo(validarProfesor.getEmail());
    }
}
