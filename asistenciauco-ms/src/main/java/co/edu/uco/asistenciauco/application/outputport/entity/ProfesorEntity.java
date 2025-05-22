package co.edu.uco.asistenciauco.application.outputport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.application.outputport.entity.constants.ProfesorConstants;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
@Table(name = ProfesorConstants.TABLE_PROFESOR)
public final class ProfesorEntity extends UsuarioEntity{
	@Id
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = ProfesorConstants.COLUMN_ID)
	private UUID id;
	@ManyToOne
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
    @JoinColumn(name = ProfesorConstants.COLUMN_TIPO_IDENTIFICACION)
	private TipoIdentificacionEntity tipoIdentificacion;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = ProfesorConstants.COLUMN_NUMERO_IDENTIFICACION)
	private String numeroIdentificacion;
	//TODO: CUIDADO CON DEJAR QUEMADO EL LITERAL (PONERLO EN CONSTANTS)
	@Column(name = ProfesorConstants.COLUMN_NOMBRES_COMPLETOS)
	private String nombresCompletos;
}
