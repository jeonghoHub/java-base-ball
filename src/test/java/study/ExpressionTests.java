package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ExpressionTests {
    @ParameterizedTest
    @ValueSource(strings = {
            "22+3-7*10/2",
            "2 + 33 - 77777 * 10 / 2",
            "2 + 312446-73223 * 170/2",
            "35317851025",
            "0",
    })
    void 정상적인_수식이_입력되면_예외가_발생하지_않는다(String expr) {
        assertThatCode(() -> Expression.from(expr))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "-22+3-7*10/",
            "2 ++ 33 0-- 77777 * 10 / 2",
            "+2 + 312446-73223 * 170/2",
            "35317851025+",
            "0/",
            "/",
    })
    void 비정상적인_수식이_입력되면_예외가_발생한다(String expr) {
        assertThatThrownBy(() -> Expression.from(expr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "22+3-7*10/2 : 22+3-7*10/2",
            "2 + 33 - 77777 * 10 / 2 : 2+33-77777*10/2",
            "2 + 312446-73223 * 170/2 : 2+312446-73223*170/2",
            "35317851025 : 35317851025",
            "0 : 0",
    }, delimiterString = " : ")
    void 수식을_반환한다(String expr, String expected) {
        // given
        Expression expression = Expression.from(expr);

        // when
        String actual = expression.get();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 같은_수식을_갖는다면_인스턴스는_동등해야한다() {
        assertThat(Expression.from("22+3-7*10/2"))
                .isEqualTo(Expression.from("22+3-7*10/2"));
    }

    @Test
    void 같은_수식을_갖는다면_해시코드는_동일해야한다() {
        assertThat(Expression.from("22+3-7*10/2").hashCode())
                .isEqualTo(Expression.from("22+3-7*10/2").hashCode());
    }
}
