package co.edu.uco.asistenciauco.application.interactor.asistencia.registrarasistencia.dto.response;

import java.util.ArrayList;
import java.util.List;

public class RegistrarAsistenciaResponseDTO {
	
	private boolean transaccionExitosa;
	private boolean transaccionExitosaFlag;
	private List<String> mensajes;
	
	//TODO: TRANSACCIÓN EXITOSA FUE EL DE POR DEFECTO O EL QUE COLOCARON INTENCIONALMENTE
	public RegistrarAsistenciaResponseDTO() {
		setDefaultTransaccionExitosa();
		setDefaultMensajes();
	}
	public RegistrarAsistenciaResponseDTO(final boolean transaccionExitosa, final List<String> mensajes) {
		this.transaccionExitosa = transaccionExitosa;
		this.mensajes = mensajes;
	}

	public boolean isTransaccionExitosa() {
		return transaccionExitosa;
	}
	
	public void setTransaccionExitosa(final boolean transaccionExitosa) {
		this.transaccionExitosaFlag = true;
		this.transaccionExitosa = transaccionExitosa;
	}
	public void setDefaultTransaccionExitosa() {
		this.transaccionExitosaFlag = false;
		this.transaccionExitosa = transaccionExitosa;
	}
	public List<String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(final List<String> mensajes) {
		this.mensajes = mensajes;
	}
	public void setDefaultMensajes() {
		this.mensajes = new ArrayList<>();
	}
	public boolean isTransaccionExitosaFlag() {
		return transaccionExitosaFlag;
	}
	
	
}
