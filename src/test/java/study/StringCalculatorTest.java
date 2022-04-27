package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }
//    + * ?
    @ParameterizedTest
    @CsvSource(value = "22 + 3 * 4 / 2")
    void 주어진_문자열에서_연산자와_피연산자_추출(String value) {
        String[] operand = value.replaceAll("[\\s]","").replaceAll("[^\\d]", " ").split(" ");
        String[] operator = value.replaceAll("[\\s\\d]", "").split("");
        
//        System.out.println(operand);
        System.out.println(Arrays.toString(operand));
        System.out.println(Arrays.toString(operator));

    }


    @ParameterizedTest
    @CsvSource(value = "2 + 3 * 4 / 2:10", delimiter = ':')
    void add(String value, int separator) {
        int result = stringCalculator.add();
        assertThat(result).isEqualTo(separator);
    }




    @AfterEach
    void reSet() {
        stringCalculator = null;
    }

}
