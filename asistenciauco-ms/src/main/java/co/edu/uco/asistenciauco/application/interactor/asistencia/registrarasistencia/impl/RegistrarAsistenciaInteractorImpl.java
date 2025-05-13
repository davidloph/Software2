package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.RegistrarAsistenciaInteractor;
import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.response.RegistrarAsistenciaResponseDTO;
import co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain.Asistencia;

@Service
public class RegistrarAsistenciaInteractorImpl implements RegistrarAsistenciaInteractor{

	@Override
	public RegistrarAsistenciaResponseDTO ejecutar(final RegistrarAsistenciaRequestDTO dto) {
		Asistencia asistencia = null;	//OBTENER ASISTENCIA CON UN MAPPER (MAPSTRUCT) DESDE DTO HACEEEER ESTOOOOO********
		
		// LLAMAR AL CASO DE USO
		
		// TODO Auto-generated method stub
		return null;
	}

}
