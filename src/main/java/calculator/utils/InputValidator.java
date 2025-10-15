package calculator.utils;

import java.util.Arrays;

public class InputValidator {
    public Boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private  Boolean isPositiveNumber(String number) {
        try {
            int intValue = Integer.parseInt(number);
            return intValue > 0;
        } catch (NumberFormatException e) {
            try {
                double doubleValue = Double.parseDouble(number);
                return doubleValue > 0;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }

    public Boolean isPositiveNumbers(String[] numbers) {
        return Arrays.stream(numbers).allMatch(this::isPositiveNumber);
    }
}
