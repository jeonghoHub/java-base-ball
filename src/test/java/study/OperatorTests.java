package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OperatorTests {
    @ParameterizedTest
    @ValueSource(chars = {'a', ')', '|'})
    void 입력값이_사칙연산자가_아니라면_예외를_던진다(char c) {
        assertThatThrownBy(() -> {
            Operator operator = Operator.findByOperator(c);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @MethodSource("findByOperator")
    void 입력값이_사칙연산자라면_상수를_반환한다(char c, Operator expected) {
        Operator actual = Operator.findByOperator(c);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> findByOperator() {
        return Stream.of(
                arguments('+', Operator.PLUS),
                arguments('-', Operator.MINUS),
                arguments('*', Operator.MULTIPLY),
                arguments('/', Operator.DIVISION)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "+:2:2:4",
            "-:2:2:0",
            "*:2:2:4",
            "/:2:2:1"
    }, delimiter = ':')
    void 연산_테스트(char c, double left, double right, double expected) {
        Operator operator = Operator.findByOperator(c);

        double actual = operator.apply(left, right);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 숫자0_으로는_나눌수_없다() {
        assertThatThrownBy(() -> Operator.DIVISION.apply(2, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로는 나눌 수 없습니다");
    }
}
