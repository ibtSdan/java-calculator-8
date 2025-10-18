package calculator.input;

import calculator.dto.UserInput;
import calculator.split.Splitter;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private Splitter splitter = new Splitter();
    List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

    public List<Integer> validate(UserInput input){
        String cleaned = input.getInput().replaceAll("\\s+","");

        if (cleaned.startsWith("//")){
            if (!cleaned.contains("\\n")){
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            String delimiter = cleaned.substring(2,cleaned.indexOf("\\n"));
            if (delimiter.length() != 1){
                throw new IllegalArgumentException("커스텀 구분자는 길이가 1이어야 합니다.");
            }
            if (Character.isDigit(delimiter.charAt(0))){
                throw new IllegalArgumentException("커스텀 구분자는 숫자를 사용할 수 없습니다.");
            }
            if (delimiter.charAt(0) == '-'){
                throw new IllegalArgumentException("커스텀 구분자는 - 를 사용할 수 없습니다.");
            }
            Character newDelimiter = cleaned.charAt(2);
            delimiters.add(newDelimiter);
            cleaned = cleaned.substring(cleaned.indexOf("\\n")+2);
        } else {
            char first = cleaned.charAt(0);
            if (!Character.isDigit(first) && first != ',' && first != ':'){
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 입력은 구분자나 양수로 시작하거나, 커스텀 구분자 형식이어야 합니다.");
            }
        }

        for (char c : cleaned.toCharArray()){
            if (!Character.isDigit(c) && !delimiters.contains(c) && !(c=='-')){
                throw new IllegalArgumentException("선언되지 않은 구분자가 존재합니다.");
            }
        }

        boolean hasNumber = cleaned.chars().anyMatch(Character::isDigit);
        if (!hasNumber){
            throw new IllegalArgumentException("입력값에 최소 1개의 숫자가 포함되어야 합니다.");
        }

        List<Integer> numbers = splitter.splitAndParse(cleaned, delimiters);
        for (Integer n : numbers){
            if (n<=0) throw new IllegalArgumentException("숫자 입력은 양수만 가능합니다.");
        }
        return numbers;
    }
}
