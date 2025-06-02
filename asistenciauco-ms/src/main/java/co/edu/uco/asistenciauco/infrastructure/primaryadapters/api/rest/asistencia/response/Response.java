package co.edu.uco.asistenciauco.infrastructure.primaryadapters.api.rest.asistencia.response;

import java.util.ArrayList;
import java.util.List;

import  co.edu.uco.crosscutting.helpers.ObjectHelper;

public abstract class Response {
	
	private List<String> messages = new ArrayList<>();

	public final List<String> getMessages() {
		return messages;
	}

	public  void setMessages(List<String> messages) {
		this.messages = ObjectHelper.getDefault(messages, this.messages);
	}
	
}
