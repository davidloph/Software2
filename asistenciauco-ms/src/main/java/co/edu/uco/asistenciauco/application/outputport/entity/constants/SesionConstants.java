package co.edu.uco.asistenciauco.application.outputport.entity.constants;

import java.time.LocalDateTime;

public class SesionConstants {

	public static final String TABLE_SESION = "Sesion";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_GRUPO = "grupo_id";
	public static final String COLUMN_FECHA_HORA = "fechaHora";
	public static final LocalDateTime COLUMN_FECHA_LIMITE = LocalDateTime.now().plusDays(3);

	private SesionConstants() {
	}
}
