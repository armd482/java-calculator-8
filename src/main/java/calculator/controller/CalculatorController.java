package calculator.controller;

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

        String[] numbers = InputParser.splitInput(input);

        if(!InputValidator.isPositiveNumbers(numbers)) {
            OutputView.displayInputError("0보다 큰 유효한 숫자들을 입력해주세요.");
            return;
        }

        OutputView.displayResult(input);
    }
}
