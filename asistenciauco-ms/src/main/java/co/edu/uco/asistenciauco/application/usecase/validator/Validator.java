package co.edu.uco.asistenciauco.application.usecase.validator;

public interface Validator<I, O> {

	O validate(I data);
}
