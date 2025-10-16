package calculator;

import calculator.input.InputReader;
import calculator.input.InputValidator;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        InputValidator validator = new InputValidator();

        String input = reader.readInput();
        validator.validate(input);
        // 숫자 분리, list<Integer>
        // 계산, int? Long?
        // 출력

    }
}
