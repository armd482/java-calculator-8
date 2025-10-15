package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {
    InputView inputView = new InputView();

    public void run() {
        String numbers = inputView.getNumbers();
        System.out.println("입력 값:"+numbers);
    }
}
