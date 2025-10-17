package calculator;

import calculator.calculation.Calculator;
import calculator.dto.Numbers;
import calculator.dto.Result;
import calculator.dto.UserInput;
import calculator.input.InputReader;
import calculator.input.InputValidator;
import calculator.output.OutputWriter;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        InputValidator validator = new InputValidator();
        Calculator calculator = new Calculator();
        OutputWriter writer = new OutputWriter();

        UserInput input = new UserInput(reader.readInput());
        Numbers numbers = new Numbers(validator.validate(input));
        Result result = new Result(calculator.sum(numbers));
        writer.printResult(result);
    }
}
