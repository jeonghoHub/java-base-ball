package study;

import java.util.function.DoubleBinaryOperator;
import java.util.stream.Stream;

enum Operator {
    PLUS("+", (left , right) -> left + right),
    MINUS("-", (left , right) -> left - right),
    MULTIPLY("*", (left , right) -> left * right),
    DIVISION("/", (left , right) -> left / right);

    private final String value;
    private final DoubleBinaryOperator doubleBinaryOperator;

    Operator(String value, DoubleBinaryOperator doubleBinaryOperator) {
        this.value = value;
        this.doubleBinaryOperator = doubleBinaryOperator;
    }

    public static Operator from(String target) {
        return Stream.of(values())
                .filter(operator -> operator.value.equals(target))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        /*
        * 서플라이어
        * 컨슈머 (input) ->
        * 프레디케이트
        * 펑션
        * */
    }

    double apply(double left, double right) {
        return doubleBinaryOperator.applyAsDouble(left, right);
    }

    public String getValue() {
        return value;
    }

}
