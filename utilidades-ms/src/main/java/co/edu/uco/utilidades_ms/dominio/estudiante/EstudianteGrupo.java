package co.edu.uco.utilidades_ms.dominio.estudiante;

public class EstudianteGrupo {
    private final String id;
    private final String tipoIdentificacion;
    private final String numeroIdentificacion;
    private final String nombresCompletos;

    public EstudianteGrupo(String id, String tipoIdentificacion, String numeroIdentificacion, String nombresCompletos) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombresCompletos = nombresCompletos;
    }

    public String getId() {
        return id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }
}