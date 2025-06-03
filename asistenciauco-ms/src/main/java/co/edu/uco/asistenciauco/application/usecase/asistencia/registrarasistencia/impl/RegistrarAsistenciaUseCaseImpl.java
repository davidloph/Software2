package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.asistenciauco.application.mapper.entity.AsistenciaMapper;
import co.edu.uco.asistenciauco.application.outputport.entity.EstudianteEntity;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.RedisConstants;
import co.edu.uco.asistenciauco.application.outputport.entity.constants.SendGridConstants;
import co.edu.uco.asistenciauco.application.outputport.redis.MessageCatalog;
import co.edu.uco.asistenciauco.application.outputport.repository.AsistenciaRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.EstudianteRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.MateriaRepository;
import co.edu.uco.asistenciauco.application.outputport.repository.SesionRepository;
import co.edu.uco.asistenciauco.application.outputport.sendgrid.SendGridService;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.application.usecase.asistencia.validator.ValidarQueAsistenciaNoRegistradaParaSesion;
import co.edu.uco.asistenciauco.application.usecase.estudiante.validator.ValidarListaEstudiantesNoRepetidos;
import co.edu.uco.asistenciauco.application.usecase.estudiante.validator.ValidarListaEstudiantesNoVacia;
import co.edu.uco.asistenciauco.application.usecase.grupo.validator.ValidarQueGrupoActivo;
import co.edu.uco.asistenciauco.application.usecase.estudiante.validator.ValidarQueEstudianteEnGrupo;
import co.edu.uco.asistenciauco.application.usecase.estudiantegrupo.validator.ValidarQueEstudianteNoCancelo;
import co.edu.uco.asistenciauco.application.usecase.profesor.validator.ValidarQueProfesorExista;
import co.edu.uco.asistenciauco.application.usecase.sesion.validator.ValidarProfesorAsociadoASesion;
import co.edu.uco.asistenciauco.application.usecase.sesion.validator.ValidarQueAsistenciaDentroDelPlazo;
import co.edu.uco.asistenciauco.crosscutting.exceptions.UseCaseAsisteUcoException;
import co.edu.uco.asistenciauco.infrastructure.secondaryadapters.EmailMessage;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.RegistrarAsistenciaUseCase;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Estudiante;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.RegistrarAsistenciaResponseVO;
import co.edu.uco.asistenciauco.application.usecase.estudiante.validator.ValidarQueEstudianteExista;
import co.edu.uco.asistenciauco.application.usecase.sesion.validator.ValidarQueSesionExista;

@Service
public class RegistrarAsistenciaUseCaseImpl implements RegistrarAsistenciaUseCase{

	private final ValidarQueEstudianteExista estudianteExiste;
	private final ValidarQueSesionExista sesionExiste;
	private final ValidarQueProfesorExista profesorExiste;
	private final ValidarQueAsistenciaNoRegistradaParaSesion asistenciaNoRegistrada;
	private final ValidarQueAsistenciaDentroDelPlazo asistenciaDentroDelPlazo;
	private final ValidarProfesorAsociadoASesion profesorAsociadoASesion;
	private final ValidarQueEstudianteEnGrupo estudianteEnGrupo;
	private final ValidarQueEstudianteNoCancelo estudianteNoCancelo;
	private final ValidarQueGrupoActivo validarQueGrupoActivo;
	private  RegistrarAsistenciaResponseVO resultado;
	private final AsistenciaRepository asistenciaRepository;
	private final SendGridService sendGridService;
	private final EstudianteRepository estudianteRepository;
	private final AsistenciaMapper asistenciaMapper;
	private MessageCatalog messageCatalog;
	private final MateriaRepository materiaRepository;
	private final SesionRepository sesionRepository;
	private final ValidarListaEstudiantesNoVacia validarListaEstudiantesNoVacia;
	private final ValidarListaEstudiantesNoRepetidos validarListaEstudiantesNoRepetidos;


