package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator sut;

    @BeforeEach
    void setUp() {
        sut = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value =
                        {"false: 2 + 2 * 5 / 2 - 2:8",
                         "false: 5 + 5 + 5 + 5 * 2:40",
//                         "false: 10/ 2*5 + 2 - 2:10",
//                         "false: 30- 10 / 2:15",
                         "true: 2 + 2 * 5 / 2-- 2:8",
                         "true: :2",
                         "true: null:9",
                         "true: 12+12++:3",
                         "true: +12+:2",
                         "true: +12+:2",
                         "true: -12-:2",
                         "true: /123-^-12+:2",
                         "true: mmm123--+^^:2",
                         "true: ?????:2",
                         "true: ?,1223,..123..32:2",
                         "true: 후?212++5#$@ㅋ:2",
                         "true: mㅇ+-2@!#?므둫212null:2",
                        },
            delimiter = ':')
    void 연산테스트(boolean abnormal, String expr, double expected) {
        if(abnormal) {
            assertThatThrownBy(
                    () -> sut.calculate(expr)
            ).isInstanceOf(IllegalArgumentException.class);
        } else {
            assertThat(sut.calculate(expr)).isEqualTo(expected);
        }
    }


}
