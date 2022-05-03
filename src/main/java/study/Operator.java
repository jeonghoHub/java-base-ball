package study;

import java.util.NoSuchElementException;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Stream;

public enum Operator {
    PLUS('+', (left, right) -> left + right),
    MINUS('-', (left, right) -> left - right),
    MULTIPLY('*', (left, right) -> left * right),
    DIVISION('/', (left, right) -> left / right);

    private final char operator;
    private final DoubleBinaryOperator doubleBinaryOperator;

    Operator(char operator, DoubleBinaryOperator doubleBinaryOperator) {
        this.operator = operator;
        this.doubleBinaryOperator = doubleBinaryOperator;
    }

    public static Operator findByOperator(char c) {
        return Stream.of(values())
                .filter(operator -> operator.operator == c)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public double apply(double left, double right) {
        if(right == 0) {
            throw new ArithmeticException("0으로는 나눌 수 없습니다");
        }
        return doubleBinaryOperator.applyAsDouble(left, right);
    }

}
