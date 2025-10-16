package calculator.view;

public class InputView {
    private static final String NUMBER_INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.";

    public static String getNumbers() {
        System.out.println(NUMBER_INPUT_MESSAGE);
        return camp.nextstep.edu.missionutils.Console.readLine().trim();
    }
}
