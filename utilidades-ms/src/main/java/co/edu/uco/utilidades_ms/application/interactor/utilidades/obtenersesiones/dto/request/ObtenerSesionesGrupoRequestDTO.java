package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.request;

public class ObtenerSesionesGrupoRequestDTO {
    private String grupo;

    public ObtenerSesionesGrupoRequestDTO() {}

    public ObtenerSesionesGrupoRequestDTO(String grupo) {
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}