package co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.request;

public class ValidarProfesorRequestDTO {
    private String email;

    public ValidarProfesorRequestDTO() {}

    public ValidarProfesorRequestDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
