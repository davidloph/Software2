package co.edu.uco.utilidades_ms.application.outputport.entity;

import co.edu.uco.utilidades_ms.application.outputport.entity.constants.ProfesorConstants;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
@Table(name = ProfesorConstants.TABLE_PROFESOR)
public final class ProfesorEntity{
	@Id
	@Column(name = ProfesorConstants.COLUMN_ID)
	private UUID id;
	@OneToOne
	@JoinColumn(name = ProfesorConstants.COLUMN_USUARIO)
	private UsuarioEntity usuario;

	public ProfesorEntity() {
		setDefaultId();
		setDefaultUsuario();
	}

	public ProfesorEntity(UUID id) {
		setId(id);
		setDefaultUsuario();
	}

	public ProfesorEntity(final UUID id, final UsuarioEntity usuario) {
		setId(id);
		setUsuario(usuario);
	}

	public UUID getId() {

		return id;
	}
	private void setId(final UUID id) {

		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	private void setDefaultId() {
		//TODO: OBTENER VALOR POR DEFECTO*******
		//TODO: LO MÁS PROBABLE ES QUE ESTE VALOR ESTÉ EN ALGÚN LUGAR O ALGÚN PARÁMETRO.
		UUID defaultValue = UUIDHelper.getDefault();
		setId(defaultValue);
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	private void setUsuario(UsuarioEntity usuario) {
		this.usuario = ObjectHelper.getDefault(usuario, new UsuarioEntity());
	}

	private void setDefaultUsuario() {

		setUsuario(new UsuarioEntity());
	}
}
