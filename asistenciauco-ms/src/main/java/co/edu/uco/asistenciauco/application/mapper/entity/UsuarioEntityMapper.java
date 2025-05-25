package co.edu.uco.asistenciauco.application.mapper.entity;

import co.edu.uco.asistenciauco.application.outputport.entity.UsuarioEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = TipoIdentificacionEntityMapper.class)
public interface UsuarioEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion"),
		@Mapping(source = "numeroIdentificacion", target = "numeroIdentificacion"),
		@Mapping(source = "nombresCompletos", target = "nombresCompletos"),
		@Mapping(source = "correo", target = "correo"),
	})
	Usuario toUsuario(UsuarioEntity profesorEntity);
	List<Usuario> toUsuarios(List<UsuarioEntity> profesoresEntity);
	
	@InheritInverseConfiguration
	UsuarioEntity toUsuarioEntity(Usuario profesor);
	List<UsuarioEntity> toUsuariosEntity(List<Usuario> profesores);
}
