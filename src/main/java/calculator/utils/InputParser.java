package calculator.utils;

import calculator.view.OutputView;

public class InputParser {
    private String input;
    private String separator = "[,:]";

    private void addSeparatorRegex(String customSeparator) {
        System.out.println("추가 커스텀 기본자: "+ customSeparator);
        if(separator.contains(customSeparator)) {
            OutputView.displayInputError("커스텀 기본자가 기본 구분자에 포함된 구분자입니다.");
        }

        if(customSeparator.equals(".")) {
            OutputView.displayInputError("설정할 수 없는 커스텀 기본자입니다.");
        }

        separator = "[,|" + customSeparator + "]";
    }

    public InputParser(String input) {
        if(input.startsWith("//")) {
            String[] inputParts= input.split("\\\\n", 2);

            if(inputParts.length != 2) {
                OutputView.displayInputError("잘못된 입력 형태입니다.");
                return;
            }

            String customSeparator = inputParts[0].substring(2);
            this.input = inputParts[1];
            addSeparatorRegex(customSeparator);
            return;
        }
        this.input = input;
    }

    public String[] splitInput() {
        return this.input.split(separator);
    }
}
