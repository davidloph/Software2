package co.edu.uco.utilidades_ms.dominio.estudiante;

public class ObtenerEstudiantesGrupoDomain {
    private final String grupoId;

    public ObtenerEstudiantesGrupoDomain(String grupoId) {
        this.grupoId = grupoId;
    }

    public String getGrupoId() {
        return grupoId;
    }
}