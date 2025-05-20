package co.edu.uco.crosscutting.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateHelper {

	public static final String DEFAULT_LOCALDATE_STRING = "01-01-1900";
	
	private DateHelper() {
    }
	
	public static final String getDefaultAsString() {
		return DEFAULT_LOCALDATE_STRING;
	}

	public static final LocalDate getDefault() {
		return convertToLocalDate(DEFAULT_LOCALDATE_STRING);
	}
	
	public static final String getDefaultAsString(final LocalDate fecha) {
		return convertToString(fecha);
	}
	
	public static final LocalDate convertToLocalDate(final String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public static final LocalDate convertToLocalDateSQL(final String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public static final String convertToString(final LocalDate fecha) {
		return fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public static final String convertToStringSQL(final LocalDate fecha) {
		return fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public static final boolean isDefault(final LocalDate fecha) {
		return getDefaultAsString().compareTo(convertToString(fecha)) == 0;
	}
	
	public static final boolean isDefaultAsString(final String fecha) {
		return getDefaultAsString().compareTo(fecha) == 0;
	}
	
	public static boolean fechaConsistency(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate.parse(fecha, formatter); // Intenta parsear
            return true; // Si el parseo tiene éxito, la fecha es válida
        } catch (DateTimeParseException e) {
            return false; // Si lanza excepción, la fecha no es válida
        }
    }

}
