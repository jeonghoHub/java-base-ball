package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

public class StringExtractorTest {

    @ParameterizedTest
    @ValueSource(strings = {"2+3+5+6"})
    void 옳은값을_넣으면_인스턴스생성(String expression) {
        assertThatCode(
                () -> new StringExtractor(expression)
        ).doesNotThrowAnyException();
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"2+3+5+6+"})
    void 옳지않은_값넣을시_예외발생(String expression) {
        assertThatThrownBy(
                () -> new StringExtractor(expression)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:3",
            "2 + 3 * 4 / 2 / 2/3/7+3:7",
            "222:0",
            "222+2:1",
    }, delimiter = ':')
    void 연산자추출(String expression, int target) {
        // todo 1.주어진 표현식에서 연산자 추출

        StringExtractor stringExtractor = new StringExtractor(expression);
        Queue<Character> operator = stringExtractor.getOperator();

        //then
        assertThat(operator.size()).isEqualTo(target);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:4",
            "2 + 3 * 4 / 2 - 3:5",
            "2 + 3 * 4 / 2 - 3 + 20:6"
    }, delimiter = ':')
    void 피연산자_추출(String expression, int length) {
        // todo 1.주어진 표현식에서 피연산자만 추출한다.

        StringExtractor stringExtractor = new StringExtractor(expression);
        Queue<Double> operand = stringExtractor.getOperand();

        assertThat(operand.size()).isEqualTo(length);
    }

}
