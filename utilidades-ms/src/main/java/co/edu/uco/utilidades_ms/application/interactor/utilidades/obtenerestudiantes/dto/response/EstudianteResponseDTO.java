package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.dto.response;

public class EstudianteResponseDTO {
    private String id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombresCompletos;

    public EstudianteResponseDTO(String id, String tipoIdentificacion, String numeroIdentificacion, String nombresCompletos) {
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