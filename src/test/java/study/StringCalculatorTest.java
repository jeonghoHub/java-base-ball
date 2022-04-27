package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }
//    + * ?
    @ParameterizedTest
    @CsvSource(value = "22 + 3 * 4 / 2")
    void 주어진_문자열에서_연산자_추출(String value) {
        String[] operand = value.replaceAll("\\s","").replaceAll("\\D", " ").split(" ");
        String[] operator = value.replaceAll("\\d\\s", "").split("");
        System.out.println(Arrays.toString(operator));
//        assertAll(
//                () -> assertThat(new String[] {"22","3","4","2"}).isEqualTo(operand),
//                () -> assertThat(new String[] {"+","*","/"}).isEqualTo(operator)
//        );

    }


    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "30+2 / 2 + 5 - 10 *2:22"}, delimiter = ':')
    void add(String value, int separator) {
        double result = stringCalculator.add(value);
        assertThat(result).isEqualTo(separator);
    }




    @AfterEach
    void reSet() {
        stringCalculator = null;
    }

}
