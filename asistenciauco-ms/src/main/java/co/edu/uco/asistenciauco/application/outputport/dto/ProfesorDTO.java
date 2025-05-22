package co.edu.uco.asistenciauco.application.outputport.dto;

public final class ProfesorDTO extends UsuarioDTO{

    public ProfesorDTO() {
        setDefaultId();
        setDefaultNumeroIdentificacion();
        setDefaultNumeroIdentificacion();
        setDefaultNombresCompletos();
    }


    public ProfesorDTO(final String id) {
        setId(id);
        setDefaultTipoIdentificacion();
        setDefaultNumeroIdentificacion();
        setDefaultNombresCompletos();
    }

    public ProfesorDTO(final String id, final TipoIdentificacionDTO tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos) {
        setId(id);
        setTipoIdentificacion(tipoIdentificacion);
        setNumeroIdentificacion(numeroIdentificacion);
        setNombresCompletos(nombresCompletos);
    }
}
