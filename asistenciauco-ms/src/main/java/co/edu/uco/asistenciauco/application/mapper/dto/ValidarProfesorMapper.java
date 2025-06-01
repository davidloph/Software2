package co.edu.uco.asistenciauco.application.mapper.dto;

import co.edu.uco.asistenciauco.application.interactor.profesor.validarprofesor.dto.request.ValidarProfesorRequestDTO;
import co.edu.uco.asistenciauco.application.usecase.implementacion.validarprofesor.domain.profesor.ValidarProfesor;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ValidarProfesorMapper {
    ValidarProfesor toDomainFromDto(ValidarProfesorRequestDTO dto);
}
