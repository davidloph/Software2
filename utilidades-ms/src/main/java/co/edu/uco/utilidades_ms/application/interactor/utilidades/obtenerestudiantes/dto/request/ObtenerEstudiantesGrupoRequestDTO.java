package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.dto.request;

public class ObtenerEstudiantesGrupoRequestDTO {
    private String grupo;

    public ObtenerEstudiantesGrupoRequestDTO() {}

    public ObtenerEstudiantesGrupoRequestDTO(String grupo) {
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}