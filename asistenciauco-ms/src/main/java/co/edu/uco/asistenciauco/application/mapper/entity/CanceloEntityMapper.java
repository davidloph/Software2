package co.edu.uco.asistenciauco.application.mapper.entity;

import co.edu.uco.asistenciauco.application.outputport.entity.CanceloEntity;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Cancelo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = EstudianteGrupoEntityMapper.class)
public interface CanceloEntityMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "estudianteGrupo", target = "estudianteGrupo"),
		@Mapping(source = "fecha", target = "fecha"),
		@Mapping(source = "motivo", target = "motivo"),
		@Mapping(source = "activo", target = "activo")
	})
	Cancelo toCancelo(CanceloEntity cancelo);
	List<Cancelo> toCancelos(List<CanceloEntity> cancelos);
	
	@InheritInverseConfiguration
	CanceloEntity toCanceloEntity(Cancelo cancelo);
	List<CanceloEntity> toCancelosEntity(List<Cancelo> cancelos);
}
