package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.impl;

import co.edu.uco.asistenciauco.application.mapper.dto.RegistrarAsistenciaRequestDTOMapper;
import co.edu.uco.asistenciauco.application.mapper.dto.RegistrarAsistenciaResponseDTOMapper;
import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.RegistrarAsistenciaInteractor;
import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.response.RegistrarAsistenciaResponseDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.RegistrarAsistenciaUseCase;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;
import jakarta.transaction.Transactional;

@Service
public class RegistrarAsistenciaInteractorImpl implements RegistrarAsistenciaInteractor{

	private RegistrarAsistenciaUseCase registrarAsistenciaUseCase;
	private final RegistrarAsistenciaRequestDTOMapper registrarAsistenciaRequestDTOMapper;
	private final RegistrarAsistenciaResponseDTOMapper registrarAsistenciaResponseDTOMapper;


	public RegistrarAsistenciaInteractorImpl(RegistrarAsistenciaUseCase registrarAsistenciaUseCase,
											 RegistrarAsistenciaRequestDTOMapper registrarAsistenciaRequestDTOMapper,
											 RegistrarAsistenciaResponseDTOMapper registrarAsistenciaResponseDTOMapper) {
		this.registrarAsistenciaUseCase = registrarAsistenciaUseCase;
		this.registrarAsistenciaRequestDTOMapper = registrarAsistenciaRequestDTOMapper;
		this.registrarAsistenciaResponseDTOMapper = registrarAsistenciaResponseDTOMapper;
	}



	@Override
	@Transactional
	public RegistrarAsistenciaResponseDTO ejecutar(final RegistrarAsistenciaRequestDTO dto) {

		Asistencia asistencia = registrarAsistenciaRequestDTOMapper.toAsistenciaTest(dto);  //OBTENER ASISTENCIA CON UN MAPPER (MAPSTRUCT) DESDE DTO HACEEEER ESTOOOOO********
		
		// LLAMAR AL CASO DE USO
		var resultadoVO = registrarAsistenciaUseCase.ejecutar(asistencia);

		return registrarAsistenciaResponseDTOMapper.toAsistenciaTest(resultadoVO);
	}

}
