package co.edu.uco.utilidades_ms.application.interactor.utilidades.validarprofesor.dto.response;

public class ValidarProfesorResponseDTO {
    private boolean esProfesor;

    public ValidarProfesorResponseDTO() {}

    public ValidarProfesorResponseDTO(boolean esProfesor) {
        this.esProfesor = esProfesor;
    }

    public boolean isEsProfesor() {
        return esProfesor;
    }

    public void setEsProfesor(boolean esProfesor) {
        this.esProfesor = esProfesor;
    }
}