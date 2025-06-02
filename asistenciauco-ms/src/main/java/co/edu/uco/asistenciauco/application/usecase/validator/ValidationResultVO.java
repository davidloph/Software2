package co.edu.uco.asistenciauco.application.usecase.validator;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;

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
		this.mensajes = ObjectHelper.getDefault(mensajes, new ArrayList<>());
	}
	
	public void agregarMensajes(final List<String> mensajes) {
		setMensajes(ObjectHelper.getDefault(mensajes, new ArrayList<>()));
	}
	
	public void agregarMensaje(String mensaje) {
		getMensajes().add(TextHelper.getDefault(mensaje));
	}

	public boolean isValidacionCorrecta() {
		return getMensajes().isEmpty();
	}
	
}
