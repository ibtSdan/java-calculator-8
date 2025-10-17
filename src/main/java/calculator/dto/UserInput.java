package calculator.dto;

public class UserInput {
    private final String input;

    public UserInput(String input) {
        if (input==null || input.isEmpty()){
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
