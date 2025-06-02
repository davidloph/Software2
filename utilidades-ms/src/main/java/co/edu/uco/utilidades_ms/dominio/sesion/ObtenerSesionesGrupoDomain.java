package co.edu.uco.utilidades_ms.dominio.sesion;

public class ObtenerSesionesGrupoDomain {
    private final String grupoId;

    public ObtenerSesionesGrupoDomain(String grupoId) {
        this.grupoId = grupoId;
    }

    public String getGrupoId() {
        return grupoId;
    }
}
