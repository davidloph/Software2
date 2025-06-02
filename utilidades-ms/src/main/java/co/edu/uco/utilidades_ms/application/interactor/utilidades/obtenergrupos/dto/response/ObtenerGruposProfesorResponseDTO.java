package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.dto.response;

import java.util.List;

public class ObtenerGruposProfesorResponseDTO {

    private String idProfesor;
    private List<GrupoResponseDTO> grupos;

    public ObtenerGruposProfesorResponseDTO(String idProfesor, List<GrupoResponseDTO> grupos) {
        this.idProfesor = idProfesor;
        this.grupos = grupos;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public List<GrupoResponseDTO> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<GrupoResponseDTO> grupos) {
        this.grupos = grupos;
    }
}