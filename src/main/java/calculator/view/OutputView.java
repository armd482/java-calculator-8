package calculator.view;

public class OutputView {
    public void displayResult(String result) {
        System.out.println("결과 : " + result);
    }

    public void displayInputError(String error) {
        throw new IllegalArgumentException(error);
    }
}
