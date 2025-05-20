package co.edu.uco.crosscutting.helpers;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHelper {

	public static final String EMPTY = "";
	public static final String ZERO = "0";
	public static final String ONLY_LETTERS_SPACES = "[A-Za-záÁéÉíÍóÓúÚñÑ ]*";

	private TextHelper() {
		
	}
	
	public static boolean patternIsValid(final String string, final String pattern) {
		return applyTrim(string).matches(concat("^", pattern, "$"));
	}
	
	public static boolean containsLettersAndSpaces(final String string) {
		return patternIsValid(string, ONLY_LETTERS_SPACES);
	}
	
	public static String concat(final String...strings) {
		var sb = new StringBuilder(EMPTY);
		
		for(String string : strings) {
			sb.append(getDefault(string));
		}
		return sb.toString();
	}
	
	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}
	
	public static String getDefault(final String string, final String defaultObject) {
		return ObjectHelper.getDefault(string, defaultObject);
	}
	
	public static String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}
	
	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}
	
	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}
	
	public static String applyTrim(final String string) {
		return getDefault(string).trim();
	}
	
	public static int len(final String string) {
		return applyTrim(string).length();
	}
	
	public static boolean lenIsValid(final String string, final int min, final int max) {
		return minLenIsValid(string, min) && maxLenIsValid(string, max);
	}
	
	public static boolean minLenIsValid(final String string, final int min) {
		return NumericHelper.isGreaterOrEqual(len(string), min);
	}
	
	public static boolean maxLenIsValid(final String string, final int max) {
		return NumericHelper.isLessOrEqual(len(string), max);
	}
	
	public static BigDecimal convertToBigDecimal(final String number) {
		return new BigDecimal(number);
	}
	
	public static Integer convertToInteger(final String number) {
		return Integer.parseInt(number);
	}
	
	public static boolean hasMaxTwoDecimals(final String number) {
		
		return number.replace(",",".").matches("\\+?\\-?\\d{1,2}(\\.\\d{0,2})?");
	}
	
	public static boolean hasNumber(final String string) {
		Pattern pattern= Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(string);
		return matcher.find();
	}
	
	public static boolean hasOnlyNumbers(final String string) {
		return string.matches("\\d+");
	}
	
	public static boolean numbersAndComma(final String string) {
		return string.replace(",", ".").matches("^(\\+?\\-?\\d+(\\.\\d+)?|)$");
	}
}

