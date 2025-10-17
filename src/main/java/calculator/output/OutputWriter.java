package calculator.output;

import calculator.dto.Result;

public record OutputWriter() {
    public void printResult(Result result){
        System.out.println("결과 : "+result.getResult());
    }
}
