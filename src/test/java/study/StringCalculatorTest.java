package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10",
            "5 + 5 * 4 / 2:20",
            "6 + 6 / 3:4"
    }, delimiter = ':')
    void input(String expr, int expected) {
        int result = stringCalculator.calculate(expr);
        assertThat(result).isEqualTo(expected);
    }






    @AfterEach
    void reSet() {
        stringCalculator = null;
    }
}
