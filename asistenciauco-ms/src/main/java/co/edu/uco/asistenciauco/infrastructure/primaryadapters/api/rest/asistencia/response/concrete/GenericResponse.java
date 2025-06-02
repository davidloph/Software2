package co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia.response.concrete;

import java.util.List;

import co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia.response.Response;

public class GenericResponse extends Response{
	
	public static Response build(final List<String> messages) {
		var response = new GenericResponse();
		response.setMessages(messages);
		return response;
	}

}
