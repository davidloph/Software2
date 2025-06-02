package co.edu.uco.utilidades_ms.dominio.profesor;

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

