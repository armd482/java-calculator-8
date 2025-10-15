package calculator.utils;

import java.math.BigDecimal;
import java.util.Arrays;

public class InputValidator {
    public Boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private  Boolean isPositiveNumber(String number) {
        try {
            BigDecimal value = new BigDecimal(number);
            return value.compareTo(BigDecimal.ZERO) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Boolean isPositiveNumbers(String[] numbers) {
        return Arrays.stream(numbers).allMatch(this::isPositiveNumber);
    }
}
