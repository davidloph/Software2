package co.edu.uco.asistenciauco.application.interactor.usecase;

public interface UseCaseConRetorno <D, O> {

	O ejecutar(D domain);
}
