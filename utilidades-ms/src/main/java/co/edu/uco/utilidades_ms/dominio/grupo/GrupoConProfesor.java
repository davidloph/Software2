package co.edu.uco.utilidades_ms.dominio.grupo;

import co.edu.uco.utilidades_ms.dominio.profesor.Profesor;

public class GrupoConProfesor {

    private final Grupo grupo;
    private final Profesor profesor;

    public GrupoConProfesor(Grupo grupo, Profesor profesor) {
        this.grupo = grupo;
        this.profesor = profesor;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public Profesor getProfesor() {
        return profesor;
    }
}
