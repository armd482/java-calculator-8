package calculator.controller;

import calculator.utils.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String input = inputView.getNumbers();

        InputValidator inputValidator = new InputValidator();

        if (inputValidator.isEmpty(input)) {
            outputView.displayInputError("값을 입력해주세요.");
            return;
        }

        /*split*/

        String[] numbers = {"123", "456"};

        if(!inputValidator.isPositiveNumbers(numbers)) {
            outputView.displayInputError("0보다 큰 유효한 숫자들을 입력해주세요");
            return;
        }


        outputView.displayResult(input);
    }
}
