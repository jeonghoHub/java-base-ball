package study;

import java.util.function.DoubleBinaryOperator;
import java.util.stream.Stream;

enum Operator {
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right ),
    DIVISION("/", (left, right) -> left / right);

    String operator;
    DoubleBinaryOperator binaryOperator;

    Operator(String operator, DoubleBinaryOperator binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }
    static Operator from(String value) {
//        System.out.println(operator);
        return Stream.of(Operator.values())
                .filter(operator1 -> operator1.operator.equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
    double apply(double left, double right) {
        return binaryOperator.applyAsDouble(left, right);
    }
}
