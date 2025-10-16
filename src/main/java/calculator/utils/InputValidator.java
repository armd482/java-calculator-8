package calculator.utils;

import java.math.BigDecimal;
import java.util.Arrays;

public class InputValidator {
    private static final String POSITIVE_DECIMAL_PATTERN = "^(?!0+$)(?!0*\\.0+$)\\d*\\.?\\d+$";

    public static Boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static Boolean isPositiveNumber(String number) {
        if(number == null) {
            return false;
        }
        return number.matches(POSITIVE_DECIMAL_PATTERN);
    }

    public static Boolean isPositiveNumbers(String[] numbers) {
        return Arrays.stream(numbers).allMatch(InputValidator::isPositiveNumber);
    }
}
