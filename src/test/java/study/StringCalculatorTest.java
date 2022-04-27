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

//    2 + 3 * 4 / 2 - 2 = 8
    @Test
    void 연산자_추출을_한다() {
        //1.피연산자와 연산자가 섞인 문자열 중 피연산자만을 추출하여 반환한다.
        //given
        String value = "2 + 3 * 4 / 2 - 2";

        //when
        String[] operands = sut.operatorExtractor(value);

        //then
        assertThat(operands).isEqualTo(new String[] {"+","*","/","-"});
    }

    @Test
    void 연산자_추출을_한다2() {
        //1.피연산자와 연산자가 섞인 문자열 중 피연산자만을 추출하여 반환한다.
        //given
        String value = "22+ 3 * 4 / 2-2 + 30";

        //when
        String[] operands = sut.operatorExtractor(value);

        //then
        assertThat(operands).isEqualTo(new String[] {"+","*","/","-","+"});
    }

    @Test
    void 연산자_추출을_한다3() {
        //1.피연산자와 연산자가 섞인 문자열 중 피연산자만을 추출하여 반환한다.
        //given
        String value = "20*20-2+3+3+4-5/2";

        //when
        String[] operands = sut.operatorExtractor(value);

        //then
        assertThat(operands).isEqualTo(new String[] {"*","-","+","+","+","-","/"});
    }

    @Test
    void 연산자_추출을_한다4() {
        //1.피연산자와 연산자가 섞인 문자열 중 피연산자만을 추출하여 반환한다.
        //given
        String value = "2+*3**20--2";

        //then
        assertThatThrownBy(
                () -> sut.operatorExtractor(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }






}
