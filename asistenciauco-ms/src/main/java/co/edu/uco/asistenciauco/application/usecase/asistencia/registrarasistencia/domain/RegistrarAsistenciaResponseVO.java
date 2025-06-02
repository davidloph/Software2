package co.edu.uco.asistenciauco.application.usecase.asistencia.registrarasistencia.domain;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;

import java.util.ArrayList;
import java.util.List;

public final class RegistrarAsistenciaResponseVO {

	private List<String> mensajes;

	public RegistrarAsistenciaResponseVO() {
		setMensajes(new ArrayList<>());
	}

	public List<String> getMensajes() {
		return mensajes;
	}

	private void setMensajes(final List<String> mensajes) {
		this.mensajes = ObjectHelper.getDefault(mensajes, new ArrayList<String>());
	}
	
	public void agregarMensajes(final List<String> mensajes) {
		getMensajes().addAll(ObjectHelper.getDefault(mensajes, new ArrayList<String>()));

	}
	
	public void agregarMensaje(String mensaje) {
		getMensajes().add(TextHelper.getDefault(mensaje));
	}

	public boolean isValidacionCorrecta() {
		return getMensajes().isEmpty();
	}
}
