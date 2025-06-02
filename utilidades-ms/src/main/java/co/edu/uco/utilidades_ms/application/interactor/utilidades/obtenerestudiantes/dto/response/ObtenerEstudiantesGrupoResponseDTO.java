package co.edu.uco.utilidades_ms.application.interactor.utilidades.obtenerestudiantes.dto.response;

import java.util.List;

public class ObtenerEstudiantesGrupoResponseDTO {
    private List<EstudianteResponseDTO> estudiantes;

    public ObtenerEstudiantesGrupoResponseDTO(List<EstudianteResponseDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<EstudianteResponseDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteResponseDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }
}