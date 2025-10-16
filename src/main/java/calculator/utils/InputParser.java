package calculator.utils;

public class InputParser {
    private static final String PARSER_REGEX = "[,:]";

    public static String[] splitInput(String input) {
        return input.split(PARSER_REGEX);
    }
}
