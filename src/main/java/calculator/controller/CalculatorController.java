package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        InputView inputView = new InputView();
        String numbers = inputView.getNumbers();

        OutputView outputView = new OutputView();
        outputView.displayResult(numbers);
    }
}
