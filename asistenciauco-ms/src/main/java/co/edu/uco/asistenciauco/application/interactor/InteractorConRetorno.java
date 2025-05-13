package co.edu.uco.asistenciauco.application.interactor;

public interface InteractorConRetorno<I, O> {

	O ejecutar(I dto);
}
