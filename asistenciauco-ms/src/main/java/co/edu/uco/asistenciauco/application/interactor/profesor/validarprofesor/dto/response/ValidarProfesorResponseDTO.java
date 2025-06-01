package co.edu.uco.asistenciauco.application.interactor.profesor.validarprofesor.dto.response;

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
