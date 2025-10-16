package calculator.calculation;

import java.util.List;

public class Calculator {
    public Integer sum(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
