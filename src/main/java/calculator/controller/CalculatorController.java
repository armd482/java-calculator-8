package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.utils.InputParser;
import calculator.utils.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void run() {
        String input = InputView.getNumbers();

        InputParser parser = new InputParser(input);
        String[] numbers = parser.splitInput();

        if(!InputValidator.isPositiveNumbers(numbers)) {
            throw new IllegalArgumentException("양수만 입력해주세요.");
        }

        CalculatorModel calculator = new CalculatorModel(numbers);

        String result = calculator.calculateSum();

        OutputView.displayResult(result);
    }
}
