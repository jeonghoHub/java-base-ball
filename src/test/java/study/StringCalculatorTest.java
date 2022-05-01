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
//    2 + 3 * 4 / 2
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 5 * 3 - 1:20",
            "2 + 5 * 3 - 1/2:10",
    },
            delimiter = ':')
    void 연산테스트(String expression, int target) {

        double result = stringCalculator.calculation(expression);

        assertThat(result).isEqualTo(target);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:3",
            "2+3*4/2-3-6-8:6",
            "2 * 3 * 4 - 2/3/6+7*3:7"
    }, delimiter = ':')
    void 연산자분리_테스트(String value, int target) {
//        1.주어진 값에서 연산자를 분리한다. ex) +,-,*,/
        String[] operator = stringCalculator.operatorExtraction(value);

        assertThat(operator.length).isEqualTo(target);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:4",
            "2+3*4/2-3-6-8:7",
            "2 * 3 * 4 - 2/3/6+7*3:8",
            "5*5/3+2/4+3:6",
//            "2 * 3 * 4 - 2/3/6+7*3:8",
//            "2 * 3 * 4 - 2/3/6+7*3:8"
    }, delimiter = ':')
    void 피연산자분리_테스트(String value, int target) {
//        1.주어진 값에서 피연산자를 분리한다. ex) 2,3,5
        String[] operator = stringCalculator.operandExtraction(value);

        assertThat(operator.length).isEqualTo(target);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2 + 3 * 4 // 2",
            "+2+3/",
            "2+3/3%3",
            "2+3+",
            "+++",
            "null"
    })
    void 표현식검증_성공케이스(String value) {
//        1.주어진 값이 옳지못한 값이라면 예외발생 성공
        assertThatThrownBy(
                () -> stringCalculator.vaildation(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
