package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringCalculatorTest {
    @ParameterizedTest
    @MethodSource("calculate")
    void 계산_테스트(Expression expression, double expected) {
        // given
        StringCalculator sut = new StringCalculator();

        // when
        double actual = sut.calculate(expression);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> calculate() {
        return Stream.of(
                arguments(Expression.from("22+3-7*10/2"), 90),
                arguments(Expression.from("2+2"), 4),
                arguments(Expression.from("2 + 33 - 77777 * 10 / 2"), -388_710),
                arguments(Expression.from("2 + 312446-73223 * 170/2"), 20_334_125),
                arguments(Expression.from("3531"), 3531),
                arguments(Expression.from("0"), 0)
        );
    }
}

