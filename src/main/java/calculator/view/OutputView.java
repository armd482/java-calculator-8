package calculator.view;

public class OutputView {
    public static void displayResult(String result) {
        System.out.println("결과 : " + result);
    }

    public static void displayInputError(String error) {
        throw new IllegalArgumentException(error);
    }
}
