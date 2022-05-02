package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
            "2 + 3 * 4 / 2 - 3:7",
            "2 + 3 * 4 / 2 - 3 + 20:27"
    }, delimiter = ':')
    void 문자열_계산(String expression, double target) {
    //todo 1.표현식이 들어오면 연산을 한다.

        double result = stringCalculator.calculate(expression);

        assertThat(result).isEqualTo(target);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:3",
            "2 + 3 * 4 / 2 - 3:4",
            "2 + 3 * 4 / 2 - 3 + 20:5"
    }, delimiter = ':')
    void 연산자_추출(String expression, int length) {
    //todo 1.주어진 표현식에서 연산자만 추출한다.

        String[] operand = stringCalculator.operatorExtraction(expression);

        assertThat(operand.length).isEqualTo(length);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:4",
            "2 + 3 * 4 / 2 - 3:5",
            "2 + 3 * 4 / 2 - 3 + 20:6"
    }, delimiter = ':')
    void 피연산자_추출(String expression, int length) {
    // todo 1.주어진 표현식에서 피연산자만 추출한다.

        String[] operand = stringCalculator.operandExtraction(expression);

        assertThat(operand.length).isEqualTo(length);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2 ++ 2+2",
            "+3+2+3",
            "2+3/+"
    })
    void 올바르지않은_표현식이들어오면_예외처리(String expression) {
        assertThatThrownBy(
                () -> stringCalculator.vaildation(expression)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
