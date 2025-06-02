package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.repository.AsistenciaRepository;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.application.usecase.asistencia.validator.ValidarQueAsistenciaNoRegistradaParaSesion;
import co.edu.uco.asistenciauco.application.usecase.grupo.validator.ValidarQueGrupoActivo;
import co.edu.uco.asistenciauco.application.usecase.estudiante.validator.ValidarQueEstudianteEnGrupo;
import co.edu.uco.asistenciauco.application.usecase.estudiantegrupo.validator.ValidarQueEstudianteNoCancelo;
import co.edu.uco.asistenciauco.application.usecase.profesor.validator.ValidarQueProfesorExista;
import co.edu.uco.asistenciauco.application.usecase.sesion.validator.ValidarProfesorAsociadoASesion;
import co.edu.uco.asistenciauco.application.usecase.sesion.validator.ValidarQueAsistenciaDentroDelPlazo;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.RegistrarAsistenciaUseCase;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.RegistrarAsistenciaResponseVO;
import co.edu.uco.asistenciauco.application.usecase.estudiante.validator.ValidarQueEstudianteExista;
import co.edu.uco.asistenciauco.application.usecase.sesion.validator.ValidarQueSesionExista;

@Service
public class RegistrarAsistenciaUseCaseImpl implements RegistrarAsistenciaUseCase{

	private ValidarQueEstudianteExista estudianteExiste;
	private ValidarQueSesionExista sesionExiste;
	private ValidarQueProfesorExista profesorExiste;
	private ValidarQueAsistenciaNoRegistradaParaSesion asistenciaNoRegistrada;
	private ValidarQueAsistenciaDentroDelPlazo asistenciaDentroDelPlazo;
	private ValidarProfesorAsociadoASesion profesorAsociadoASesion;
	private ValidarQueEstudianteEnGrupo estudianteEnGrupo;
	private ValidarQueEstudianteNoCancelo estudianteNoCancelo;
	private ValidarQueGrupoActivo validarQueGrupoActivo;
	private RegistrarAsistenciaResponseVO resultado;
	private AsistenciaRepository asistenciaRepository;
	
	public RegistrarAsistenciaUseCaseImpl(ValidarQueEstudianteExista estudianteExiste,
										  ValidarQueSesionExista sesionExiste, ValidarQueProfesorExista profesorExiste,
										  ValidarQueAsistenciaNoRegistradaParaSesion asistenciaNoRegistrada, ValidarQueAsistenciaDentroDelPlazo asistenciaDentroDelPlazo,
										  ValidarProfesorAsociadoASesion profesorAsociadoASesion,
										  ValidarQueEstudianteEnGrupo estudianteEnGrupo, ValidarQueEstudianteNoCancelo estudianteNoCancelo,
										  ValidarQueGrupoActivo validarQueGrupoActivo,
										  AsistenciaRepository asistenciaRepository) {
		this.estudianteExiste = estudianteExiste;
		this.estudianteEnGrupo = estudianteEnGrupo;
		this.estudianteNoCancelo = estudianteNoCancelo;
		this.profesorAsociadoASesion = profesorAsociadoASesion;
		this.profesorExiste = profesorExiste;
		this.sesionExiste = sesionExiste;
		this.validarQueGrupoActivo = validarQueGrupoActivo;
		this.asistenciaNoRegistrada = asistenciaNoRegistrada;
		this.asistenciaDentroDelPlazo = asistenciaDentroDelPlazo;
		resultado = new RegistrarAsistenciaResponseVO();
		this.asistenciaRepository = asistenciaRepository;
	}



	@Override
	public RegistrarAsistenciaResponseVO ejecutar(Asistencia dominio) {

		resultado = new RegistrarAsistenciaResponseVO();

		// 1. Validar integridad del objeto a nivel de tipo de datos, es defecto, longitud, obligatoriedad, formato, rango...
		
		// 2. La sesión debe existir.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(sesionExiste.validate(dominio.getSesion().getId()).getMensajes());
		}
		
		// 3. El profesor que registra la asistencia debe existir.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(profesorExiste.validate(dominio.getProfesor().getId()).getMensajes());
		}
		
		// 4. El grupo debe estar activo
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(validarQueGrupoActivo.validate(dominio.getSesion().getId()).getMensajes());
		}
		
		// 5. El profesor debe estar asignado al grupo.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(profesorAsociadoASesion.validate(new ArrayList<>(List.of(dominio.getSesion().getId(), dominio.getProfesor().getId()))).getMensajes());
		}
		
		// 6. No se puede tener una asistencia ya registrada para la sesión.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(asistenciaNoRegistrada.validate(dominio.getSesion().getId()).getMensajes());
		}
		
		// 7. La asistencia se debe registrar entre los plazos establecidos.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(asistenciaDentroDelPlazo.validate(dominio.getSesion().getId()).getMensajes());
		}
		
		// 8. Validar que estudiantes sean consistentes para el registro de asistencia.
		// SE OBTUVIERON TODOS LOS ESTUDIANTES DE UN GRUPO QUE NO HAN CANCELADO!
		if(resultado.isValidacionCorrecta()) {
			// Obtención de estudiantes de un grupo que no cancelaron.
			registrarAsistenciaEstudiantes(dominio.getEstudiantes(), dominio.getSesion().getId());
		}
		
		//Retorno de resultado
		return resultado;
	}
	
	private void registrarAsistenciaEstudiantes(List<Estudiante> estudiantes, UUID idSesion) {

		for (Estudiante estudiante : estudiantes) {

			var registrarAsistenciaResponseEstudianteVO = new RegistrarAsistenciaResponseVO();
			ArrayList<UUID> datos = new ArrayList<>();
			datos.add(estudiante.getId());
			datos.add(idSesion);
			
			// 1. Validar que el estudiante exista.
			if(registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()){
				registrarAsistenciaResponseEstudianteVO.agregarMensajes(estudianteExiste.validate(estudiante.getId()).getMensajes());
			}

			//Se Validó en 8.
			// 2. Validar que el estudiante esté registrado en el grupo.
			if(registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
				registrarAsistenciaResponseEstudianteVO.agregarMensajes(estudianteEnGrupo.validate(datos).getMensajes());
			}

			//Se validó en 8.
			// 3. Validar que el estudiante no tenga la materia cancelada por alguna novedad.
			if(registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
				registrarAsistenciaResponseEstudianteVO.agregarMensajes(estudianteNoCancelo.validate(datos).getMensajes());
			}
			
			// 4. Registrar asistencia por cada estudiante.
			if(registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
				registrarAsistenciaEstudiante(estudiante,idSesion);
			}
			// 5. Registrar asistencias
			resultado.agregarMensajes(registrarAsistenciaResponseEstudianteVO.getMensajes());
		}
	}
	
	private void registrarAsistenciaEstudiante(Estudiante estudiante, UUID sesionId) {
		// 1. Registrar Asistencia

		asistenciaRepository.insertarAsistencia(estudiante.getId(),sesionId,estudiante.isAsistio());
		
		// 2. Enviar la notificación de correo al estudiante porque no asistió.
		if(!estudiante.isAsistio()) {
			
		}
	}

}
