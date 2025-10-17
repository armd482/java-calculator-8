package calculator.utils;

import java.util.List;
import java.util.regex.Pattern;

public class InputParser {
    private final String input;
    private final String separatorRegex;

    private final List<String> DEFAULT_SEPARATOR = List.of(",", ":");

    private void validateCustomSeparator(String customSeparator) {
        if(DEFAULT_SEPARATOR.contains(customSeparator)) {
            throw new IllegalArgumentException("커스텀 구분자가 기본 구분자와 중복됩니다.");
        }

        if(customSeparator.matches(".*[0-9.]")) {
            throw new IllegalArgumentException("설정할 수 없는 커스텀 구분자입니다.");
        }
    }

    private String getSeparatorRegex(String customSeparator) {
        String separators = String.join("", DEFAULT_SEPARATOR);
        if(customSeparator != null) {
            separators += customSeparator;
        }
        return "[" +  Pattern.quote(separators) + "]";
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
        if(input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요");
        }
        return this.input.split(separatorRegex);
    }
}
