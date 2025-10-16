package calculator.input;

import calculator.split.Splitter;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private Splitter splitter = new Splitter();
    List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

    public List<Integer> validate(String input){
        if (input == null || input.isEmpty()){
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        String cleanedInput = input.replaceAll("\\s+", "");

        if (cleanedInput.startsWith("//")){
            if (!cleanedInput.contains("\\n")){
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            String delimiter = cleanedInput.substring(2,cleanedInput.indexOf("\\n"));
            if (delimiter.length() != 1){
                throw new IllegalArgumentException("커스텀 구분자는 길이가 1이어야 합니다.");
            }
            if (Character.isDigit(delimiter.charAt(0))){
                throw new IllegalArgumentException("커스텀 구분자는 숫자를 사용할 수 없습니다.");
            }
            if (delimiter.charAt(0) == '-'){
                throw new IllegalArgumentException("커스텀 구분자는 - 를 사용할 수 없습니다.");
            }
            Character newDelimiter = cleanedInput.charAt(2);
            delimiters.add(newDelimiter);
            cleanedInput = cleanedInput.substring(cleanedInput.indexOf("\\n")+2);
        } else {
            char first = cleanedInput.charAt(0);
            if (!Character.isDigit(first) && first != ',' && first != ':'){
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 입력은 구분자나 양수로 시작하거나, 커스텀 구분자 형식이어야 합니다.");
            }
        }

        for (char c : cleanedInput.toCharArray()){
            if (!Character.isDigit(c) && !delimiters.contains(c) && !(c=='-')){
                throw new IllegalArgumentException("선언되지 않은 구분자가 존재합니다.");
            }
        }

        boolean hasNumber = cleanedInput.chars().anyMatch(Character::isDigit);
        if (!hasNumber){
            throw new IllegalArgumentException("입력값에 최소 1개의 숫자가 포함되어야 합니다.");
        }

        List<Integer> numbers = splitter.numberSplit(cleanedInput, delimiters);
        for (Integer n : numbers){
            if (n<=0){
                throw new IllegalArgumentException("숫자 입력은 양수만 가능합니다.");
            }
        }
        return numbers;
    }
}
