package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.dto.request;

public class ObtenerGruposProfesorRequestDTO {
    private String email;

    public ObtenerGruposProfesorRequestDTO() {
    }

    public ObtenerGruposProfesorRequestDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}