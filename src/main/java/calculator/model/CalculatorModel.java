package calculator.model;

import java.math.BigDecimal;
import java.util.Arrays;

public record CalculatorModel(String[] numbers) {

    public String calculateSum() {
        BigDecimal result = Arrays.stream(numbers).map(BigDecimal::new).reduce(BigDecimal.ZERO, BigDecimal::add);
        return String.valueOf(result);
    }
}
