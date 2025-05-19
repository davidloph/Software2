package co.edu.uco.asistenciauco.application.usecase.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationResultVO {

	private List<String> mensajes;
	
	public ValidationResultVO() {
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
		setMensajes(mensajes);
	}
	
	public void agregarMensaje(String mensaje) {
		//TODO: asegurar que no esté nulo o vacío.
		getMensajes().add(mensaje);
	}

	public boolean isValidacionCorrecta() {
		return getMensajes().isEmpty();
	}
	
}
