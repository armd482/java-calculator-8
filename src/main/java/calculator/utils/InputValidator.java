package calculator.utils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern POSITIVE_DECIMAL_PATTERN = Pattern.compile("^(?!0+$)(?!0*\\.0+$)\\d*\\.?\\d+$");

    public static Boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static Boolean isPositiveNumber(String number) {
        if(number == null) {
            return false;
        }
        return POSITIVE_DECIMAL_PATTERN.matcher(number).matches();
    }

    public static Boolean isPositiveNumbers(String[] numbers) {
        return Arrays.stream(numbers).allMatch(InputValidator::isPositiveNumber);
    }
}
