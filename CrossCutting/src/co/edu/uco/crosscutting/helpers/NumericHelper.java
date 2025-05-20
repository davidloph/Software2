package co.edu.uco.crosscutting.helpers;

import java.math.BigDecimal;
import java.util.Random;

public class NumericHelper {
	
	public static final Integer ZERO = 0;
	
	private NumericHelper() {
    }

    public static boolean isGreater(final double a, final double b) {
        return a > b;
    }

    public static boolean isLess(final double a, final double b) {
        return a < b;
    }
    
    public static boolean isEqual(final double a, final double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            return false;
        }
        if (Double.isInfinite(a) || Double.isInfinite(b)) {
            return a == b;
        }
        return Math.abs(a - b) < 1e-9;
    }

    public static boolean isDifferent(final double a, final double b) {
        return !isEqual(a, b);
    }

    public static boolean isGreaterOrEqual(final double a, final double b) {
        return isGreater(a, b) || isEqual(a, b);
    }

    public static boolean isLessOrEqual(final double a, final double b) {
        return isLess(a, b) || isEqual(a, b);
    }

    public static boolean isBetweenNotInclude(final double a, final double range1, final double range2) {
        return isGreater(a, Math.min(range2, range1)) && isLess(a, Math.max(range2, range1));
    }

    public static boolean isBetweenInclude(final double a, final double range1, final double range2) {
        return isGreaterOrEqual(a, Math.min(range2, range1)) && isLessOrEqual(a, Math.max(range2, range1));
    }

    public static boolean isPositive(final double a) {
        return isGreaterOrEqual(a, 0);
    }

    public static boolean isNegative(final double a) {
        return isLess(a, 0);
    }
    
    public static final Integer generate() {
		Random random = new Random();
		return random.nextInt(10000);
	}
}
