package calculator.input;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

    public void validate(String input){
        if (input == null || input.isEmpty()){
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        if (input.startsWith("//")){
            if (!input.contains("\\n")){
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            String delimiter = input.substring(2,input.indexOf("\\n"));
            if (delimiter.length() != 1){
                throw new IllegalArgumentException("커스텀 구분자는 길이가 1이어야 합니다.");
            }
            if (Character.isDigit(delimiter.charAt(0))){
                throw new IllegalArgumentException("커스텀 구분자는 숫자를 사용할 수 없습니다.");
            }
            Character newDelimiter = input.charAt(2);
            delimiters.add(newDelimiter);
            input = input.substring(input.indexOf("\\n")+2);
        } else {
            char first = input.charAt(0);
            if (!Character.isDigit(first) && first != ',' && first != ':'){
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 입력은 구분자나 숫자로 시작하거나, 커스텀 구분자 형식이어야 합니다.");
            }
        }

        boolean hasDelimiter = input.chars().anyMatch(c -> delimiters.contains((char) c));
        if (!hasDelimiter){
            throw new IllegalArgumentException("입력값에 최소 1개의 구분자가 포함되어야 합니다.");
        }

        boolean hasNumber = input.chars().anyMatch(Character::isDigit);
        if (!hasNumber){
            throw new IllegalArgumentException("입력값에 최소 1개의 숫자가 포함되어야 합니다.");
        }

    }
}
