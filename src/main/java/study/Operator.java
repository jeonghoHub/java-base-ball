package study;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;
import java.util.function.ToDoubleBiFunction;

public enum Operator {
    PLUS("+", (left, right) -> left + right ),
    MINUS("-", (left, right) -> left - right),
    MUTIPLY("*", (left, right) -> left * right),
    DIVISION("/", (left, right) -> left / right);

    private final String value;
    private final ToDoubleBiFunction<Double, Double> biFunction;
    Operator(String value, ToDoubleBiFunction<Double, Double> biFunction) {

        this.value = value;
        this.biFunction = biFunction;
    }

    public static Operator from(String keyword) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.value.equals(keyword))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 값 입니다."));
    }

//    public double apply(double left, double right) {
//        return biFunction.applyAsDouble(left, right);
//    }


    public double apply(double left, double right) {
        return this.biFunction.applyAsDouble(left, right);
    }
}
