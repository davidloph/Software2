package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.response;

import java.util.List;

public class ObtenerSesionesGrupoResponseDTO {
    private List<SesionResponseDTO> sesiones;

    public ObtenerSesionesGrupoResponseDTO(List<SesionResponseDTO> sesiones) {
        this.sesiones = sesiones;
    }

    public List<SesionResponseDTO> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<SesionResponseDTO> sesiones) {
        this.sesiones = sesiones;
    }
}