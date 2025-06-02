package co.edu.uco.asistenciauco.application.mapper.entity;

import co.edu.uco.asistenciauco.application.outputport.entity.*;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AsistenciaMapper {

    /* DOMAIN → ENTITY */

    default AsistenciaEntity toEntity(Sesion sesion, Estudiante estudiante, boolean asistio, UUID asistenciaId) {
        AsistenciaEntity entity = new AsistenciaEntity();
        entity.setId(asistenciaId);
        entity.setSesion(toSesionEntity(sesion));
        entity.setEstudianteGrupo(toEstudianteGrupoEntity(estudiante));
        entity.setAsistio(asistio);
        return entity;
    }

    /* ENTITY → DOMAIN */

    default Asistencia toDomain(AsistenciaEntity entity) {
        return new Asistencia(
                entity.getId(),
                toSesionDomain(entity.getSesion()),
                toProfesorDomain(entity.getEstudianteGrupo().getGrupo().getProfesor()),
                List.of(toEstudianteDomain(entity))
        );
    }

    /* Estudiante */

    @Named("toEstudianteGrupoEntity")
    default EstudianteGrupoEntity toEstudianteGrupoEntity(Estudiante estudiante) {
        EstudianteEntity estudianteEntity = new EstudianteEntity(estudiante.getId());
        EstudianteGrupoEntity eg = new EstudianteGrupoEntity();
        eg.setEstudiante(estudianteEntity);
        return eg;
    }

    default Estudiante toEstudianteDomain(AsistenciaEntity entity) {
        UUID estudianteId = entity.getEstudianteGrupo().getEstudiante().getId();
        boolean asistio = entity.getAsistio();
        return new Estudiante(estudianteId, asistio);
    }

    /* Sesion */

    @Named("toSesionEntity")
    default SesionEntity toSesionEntity(Sesion sesion) {
        return new SesionEntity(sesion.getId());
    }

    @Named("toSesionDomain")
    default Sesion toSesionDomain(SesionEntity entity) {
        return new Sesion(entity.getId());
    }

    /* Profesor */

    @Named("toProfesorDomain")
    default Profesor toProfesorDomain(ProfesorEntity entity) {
        return new Profesor(entity.getId());
    }

    default ProfesorEntity toProfesorEntity(Profesor domain) {
        return new ProfesorEntity(domain.getId());
    }

    /* Estudiante Domain → Entity (simple) */
    default EstudianteEntity toEstudianteEntity(Estudiante domain) {
        return new EstudianteEntity(domain.getId());
    }

    default Estudiante toEstudianteDomain(EstudianteEntity entity) {
        return new Estudiante(entity.getId());
    }
}
