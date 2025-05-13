package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.response;

import java.util.List;

public class RegistrarAsistenciaResponseDTO {
	
	private boolean transaccionExitosa;
	private List<String> mensajes;
	
	//TODO: TRANSACCIÓN EXITOSA FUE EL DE POR DEFECTO O EL QUE COLOCARON INTENCIONALMENTE
	public RegistrarAsistenciaResponseDTO() {
		super();
	}
	public boolean isTransaccionExitosa() {
		return transaccionExitosa;
	}
	public void setTransaccionExitosa(final boolean transaccionExitosa) {
		this.transaccionExitosa = transaccionExitosa;
	}
	public List<String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(final List<String> mensajes) {
		this.mensajes = mensajes;
	}
	
	
}
