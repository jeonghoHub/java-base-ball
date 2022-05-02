package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @MethodSource("test")
    void 연산자에_맞는_enum상수_반환(String target, Operator operator){
        assertThat(operator.getValue()).isEqualTo(target);
    }

    @ParameterizedTest
    @MethodSource("test1")
    void 연산자에_맞는_연산(double left, double right, Operator operator, double target){
        double result = operator.apply(left, right);

        assertThat(result).isEqualTo(target);
    }


    static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVISION)
        );
    }

    static Stream<Arguments> test1() {
        return Stream.of(
                Arguments.of(10,20,Operator.PLUS, 30),
                Arguments.of(50,20,Operator.MINUS, 30),
                Arguments.of(10,5,Operator.MULTIPLY, 50),
                Arguments.of(30,10,Operator.DIVISION, 3)
        );
    }
}
