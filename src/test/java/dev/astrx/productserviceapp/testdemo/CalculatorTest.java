package dev.astrx.productserviceapp.testdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    @Test
    void whenAddTwoIntegersThenRightResultExpected() {
        // Arrange
        int a = 1;
        int b = 2;
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(3, result);
    }

    @Test
    void whenAddTwoIntegersThenWrongResultExpected() {
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 2;
        assertNotEquals(0, calculator.add(a, b));
    }

    @Test
    void whenDivideTwoIntegersThenRightResultExpected() {
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 2;
        int result = calculator.divide(a, b);
        assertEquals(5, result);
    }

    @Test
    void whenDivideByZeroThenWrongResultExpected() {
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 0;
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }
}
