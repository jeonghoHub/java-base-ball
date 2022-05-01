package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.management.MonitorInfo;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {
    @ParameterizedTest
    @MethodSource("일치하는연산자_반환_메소드")
    void 연산자맞는_enum확인(String operator, Operator target) {
        Operator from = Operator.from(operator);
        assertThat(from).isEqualTo(target);
    }
    @ParameterizedTest
    @MethodSource("연산자별_연산_메소드")
    void 연산테스트(double left, double right, String operator, double target) {
        //given
        Operator from = Operator.from(operator);
        double result = from.apply(left, right);

        assertThat(result).isEqualTo(target);
    }


    private static Stream<Arguments> 일치하는연산자_반환_메소드() {
        return Stream.of(
            Arguments.of("+", Operator.PLUS),
            Arguments.of("-", Operator.MINUS),
            Arguments.of("*", Operator.MULTIPLY),
            Arguments.of("/", Operator.DIVISION)
        );
    }

    private static Stream<Arguments> 연산자별_연산_메소드() {
        return Stream.of(
                Arguments.of(10, 20, "+", 30),
                Arguments.of(20, 10, "-", 10),
                Arguments.of(10, 20, "*", 200),
                Arguments.of(20, 10, "/", 2)
        );
    }
}