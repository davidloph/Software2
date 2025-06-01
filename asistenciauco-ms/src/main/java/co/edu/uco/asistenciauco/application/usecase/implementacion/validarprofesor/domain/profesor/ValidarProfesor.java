package co.edu.uco.asistenciauco.application.usecase.implementacion.validarprofesor.domain.profesor;

public class ValidarProfesor {
    private final String email;

    private ValidarProfesor(String email) {
        this.email = email;
    }

    public static ValidarProfesor of(String email) {
        return new ValidarProfesor(email);
    }

    public String getEmail() {
        return email;
    }
}
