package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class NewStringCalculatorTest {

    public NewStringCalculator newStringCalculator;

    @BeforeEach
    void setUp() {
        newStringCalculator = new NewStringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10"
//            "2 + 3 * 4 / 2:10",
//            "2 + 3 * 4 / 2:10"
    }, delimiter = ':' )
    void add(String target, int comparison) {
        int result = newStringCalculator.add(target);
        assertThat(result).isEqualTo(comparison);
    }

    @AfterEach
    void reSet() {
        newStringCalculator = null;
    }
}