	public RegistrarAsistenciaUseCaseImpl(ValidarQueEstudianteExista estudianteExiste,
                                          ValidarQueSesionExista sesionExiste, ValidarQueProfesorExista profesorExiste,
                                          ValidarQueAsistenciaNoRegistradaParaSesion asistenciaNoRegistrada, ValidarQueAsistenciaDentroDelPlazo asistenciaDentroDelPlazo,
                                          ValidarProfesorAsociadoASesion profesorAsociadoASesion,
                                          ValidarQueEstudianteEnGrupo estudianteEnGrupo, ValidarQueEstudianteNoCancelo estudianteNoCancelo,
                                          ValidarQueGrupoActivo validarQueGrupoActivo,
                                          AsistenciaRepository asistenciaRepository, SendGridService sendGridService, EstudianteRepository estudianteRepository,
                                          AsistenciaMapper asistenciaMapper, MateriaRepository materiaRepository,
                                          SesionRepository sesionRepository,
                                          ValidarListaEstudiantesNoVacia validarListaEstudiantesNoVacia, ValidarListaEstudiantesNoRepetidos validarListaEstudiantesNoRepetidos) {
		this.estudianteExiste = estudianteExiste;
		this.estudianteEnGrupo = estudianteEnGrupo;
		this.estudianteNoCancelo = estudianteNoCancelo;
		this.profesorAsociadoASesion = profesorAsociadoASesion;
		this.profesorExiste = profesorExiste;
		this.sesionExiste = sesionExiste;
		this.validarQueGrupoActivo = validarQueGrupoActivo;
		this.asistenciaNoRegistrada = asistenciaNoRegistrada;
		this.asistenciaDentroDelPlazo = asistenciaDentroDelPlazo;
        this.validarListaEstudiantesNoRepetidos = validarListaEstudiantesNoRepetidos;
        resultado = new RegistrarAsistenciaResponseVO();
		this.asistenciaRepository = asistenciaRepository;
		this.sendGridService = sendGridService;
		this.estudianteRepository = estudianteRepository;
		this.asistenciaMapper = asistenciaMapper;
		this.materiaRepository = materiaRepository;
		this.sesionRepository = sesionRepository;
		this.validarListaEstudiantesNoVacia = validarListaEstudiantesNoVacia;
	}



