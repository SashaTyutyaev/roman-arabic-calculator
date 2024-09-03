package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculateArabic_Success() {
        String result = calculator.calculate("9 + 10", true);
        assertNotNull(result);
        assertEquals(result,"19");
    }

    @Test
    void calculateRoman_Success() {
        String result = calculator.calculate("X - IX", false);
        assertNotNull(result);
        assertEquals(result,"I");
    }

    @Test
    void calculateArabic_ThrowsException_WhenNumbersAreNotInteger() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("1.5 + 6", true));
    }

    @Test
    void calculateArabic_ThrowsException_WhenOperatorInvalid() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("5 ** 5", true));
    }

    @Test
    void calculateRoman_ThrowsException_WhenOperatorInvalid() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("V ** V", false));
    }

    @Test
    void calculateArabic_ThrowsException_WhenRomanNumber() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("5 + V", true));
    }

    @Test
    void calculateRoman_ThrowsException_WhenArabicNumber() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("5 + V", false));
    }

    @Test
    void calculateArabic_ThrowsException_WhenInputInvalid() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("1 +      ",true));
    }

    @Test
    void calculateRoman_ThrowsException_WhenInputInvalid() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("X + V + I",false));
    }

    @Test
    void calculateRoman_ThrowsException_WhenResultNegative() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("V - X", false));
    }

    @Test
    void calculateArabic_ThrowsException_WhenNumbersInvalid() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("15 + 1", true));
    }

    @Test
    void calculateRoman_ThrowsException_WhenNumbersInvalid() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("XV + V", false));
    }
}