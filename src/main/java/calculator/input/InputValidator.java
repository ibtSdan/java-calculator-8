package calculator.input;

public class InputValidator {
    public void validate(String input){
        if (input.startsWith("//")){
            if (!input.contains("\\n")){
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            // 올바른 커스텀 구분자 형식일 때 나머지 검사 (길이, 구분자)
        } else {
            char first = input.charAt(0);
            if (!Character.isDigit(first) && first != ',' && first != ':'){
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 입력은 구분자나 숫자로 시작하거나, 커스텀 구분자 형식이어야 합니다.");
            }
            // 정상 입력일 때 나머지 검사 (양수, 구분자)
        }
    }
}
