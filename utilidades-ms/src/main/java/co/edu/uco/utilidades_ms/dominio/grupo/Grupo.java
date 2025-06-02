package co.edu.uco.utilidades_ms.dominio.grupo;

public class Grupo {

    private final String id;
    private final String nombreMateria;
    private final int cantidadEstudiantes;

    public Grupo(String id, String nombreMateria, int cantidadEstudiantes) {
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
