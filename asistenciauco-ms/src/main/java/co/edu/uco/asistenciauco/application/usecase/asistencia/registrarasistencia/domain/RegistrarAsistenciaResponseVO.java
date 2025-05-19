package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import java.util.ArrayList;
import java.util.List;

public class RegistrarAsistenciaResponseVO {

	private List<String> mensajes;

	public RegistrarAsistenciaResponseVO() {
		setMensajes(new ArrayList<>());
	}

	public List<String> getMensajes() {
		return mensajes;
	}

	private void setMensajes(final List<String> mensajes) {
		//TODO: Asegurar que los datos no sean nulos y en caso de que lo sean, crear el valor por defecto
		this.mensajes = mensajes;
	}
	
	public void agregarMensajes(final List<String> mensajes) {
		//TODO: Validar que la lista de mensajes no llegue nula
		getMensajes().addAll(mensajes);
	}
	
	public void agregarMensaje(String mensaje) {
		//TODO: asegurar que no esté nulo o vacío.
		getMensajes().add(mensaje);
	}

	public boolean isValidacionCorrecta() {
		return getMensajes().isEmpty();
	}
}
