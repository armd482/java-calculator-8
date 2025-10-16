package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.utils.InputParser;
import calculator.utils.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void run() {
        String input = InputView.getNumbers();

        if (InputValidator.isEmpty(input)) {
            OutputView.displayInputError("값을 입력해주세요.");
            return;
        }

        InputParser parser = new InputParser(input);
        String[] numbers = parser.splitInput();

        if(!InputValidator.isPositiveNumbers(numbers)) {
            OutputView.displayInputError("0보다 큰 유효한 숫자들을 입력해주세요.");
            return;
        }

        CalculatorModel Calculator = new CalculatorModel(numbers);

        String result = Calculator.calculateSum();

        OutputView.displayResult(result);
    }
}
