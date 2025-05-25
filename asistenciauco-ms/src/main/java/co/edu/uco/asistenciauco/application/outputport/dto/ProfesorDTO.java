package co.edu.uco.asistenciauco.application.outputport.dto;

import co.edu.uco.asistenciauco.application.outputport.entity.UsuarioEntity;
import co.edu.uco.crosscutting.helpers.ObjectHelper;

public final class ProfesorDTO extends UsuarioDTO{

    private UsuarioDTO usuario;

    public ProfesorDTO() {
        super();
        setDefaultUsuario();
    }


    public ProfesorDTO(final String id) {
        super(id);
        setDefaultUsuario();
    }

    public ProfesorDTO(final String id, final TipoIdentificacionDTO tipoIdentificacion, final String numeroIdentificacion, final String nombresCompletos, final String correo, final UsuarioDTO usuario) {
        super(id, tipoIdentificacion, numeroIdentificacion, nombresCompletos, correo);
        setUsuario(usuario);
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = ObjectHelper.getDefault(usuario, new UsuarioDTO());
    }

    private void setDefaultUsuario() {

        setUsuario(new UsuarioDTO());
    }
}
