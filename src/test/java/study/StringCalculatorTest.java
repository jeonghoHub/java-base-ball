package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10",
            "2 + 3 * 4 / 2 - 5:5",
            "5 * 5 - 5 + 2:18"
    },delimiter = ':')
    void 연산테스트(String expression, int target) {
        //표현식이 들어오면 연산함.
        //given
        int result = stringCalculator.calculation(expression);

        //then
        assertThat(result).isEqualTo(target);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:3",
            "2 + 3 * 4 / 2 / 2/3/7+3:7",
    }, delimiter = ':')
    void 연산자추출(String expression, int target) {
        //1.주어진 표현식에서 연산자 추출

        //when
        String[] operator = expression.replaceAll("\\s","")
                    .replaceAll("\\d","")
                    .split("");

        //then
        assertThat(operator.length).isEqualTo(target);
    }

}

