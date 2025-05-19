package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.impl;

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
	
	
	
	public RegistrarAsistenciaInteractorImpl(RegistrarAsistenciaUseCase registrarAsistenciaUseCase) {
		this.registrarAsistenciaUseCase = registrarAsistenciaUseCase;
	}



	@Override
	@Transactional
	public RegistrarAsistenciaResponseDTO ejecutar(final RegistrarAsistenciaRequestDTO dto) {
		Asistencia asistencia = null;	//OBTENER ASISTENCIA CON UN MAPPER (MAPSTRUCT) DESDE DTO HACEEEER ESTOOOOO********
		
		// LLAMAR AL CASO DE USO
		var resultadoVO = registrarAsistenciaUseCase.ejecutar(asistencia);
		
		RegistrarAsistenciaResponseDTO responseDto = null; // Obtener response DTO a partir del ResponseVO con mapper desde el DTO que retorna el Caso de Uso
		
		// TODO Auto-generated method stub
		return responseDto;
	}

}
