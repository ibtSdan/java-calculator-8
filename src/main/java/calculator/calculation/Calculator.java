package calculator.calculation;

import calculator.dto.Numbers;

import java.util.List;

public class Calculator {
    public Integer sum(Numbers numbers) {
        return numbers.getNumbers().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
