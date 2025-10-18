package calculator.split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    public List<Integer> splitAndParse(String cleaned, List<Character> delimiters){
        List<String> tokens = splitByDelimiters(cleaned, delimiters);
        return parseToNumbers(tokens);
    }

    private List<String> splitByDelimiters (String cleaned, List<Character> delimiters){
        String regex = delimiters.stream()
                .map(d -> "\\"+d)
                .collect(Collectors.joining("|"));

        return Arrays.stream(cleaned.split(regex))
                .filter(token -> !token.isEmpty())
                .toList();
    }

    private List<Integer> parseToNumbers(List<String> tokens){
        return tokens.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
