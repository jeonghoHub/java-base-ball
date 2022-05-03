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
            "2 + 3 * 4 / 2 - 3 + 20:27",
//            " :0"
    }, delimiter = ':')
    void 문자열_계산(String expression, double target) {
    //todo 1.표현식이 들어오면 연산을 한다.
        StringExtractor stringExtractor = new StringExtractor(expression);
        double result = stringCalculator.calculate(stringExtractor);

        assertThat(result).isEqualTo(target);
    }


}