	@Override
	public RegistrarAsistenciaResponseVO ejecutar(Asistencia dominio) {

		resultado = new RegistrarAsistenciaResponseVO();

		// 1. Validar integridad del objeto a nivel de tipo de datos, es defecto, longitud, obligatoriedad, formato, rango...
		if(resultado.isValidacionCorrecta()){
			resultado.agregarMensajes(validarListaEstudiantesNoVacia.validate(dominio.getEstudiantes()).getMensajes());
		}else {
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGESLISTAVACIA);
			String technicalMessage = resultado.getMensajes().getFirst();
			throw UseCaseAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		// 2. La sesión debe existir.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(sesionExiste.validate(dominio.getSesion()).getMensajes());
		} else {
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGESESIONDEBEEXISTIR);
			String technicalMessage = resultado.getMensajes().getFirst();
			throw UseCaseAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		// 3. El profesor que registra la asistencia debe existir.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(profesorExiste.validate(dominio.getProfesor()).getMensajes());
		} else {
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEPROFESORDEBEEXISTIR);
			String technicalMessage = resultado.getMensajes().getFirst();
			throw UseCaseAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		// 4. El grupo debe estar activo
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(validarQueGrupoActivo.validate(asistenciaMapper.toSesionEntity(dominio.getSesion()).getId()).getMensajes());
		} else {
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEGRUPOACTIVO);
			String technicalMessage = resultado.getMensajes().getFirst();
			throw UseCaseAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		// 5. El profesor debe estar asignado al grupo.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(profesorAsociadoASesion.validate(new ArrayList<>(List.of(asistenciaMapper.toSesionEntity(dominio.getSesion()).getId(), asistenciaMapper.toProfesorEntity(dominio.getProfesor()).getId()))).getMensajes());
		} else {
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEPROFESORGRUPO);
			String technicalMessage = resultado.getMensajes().getFirst();
			throw UseCaseAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		// 6. No se puede tener una asistencia ya registrada para la sesión.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(asistenciaNoRegistrada.validate(dominio.getSesion()).getMensajes());
		} else {
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEASISTENCIAREGISTRADAPARASESION);
			String technicalMessage = resultado.getMensajes().getFirst();
			throw UseCaseAsisteUcoException.create(userMessage, technicalMessage);
		}
		
		// 7. La asistencia se debe registrar entre los plazos establecidos.
		if(resultado.isValidacionCorrecta()) {
			resultado.agregarMensajes(asistenciaDentroDelPlazo.validate(dominio.getSesion()).getMensajes());
		} else {
			String userMessage = messageCatalog.getMessage(RedisConstants.USERMESSAGEASISTENCIAENPLAZO);
			String technicalMessage = resultado.getMensajes().getFirst();
			throw UseCaseAsisteUcoException.create(userMessage, technicalMessage);
		}

		// Validar que la lista de estudiantes no tenga un mismo estudiantes más de una vez.
		if(resultado.isValidacionCorrecta()) {
			ArrayList<UUID> idEstudiantes = new ArrayList<>();
			for (Estudiante estudiante : dominio.getEstudiantes()) {
				idEstudiantes.add(estudiante.getId());
			}
			resultado.agregarMensajes(validarListaEstudiantesNoRepetidos.validate(idEstudiantes).getMensajes());
		} else {
			String userMessage = messageCatalog.getMessage(RedisConstants.VALIDARESTUDIANTESREPETIDOS);
			String technicalMessage = resultado.getMensajes().getFirst();
			throw UseCaseAsisteUcoException.create(userMessage, technicalMessage);
		}

		// 8. Validar que estudiantes sean consistentes para el registro de asistencia.
		if(resultado.isValidacionCorrecta()) {
			registrarAsistenciaEstudiantes(dominio.getEstudiantes(), asistenciaMapper.toSesionEntity(dominio.getSesion()).getId());
		}
		
		//Retorno de resultado
		return resultado;
	}
	
	private void registrarAsistenciaEstudiantes(List<Estudiante> estudiantes, UUID idSesion) {

		for (Estudiante estudiante : estudiantes) {
			EstudianteEntity estudianteEntity = asistenciaMapper.toEstudianteEntity(estudiante);
			var registrarAsistenciaResponseEstudianteVO = new RegistrarAsistenciaResponseVO();
			ArrayList<UUID> datos = new ArrayList<>();
			datos.add(estudianteEntity.getId());
			datos.add(idSesion);
			
			// 1. Validar que el estudiante exista.
			if(registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()){
				registrarAsistenciaResponseEstudianteVO.agregarMensajes(estudianteExiste.validate(estudiante).getMensajes());
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

		asistenciaRepository.insertarAsistencia(asistenciaMapper.toEstudianteEntity(estudiante).getId(),sesionId,estudiante.isAsistio());
		String materia = materiaRepository.findNombreMateriaBySesionId(sesionId);
		LocalDateTime fecha = sesionRepository.findFechaHoraBySesionId(sesionId);
		

		if(!estudiante.isAsistio()) {
			var correoEstudiante =  estudianteRepository.obtenerCorreoPorIdEstudiante(asistenciaMapper.toEstudianteEntity(estudiante).getId());
			EmailMessage message = EmailMessage.create(
					correoEstudiante,
					SendGridConstants.SUBJECT,
					SendGridConstants.CONTENTFIRST + materia + SendGridConstants.CONTENTLAST + fecha.toString());
			sendGridService.send(message);
		}
	}
}
