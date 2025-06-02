package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenersesiones.dto.response;

public class SesionResponseDTO {
    private String id;
    private String fechaHora;

    public SesionResponseDTO(String id, String fechaHora) {
        this.id = id;
        this.fechaHora = fechaHora;
    }

    public String getId() {
        return id;
    }

    public String getFechaHora() {
        return fechaHora;
    }
}

