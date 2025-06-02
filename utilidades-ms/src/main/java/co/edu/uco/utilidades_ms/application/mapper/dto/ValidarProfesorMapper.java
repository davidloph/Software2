package co.edu.uco.utilidades_ms.application.mapper.dto;

import co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.request.ValidarProfesorRequestDTO;
import co.edu.uco.utilidades_ms.dominio.profesor.ValidarProfesor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;

@Mapper(componentModel = "spring")
public interface ValidarProfesorMapper {

    // ← le decimos a MapStruct que NO intente setear 'email'
    @Mapping(target = "email", ignore = true)
    ValidarProfesor toDomainFromDto(ValidarProfesorRequestDTO dto);

    /** Crea la instancia inmutable usando tu factory estático */
    @ObjectFactory
    default ValidarProfesor newInstance(ValidarProfesorRequestDTO dto) {
        return ValidarProfesor.of(dto.getEmail());
    }
}
