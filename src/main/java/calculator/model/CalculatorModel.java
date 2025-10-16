package calculator.model;

import java.math.BigDecimal;
import java.util.Arrays;

public class CalculatorModel {
    private final String[] numbers;

    public CalculatorModel(String[] numbers) {
        this.numbers = numbers;
    }

    public String calculateSum() {
        BigDecimal result = Arrays.stream(numbers).map(BigDecimal::new).reduce(BigDecimal.ZERO, BigDecimal::add);
        return String.valueOf(result);
    }
}
