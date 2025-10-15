package calculator.controller;

import calculator.utils.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        InputView inputView = new InputView();
        String input = inputView.getNumbers();

        InputValidator inputValidator = new InputValidator();

        if (inputValidator.isEmpty(input)) {
            return;
        }

        /*split*/

        String[] numbers = {"123", "456"};

        if(!inputValidator.isPositiveNumbers(numbers)) {
            return;
        }

        OutputView outputView = new OutputView();
        outputView.displayResult(input);
    }
}
