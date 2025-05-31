package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.asistenciauco.application.mapper.entity.EstudianteEntityMapper;
import co.edu.uco.asistenciauco.application.outputport.repository.CanceloRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteGrupoRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.application.usecase.asistencia.validator.ValidarQueAsistenciaNoRegistradaParaSesion;
import co.edu.uco.asistenciauco.application.usecase.cancelo.validator.ValidarQueNoCancelo;
import co.edu.uco.asistenciauco.application.usecase.estudiante.validator.ValidarQueEstudianteEnGrupo;
import co.edu.uco.asistenciauco.application.usecase.estudiantegrupo.validator.ValidarQueEstudianteRegistradoAGrupo;
import co.edu.uco.asistenciauco.application.usecase.grupo.validator.ValidarQueGrupoEstaActivoBySesion;
import co.edu.uco.asistenciauco.application.usecase.grupo.validator.ValidarQueProfesorEstaAsociadoAGrupo;
import co.edu.uco.asistenciauco.application.usecase.profesor.validator.ValidarQueProfesorExista;
import co.edu.uco.asistenciauco.application.usecase.sesion.validator.ValidarProfesorAsociadoASesion;
import co.edu.uco.asistenciauco.application.usecase.sesion.validator.ValidarQueAsistenciaDentroDelPlazo;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.outputport.repository.AsistenciaRepository;
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
	private ValidarQueGrupoEstaActivoBySesion grupoEstaActivo;
	private ValidarQueAsistenciaNoRegistradaParaSesion asistenciaNoRegistrada;
	private ValidarQueAsistenciaDentroDelPlazo asistenciaDentroDelPlazo;
	private ValidarProfesorAsociadoASesion profesorAsociadoASesion;
	private ValidarQueEstudianteEnGrupo estudianteEnGrupo;
	private ValidarQueGrupoEstaActivoBySesion grupoEstaActivoBySesion;
	private ValidarQueEstudianteRegistradoAGrupo estudianteRegistradoAGrupo;
	private EstudianteGrupoRepository estudianteGrupoRepository;
	private ValidarQueNoCancelo validarQueNoCancelo;
	private EstudianteRepository estudianteRepository;
	private AsistenciaRepository asistenciaRepository;
	private CanceloRepository canceloRepository;
	private EstudianteEntityMapper estudianteEntityMapper;
	private RegistrarAsistenciaResponseVO resultado;
	//TODO: Demás validator que se usarán.
	
	public RegistrarAsistenciaUseCaseImpl(AsistenciaRepository asistenciaRepository, ValidarQueEstudianteExista estudianteExiste,
										  ValidarQueSesionExista sesionExiste, ValidarQueProfesorExista profesorExiste,
										  ValidarQueGrupoEstaActivoBySesion grupoEstaActivo, ValidarQueProfesorEstaAsociadoAGrupo profesorEstaAsociadoAGrupo,
										  ValidarQueAsistenciaNoRegistradaParaSesion asistenciaNoRegistrada, ValidarQueAsistenciaDentroDelPlazo asistenciaDentroDelPlazo,
										  ValidarQueEstudianteRegistradoAGrupo estudianteRegistradoAGrupo, ValidarQueNoCancelo validarQueNoCancelo,
										  EstudianteGrupoRepository estudianteGrupoRepository, EstudianteRepository estudianteRepository,
										  EstudianteEntityMapper estudianteEntityMapper, CanceloRepository canceloRepository,
										  ValidarProfesorAsociadoASesion profesorAsociadoASesion, ValidarQueGrupoEstaActivoBySesion grupoEstaActivoBySesion,
										  ValidarQueEstudianteEnGrupo estudianteEnGrupo) {
		this.asistenciaRepository = asistenciaRepository;
		this.estudianteGrupoRepository = estudianteGrupoRepository;
		this.estudianteRepository = estudianteRepository;
		this.canceloRepository = canceloRepository;
		this.estudianteExiste = estudianteExiste;
		this.grupoEstaActivoBySesion = grupoEstaActivoBySesion;
		this.estudianteEnGrupo = estudianteEnGrupo;
		this.sesionExiste = sesionExiste;
		this.profesorAsociadoASesion = profesorAsociadoASesion;
		this.profesorExiste = profesorExiste;
		this.grupoEstaActivo = grupoEstaActivo;
		this.sesionExiste = sesionExiste;
		this.estudianteRegistradoAGrupo = estudianteRegistradoAGrupo;
		this.validarQueNoCancelo = validarQueNoCancelo;
		this.asistenciaNoRegistrada = asistenciaNoRegistrada;
		this.asistenciaDentroDelPlazo = asistenciaDentroDelPlazo;
		this.estudianteEntityMapper = estudianteEntityMapper;
		resultado = new RegistrarAsistenciaResponseVO();
		//TODO: Inyección de los demás validator.
	}



	@Override
	public RegistrarAsistenciaResponseVO ejecutar(Asistencia dominio) {
		
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
			resultado.agregarMensajes(grupoEstaActivo.validate(dominio.getSesion().getId()).getMensajes());
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

			//registrarAsistenciaEstudiantes(dominio.getEstudiantes());
			registrarAsistenciaEstudiantes(dominio.getEstudiantes(), dominio.getSesion().getId());
		}
		
		//Retorno de resultado
		return resultado;
	}
	
	private void registrarAsistenciaEstudiantes(List<Estudiante> estudiantes, UUID idSesion) {
		for (Estudiante estudiante : estudiantes) {
			var registrarAsistenciaResponseEstudianteVO = new RegistrarAsistenciaResponseVO();
			
			// 1. Validar que el estudiante exista.
			validarQueEstudianteExiste(estudiante.getId());

			//Se Validó en 8.
			// 2. Validar que el estudiante esté registrado en el grupo.
			if(registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
				validarQueEstudianteRegistradoEnGrupo(idSesion, estudiante.getId());
			}

			//Se validó en 8.
			// 3. Validar que el estudiante no tenga la materia cancelada por alguna novedad.
			if(registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
				validarQueEstudianteNoCancelo(estudiante.getId(), idSesion);
			}
			
			// 4. Registrar asistencia por cada estudiante.
			if(registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
				registrarAsistenciaEstudiante(estudiante);
			}
			// 5. Registrar asistencias
			resultado.agregarMensajes(registrarAsistenciaResponseEstudianteVO.getMensajes());
		}
	}
	
	private void validarQueEstudianteExiste(UUID idEstudiante) {
		resultado.agregarMensajes(estudianteExiste.validate(idEstudiante).getMensajes());
	}

	private void validarQueEstudianteRegistradoEnGrupo(UUID idSesion, UUID idEstudiante) {
		resultado.agregarMensajes(estudianteEnGrupo.validate(new ArrayList<>(List.of(idSesion, idEstudiante))).getMensajes());
	}

	private void validarQueEstudianteNoCancelo(UUID idEstudiante, UUID idSesion) {
		resultado.agregarMensajes(validarQueNoCancelo.validate(new ArrayList<UUID>(List.of(idEstudiante, idSesion))).getMensajes());
	}
	
	private void registrarAsistenciaEstudiante(Estudiante estudiante) {
		// 1. Registrar Asistencia
		
		// 2. Enviar la notificación de correo al estudiante porque no asistió.
		if(!estudiante.isAsistio()) {
			
		}
	}

}
