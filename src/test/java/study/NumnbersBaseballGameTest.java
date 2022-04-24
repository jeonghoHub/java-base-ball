package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumnbersBaseballGameTest {
    NumbersBaseballGame numbersBaseballGame;

    @BeforeEach
    void setUp() {
        numbersBaseballGame = new NumbersBaseballGame();
    }




    @AfterEach
    void reSet() {
        numbersBaseballGame = null;
    }
}
