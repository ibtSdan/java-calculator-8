package calculator.split;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    public List<Integer> numberSplit(String cleanedInput, List<Character> delimiters){
        String regex = delimiters.stream()
                .map(d -> "\\"+d)
                .collect(Collectors.joining("|"));

        String[] tokens = cleanedInput.split(regex);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens){
            if (token.isEmpty()) continue;
            int number = Integer.parseInt(token);
            numbers.add(number);
        }

        return numbers;
    }
}
