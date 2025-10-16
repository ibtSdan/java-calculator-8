package calculator;

import calculator.calculation.Calculator;
import calculator.input.InputReader;
import calculator.input.InputValidator;
import calculator.output.OutputWriter;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        InputValidator validator = new InputValidator();
        Calculator calculator = new Calculator();
        OutputWriter writer = new OutputWriter();

        String input = reader.readInput();
        List<Integer> numbers = validator.validate(input);
        Integer result = calculator.sum(numbers);
        writer.printResult(result);
    }
}
