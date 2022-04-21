package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        assertThat("1,2".split(",")).contains("1","2");
        assertThat("1".split(",")).contains("1");
    }

    @Test
    void subString() {
        String value = "\"(1,2)\"".substring(2,5);
        value = "\""+value+"\"";
        assertThat(value).contains("\"1,2\"");
    }

    @Test
    @DisplayName("입력밧 범위 밖일 경우 Exception 확인")
    void IndexOutOfBoundsException() throws Exception {
        String value = "abc";

        assertThatThrownBy(() -> value.charAt(value.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void setUpContains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setUpContains2(int ints) {
        assertTrue(numbers.contains(ints));
    }

    @ParameterizedTest
    @CsvSource(value = {})
    void test(int ints) {
        assertTrue(numbers.contains(ints));
    }

}
