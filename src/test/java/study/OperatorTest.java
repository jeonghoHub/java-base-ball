package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @ParameterizedTest
//    @ValueSource(strings = {"+","-","*","/"})
    @MethodSource("test")
    void 연산자에따른_값추출(String operatorStr, Operator operator) {
        //then
        assertThat(Operator.from(operatorStr)).isEqualTo(operator);
    }

    static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of("+",Operator.PLUS),
                Arguments.of("-",Operator.MINUS),
                Arguments.of("*",Operator.MUTIPLY),
                Arguments.of("/",Operator.DIVISION)
        );
    }

    @Test
    void 이넘테스트() {
        assertThat(Operator.PLUS.apply(10.0, 20.0)).isEqualTo(30);

    }
}
