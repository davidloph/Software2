package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenergrupos.dto.response;

public class GrupoResponseDTO {
    private String id;
    private String nombreMateria;
    private int cantidadEstudiantes;

    public GrupoResponseDTO(String id, String nombreMateria, int cantidadEstudiantes) {
        this.id = id;
        this.nombreMateria = nombreMateria;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public String getId() {
        return id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }
}
