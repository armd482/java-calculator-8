package calculator.utils;

import java.util.List;

public class InputParser {
    private final String input;
    private final List<String> DEFAULT_SEPARATOR = List.of(",", ":");

    private final String separatorRegex;

    private void validateCustomSeparator(String customSeparator) {
        if(DEFAULT_SEPARATOR.contains(customSeparator)) {
            throw new IllegalArgumentException("커스텀 기본자가 기본 구분자에 포함된 구분자입니다.");
        }

        if(customSeparator.equals(".")) {
            throw new IllegalArgumentException("설정할 수 없는 커스텀 기본자입니다.");
        }
    }

    private String getSeparatorRegex(String customSeparator) {
        String separators = String.join("", DEFAULT_SEPARATOR);
        if(customSeparator != null) {
            separators += customSeparator;
        }
        return "[" +  separators + "]";
    }

    public InputParser(String input) {
        if(input.startsWith("//")) {
            String[] inputParts= input.split("\\\\n", 2);

            if(inputParts.length != 2) {
                throw new IllegalArgumentException("잘못된 입력 형태입니다.");
            }

            String customSeparator = inputParts[0].substring(2);
            validateCustomSeparator(customSeparator);

            this.input = inputParts[1];
            this.separatorRegex = getSeparatorRegex(customSeparator);
            return;
        }

        this.input = input;
        this.separatorRegex = getSeparatorRegex(null);
    }

    public String[] splitInput() {
        return this.input.split(separatorRegex);
    }
}
