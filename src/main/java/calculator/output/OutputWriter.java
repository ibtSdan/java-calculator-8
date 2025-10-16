package calculator.output;

public record OutputWriter() {
    public void printResult(Integer result){
        System.out.println("결과 : "+result);
    }
}
