package co.edu.uco.utilidades_ms.dominio.sesion;

import java.time.LocalDateTime;

public class SesionGrupo {
    private String id;
    private LocalDateTime fechaHora;

    public SesionGrupo(String id, LocalDateTime fechaHora) {
        this.id = id;
        this.fechaHora = fechaHora;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
