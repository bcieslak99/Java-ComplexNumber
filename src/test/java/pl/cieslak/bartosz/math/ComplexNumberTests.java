package pl.cieslak.bartosz.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTests
{
    @TestFactory
    @DisplayName("Method should return string of complex number")
    List<DynamicTest> methodShouldReturnStringOfComplexNumber()
    {
        final LinkedList<DynamicTest> TESTS_OF_STRINGS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber();
            final String EXPECTED_RESULT = "(0.0+0.0j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (0.0+0.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(1.0D, 0.0D);
            final String EXPECTED_RESULT = "(1.0+0.0j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (1.0+0.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(0.0D, 1.0D);
            final String EXPECTED_RESULT = "(0.0+1.0j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (0.0+1.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(1.0D, -1.0D);
            final String EXPECTED_RESULT = "(1.0-1.0j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (1.0-1.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-1.0D, -1.0D);
            final String EXPECTED_RESULT = "(-1.0-1.0j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (-1.0-1.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-23.7D, 14.3D);
            final String EXPECTED_RESULT = "(-23.7+14.3j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (-23.7+14.3j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(12.78D, 93.83D);
            final String EXPECTED_RESULT = "(12.78+93.83j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (12.78+93.83j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(0.0D, -18.453D);
            final String EXPECTED_RESULT = "(0.0-18.453j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (0.0-18.453j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-18.453D, 0.0D);
            final String EXPECTED_RESULT = "(-18.453+0.0j)";
            assertEquals(EXPECTED_RESULT, COMPLEX_NUMBER.toString());
        };

        TESTS_OF_STRINGS.addLast(DynamicTest.dynamicTest("Method should return (-18.453+0.0j)", test));


        return TESTS_OF_STRINGS;
    }

    @Test
    @DisplayName("Rounding method should throw NullPointerException")
    void roundingMethodShouldThrowException()
    {
        final ComplexNumber COMPLEX_NUMBER = null;
        assertThrows(NullPointerException.class, () -> ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, 0));
    }

    @Test
    @DisplayName("Rounding method should not throw exception")
    void roundingMethodShouldNotThrowException()
    {
        final ComplexNumber COMPLEX_NUMBER = new ComplexNumber();
        Assertions.assertDoesNotThrow(() -> ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, 0));
    }

    @TestFactory
    @DisplayName("Method should round complex number")
    List<DynamicTest> methodShouldRoundComplexNumber()
    {
        final LinkedList<DynamicTest> ROUNDING_TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(3.2D, 9.8D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(3.0D, 10.0D);
            final int ROUND_LEVEL = 0;
            COMPLEX_NUMBER.setRoundLevel(ROUND_LEVEL);
            final ComplexNumber RESULT = ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, COMPLEX_NUMBER.getRoundLevel());
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        ROUNDING_TESTS.addLast(DynamicTest.dynamicTest("Method should return complex number which should be equal (3.0+10.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(3.21D, 9.89D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(3.2D, 9.9D);
            final int ROUND_LEVEL = 1;
            COMPLEX_NUMBER.setRoundLevel(ROUND_LEVEL);
            final ComplexNumber RESULT = ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, COMPLEX_NUMBER.getRoundLevel());
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        ROUNDING_TESTS.addLast(DynamicTest.dynamicTest("Method should return complex number which should be equal (3.2+9.9j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(12.32524D, -36.91413214D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(12.33D, -36.91D);
            final int ROUND_LEVEL = 2;
            COMPLEX_NUMBER.setRoundLevel(ROUND_LEVEL);
            final ComplexNumber RESULT = ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, COMPLEX_NUMBER.getRoundLevel());
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        ROUNDING_TESTS.addLast(DynamicTest.dynamicTest("Method should return complex number which should be equal (12.33-36.91j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-3.323213213524D, 15.9142131416214D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-3.323213214D, 15.914213142D);
            final int ROUND_LEVEL = 9;
            COMPLEX_NUMBER.setRoundLevel(ROUND_LEVEL);
            final ComplexNumber RESULT = ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, COMPLEX_NUMBER.getRoundLevel());
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        ROUNDING_TESTS.addLast(DynamicTest.dynamicTest("Method should return complex number which should be equal (-3.323213214+15.914213142j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(8.323243234232433213524D, -1.91421356787696734416214D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(8.3232432342D, -1.9142135679D);
            final int ROUND_LEVEL = 10;
            COMPLEX_NUMBER.setRoundLevel(ROUND_LEVEL);
            final ComplexNumber RESULT = ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, COMPLEX_NUMBER.getRoundLevel());
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        ROUNDING_TESTS.addLast(DynamicTest.dynamicTest("Method should return complex number which should be equal (8.3232432342-1.9142135679j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(2.323243234232433213524D, -8.91421356787696734416214D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(2.3232432342D, -8.9142135679D);
            final int ROUND_LEVEL = 15;
            final ComplexNumber RESULT = ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, ROUND_LEVEL);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        ROUNDING_TESTS.addLast(DynamicTest.dynamicTest("Method should return complex number which should be equal (2.3232432342-8.9142135679j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(11.3487623497D, -14.8247732649D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(11.0D, -15.0D);
            final int ROUND_LEVEL = -2321;
            final ComplexNumber RESULT = ComplexNumber.roundComplexNumber(COMPLEX_NUMBER, ROUND_LEVEL);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        ROUNDING_TESTS.addLast(DynamicTest.dynamicTest("Method should return complex number which should be equal (11.0-15.0j)", test));


        return ROUNDING_TESTS;
    }

    @Test
    @DisplayName("Add method should throw NullPointerException")
    void addMethodShouldThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber();
            final ComplexNumber SECOND_COMPLEX_NUMBER = null;
            FIRST_COMPLEX_NUMBER.add(SECOND_COMPLEX_NUMBER);
        };

        assertThrows(NullPointerException.class, TEST);
    }

    @Test
    @DisplayName("Add method should not throw exception")
    void addMethodShouldNotThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber();
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber();
            FIRST_COMPLEX_NUMBER.add(SECOND_COMPLEX_NUMBER);
        };

        assertDoesNotThrow(TEST);
    }

    @TestFactory
    @DisplayName("Method should add two complex numbers")
    List<DynamicTest> methodShouldAddTwoComplexNumbers()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(-12.3D, -3.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(-8.7D, -4.6D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-21.0D, -7.6D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.add(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-21.0-7.6j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.add(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (0.0+0.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(8.5D, 4.3D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(2.5D, 3.7D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(11.0D, 8.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.add(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (11.0+8.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(-8.5D, -4.3D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(2.5D, 3.8D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-6.0D, -0.5D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.add(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-6.0-0.5j)", test));


        return TESTS;
    }

    @Test
    @DisplayName("Subtract method should throw NullPointerException")
    void subtractMethodShouldThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber();
            final ComplexNumber SECOND_COMPLEX_NUMBER = null;
            FIRST_COMPLEX_NUMBER.subtract(SECOND_COMPLEX_NUMBER);
        };

        assertThrows(NullPointerException.class, TEST);
    }

    @Test
    @DisplayName("Subtract method should not throw exception")
    void subtractMethodShouldNotThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber();
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber();
            FIRST_COMPLEX_NUMBER.subtract(SECOND_COMPLEX_NUMBER);
        };

        assertDoesNotThrow(TEST);
    }

    @TestFactory
    @DisplayName("Method should subtract two complex numbers")
    List<DynamicTest> methodShouldSubtractTwoComplexNumbers()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(-12.3D, -3.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(-8.3D, -4.5D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-4.0D, 1.5D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.subtract(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-21.0-7.6j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.subtract(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (0.0+0.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(8.5D, 4.5D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(2.5D, 3.5D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(6.0D, 1.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.subtract(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (6.0+1.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(-8.5D, -4.3D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(2.5D, 3.8D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-11.0D, -8.1D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.subtract(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-11.0-8.1j)", test));


        return TESTS;
    }

    @Test
    @DisplayName("Multiply method should throw NullPointerException")
    void multiplyMethodShouldThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber();
            final ComplexNumber SECOND_COMPLEX_NUMBER = null;
            FIRST_COMPLEX_NUMBER.multiply(SECOND_COMPLEX_NUMBER);
        };

        assertThrows(NullPointerException.class, TEST);
    }

    @Test
    @DisplayName("Multiply method should not throw exception")
    void multiplyMethodShouldNotThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(3.14D, 12.534D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(-42.24D, 94.23D);
            FIRST_COMPLEX_NUMBER.multiply(SECOND_COMPLEX_NUMBER);
        };

        assertDoesNotThrow(TEST);
    }

    @TestFactory
    @DisplayName("Method should multiply two complex numbers")
    List<DynamicTest> methodShouldMultiplyTwoComplexNumbers()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(3.0D, 12.5D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.multiply(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (0.0+0.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(2.0D, 5.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(3.0D, -2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(16.0D, 11.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.multiply(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (16.0+11.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(8.0D, 6.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(1.0D, 0.5D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(5.0D, 10.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.multiply(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (5.0+10.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(-12.0D, 3.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(0.5D, -2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(0.0D, 25.5D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.multiply(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (0.0+25.5j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(12.0D, -4.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(-0.5D, -2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-14.0D, -22.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.multiply(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-14.0-22.5j)", test));


        return TESTS;
    }

    @TestFactory
    @DisplayName("Divide method should throw exception")
    List<DynamicTest> divideMethodShouldThrowException()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber();
            final ComplexNumber SECOND_COMPLEX_NUMBER = null;
            assertThrows(NullPointerException.class, () -> FIRST_COMPLEX_NUMBER.divide(SECOND_COMPLEX_NUMBER));
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should throw NullPointerException", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(12.4D, -8.345D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber();
            assertThrows(ArithmeticException.class, () -> FIRST_COMPLEX_NUMBER.divide(SECOND_COMPLEX_NUMBER));
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should throw ArithmeticException", test));


        return TESTS;
    }

    @Test
    @DisplayName("Divide method should not throw exception")
    void divideMethodShouldNotThrowException()
    {
        final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(10.0D, 1.0D);
        final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(1.0D, 1.0D);
        Assertions.assertDoesNotThrow(() -> FIRST_COMPLEX_NUMBER.divide(SECOND_COMPLEX_NUMBER));
    }

    @TestFactory
    @DisplayName("Method should divide two complex numbers")
    List<DynamicTest> methodShouldDivideTwoComplexNumbers()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(5.0D, -1.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(3.0D, 2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(1.0D, -1.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.divide(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (1.0-1.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(10.0D, 5.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(1.0D, 2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(4.0D, -3.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.divide(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (4.0-3.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(0.0D, 15.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(3.0D, -1.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-1.5D, 4.5D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.divide(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-1.5-4.5j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(5.0D, 0.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(2.0D, 4.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(0.5D, -1.0D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.divide(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (0.5-1.0j)", test));


        test = () ->
        {
            final ComplexNumber FIRST_COMPLEX_NUMBER = new ComplexNumber(9.0D, 5.0D);
            final ComplexNumber SECOND_COMPLEX_NUMBER = new ComplexNumber(0.0D, 2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(2.5D, -4.5D);
            final ComplexNumber RESULT = FIRST_COMPLEX_NUMBER.divide(SECOND_COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (2.5-4.5j)", test));


        return TESTS;
    }

    @TestFactory
    @DisplayName("Sum method should throw exception")
    List<DynamicTest> sumMethodShouldThrowException()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final LinkedList<ComplexNumber> LIST_OF_COMPLEX_NUMBERS = null;
            assertThrows(NullPointerException.class, () -> ComplexNumber.sum(LIST_OF_COMPLEX_NUMBERS));
        };

        TESTS.addLast(DynamicTest.dynamicTest("Sum method should throw NullPointerException", test));


        test = () ->
        {
            final LinkedList<ComplexNumber> LIST_OF_COMPLEX_NUMBERS = new LinkedList<>();
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber());
            LIST_OF_COMPLEX_NUMBERS.addLast(null);
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber());
            assertThrows(NullPointerException.class, () -> ComplexNumber.sum(LIST_OF_COMPLEX_NUMBERS));
        };

        TESTS.addLast(DynamicTest.dynamicTest("Sum method should throw NullPointerException", test));


        test = () ->
        {
            final LinkedList<ComplexNumber> LIST_OF_COMPLEX_NUMBERS = new LinkedList<>();
            assertThrows(IllegalArgumentException.class, () -> ComplexNumber.sum(LIST_OF_COMPLEX_NUMBERS));
        };

        TESTS.addLast(DynamicTest.dynamicTest("Sum method should throw IllegalArgumentException", test));


        return TESTS;
    }

    @Test
    @DisplayName("Sum method should not throw exception")
    void sumMethodShouldNotThrowException()
    {
        final LinkedList<ComplexNumber> LIST_OF_COMPLEX_NUMBERS = new LinkedList<>();
        LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber());
        LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber());
        Assertions.assertDoesNotThrow(() -> ComplexNumber.sum(LIST_OF_COMPLEX_NUMBERS));
    }

    @TestFactory
    @DisplayName("Method sum(List<ComplexNumber> listOfComplexNumbers) should return new object with sum of complex numbers")
    public List<DynamicTest> methodShouldReturnNewObjectWithSumOfComplexNumbers()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final LinkedList<ComplexNumber> LIST_OF_COMPLEX_NUMBERS = new LinkedList<>();
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(1.0D, 1.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(3.0D, 5.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(-7.0D, 12.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(10.0D, -4.0D));
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(7.0D, 14.0D);
            final ComplexNumber RESULT = ComplexNumber.sum(LIST_OF_COMPLEX_NUMBERS);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (5.0+14.0j)", test));


        test = () ->
        {
            final LinkedList<ComplexNumber> LIST_OF_COMPLEX_NUMBERS = new LinkedList<>();
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(13.0D, -8.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(-7.0D, 4.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(2.0D, -12.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(-12.0D, 10.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(3.0D, 7.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(-7.0D, 1.0D));
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-8.0D, 2.0D);
            final ComplexNumber RESULT = ComplexNumber.sum(LIST_OF_COMPLEX_NUMBERS);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-8.0+2.0j)", test));


        test = () ->
        {
            final LinkedList<ComplexNumber> LIST_OF_COMPLEX_NUMBERS = new LinkedList<>();
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(6.0D, -4.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(8.0D, 12.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(-10.0D, -7.0D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(-4.0D, -1.0D));
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber RESULT = ComplexNumber.sum(LIST_OF_COMPLEX_NUMBERS);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (0.0+0.0j)", test));


        test = () ->
        {
            final LinkedList<ComplexNumber> LIST_OF_COMPLEX_NUMBERS = new LinkedList<>();
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(2.5D, -8.3D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(-1.25D, 2.7D));
            LIST_OF_COMPLEX_NUMBERS.addLast(new ComplexNumber(3.0D, 1.1D));
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(4.25D, -4.5D);
            final ComplexNumber RESULT = ComplexNumber.sum(LIST_OF_COMPLEX_NUMBERS);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (4.25-4.5j)", test));


        return TESTS;
    }

    @Test
    @DisplayName("Negation method should throw NullPointerException")
    void negationMethodShouldThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = null;
            ComplexNumber.negation(COMPLEX_NUMBER);
        };

        assertThrows(NullPointerException.class, TEST);
    }

    @Test
    @DisplayName("Method should not throw exception")
    void negationMethodShouldNotThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(3.0D, -2.2D);
            ComplexNumber.negation(COMPLEX_NUMBER);
        };

        assertDoesNotThrow(TEST);
    }

    @TestFactory
    @DisplayName("Method should return negation of complex number")
    public List<DynamicTest> methodShouldReturnNegationOfComplexNumber()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(3.0D, 1.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-3.0D, -1.0D);
            final ComplexNumber RESULT = ComplexNumber.negation(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-3.0-1.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-8.0D, -2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(8.0D, 2.0D);
            final ComplexNumber RESULT = ComplexNumber.negation(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-8.0-2.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-2.5D, 4.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(2.5D, -4.0D);
            final ComplexNumber RESULT = ComplexNumber.negation(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (2.5-4.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(2.5D, -4.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-2.5D, 4.0D);
            final ComplexNumber RESULT = ComplexNumber.negation(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-2.5+4.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(3.0D);
            final ComplexNumber EXPECTED_NUMBER = new ComplexNumber(-3.0D, 0.0D);
            final ComplexNumber RESULT = ComplexNumber.negation(COMPLEX_NUMBER);
            assertEquals(EXPECTED_NUMBER, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-3.0+0.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber();
            final ComplexNumber EXPECTED_NUMBER = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber RESULT = ComplexNumber.negation(COMPLEX_NUMBER);
            assertEquals(EXPECTED_NUMBER, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (0.0+0.0j)", test));


        return TESTS;
    }

    @Test
    @DisplayName("Conjugate method should throw NullPointerException")
    void conjugateMethodShouldThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = null;
            ComplexNumber.conjugate(COMPLEX_NUMBER);
        };

        assertThrows(NullPointerException.class, TEST);
    }

    @Test
    @DisplayName("Conjugate method should not throw exception")
    void conjugateMethodShouldNotThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-12.3D, 9.72D);
            ComplexNumber.conjugate(COMPLEX_NUMBER);
        };

        assertDoesNotThrow(TEST);
    }

    @TestFactory
    @DisplayName("Method should return conjugate of complex number")
    public List<DynamicTest> methodShouldReturnConjugateOfComplexNumber()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(1.0D, 3.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(1.0D, -3.0D);
            final ComplexNumber RESULT = ComplexNumber.conjugate(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (1.0-3.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(1.0D, -3.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(1.0D, 3.0D);
            final ComplexNumber RESULT = ComplexNumber.conjugate(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (1.0+3.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-6.0D, 2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-6.0D, -2.0D);
            final ComplexNumber RESULT = ComplexNumber.conjugate(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-6.0-2.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-6.0D, -2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-6.0D, 2.0D);
            final ComplexNumber RESULT = ComplexNumber.conjugate(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-6.0+2.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-6.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-6.0D, 0.0D);
            final ComplexNumber RESULT = ComplexNumber.conjugate(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (-6.0+0.0j)", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber();
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(0.0D, 0.0D);
            final ComplexNumber RESULT = ComplexNumber.conjugate(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return (0.0+0.0j)", test));


        return TESTS;
    }

    @Test
    @DisplayName("Modulus method should throw NullPointerException")
    void modulusMethodShouldThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = null;
            ComplexNumber.modulus(COMPLEX_NUMBER);
        };

        assertThrows(NullPointerException.class, TEST);
    }

    @Test
    @DisplayName("Modulus method should not throw exception")
    void modulusMethodShouldNotThrowException()
    {
        final Executable TEST = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(3.12D, -89.7D);
            ComplexNumber.modulus(complexNumber);
        };

        assertDoesNotThrow(TEST);
    }

    @TestFactory
    @DisplayName("Method should return modulus of complex number")
    public List<DynamicTest> methodShouldReturnModulusOfComplexNumber()
    {
        final LinkedList<DynamicTest> TESTS = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(3.0D, -4.0D);
            final double EXPECTED_RESULT = 5.0D;
            final double RESULT = ComplexNumber.modulus(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return 5.0", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-3.0D, -4.0D);
            final double EXPECTED_RESULT = 5.0D;
            final double RESULT = ComplexNumber.modulus(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return 5.0", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(0.0D, 0.0D);
            final double EXPECTED_RESULT = 0.0D;
            final double RESULT = ComplexNumber.modulus(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TESTS.addLast(DynamicTest.dynamicTest("Method should return 0.0", test));


        return TESTS;
    }

    @Test
    @DisplayName("Exponential method should throw NullPointerException")
    void exponentialMethodShouldThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = null;
            ComplexNumber.exponential(COMPLEX_NUMBER);
        };

        assertThrows(NullPointerException.class, TEST);
    }

    @Test
    @DisplayName("Exponential method should not throw NullPointerException")
    void exponentialMethodShouldNotThrowException()
    {
        final Executable TEST = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(3.74D, 12.3D);
            ComplexNumber.exponential(COMPLEX_NUMBER);
        };

        assertDoesNotThrow(TEST);
    }

    @TestFactory
    @DisplayName("Method should return exponential of complex number")
    public List<DynamicTest> methodShouldReturnExponential()
    {
        final LinkedList<DynamicTest> TEST = new LinkedList<>();


        Executable test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(2.0D, 3.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-7.3151100949D, 1.0427436562D);
            final ComplexNumber RESULT = ComplexNumber.exponential(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TEST.addLast(DynamicTest.dynamicTest("Method should return exponential of complex number", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(4.0D, -3.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-54.0517588611D, -7.7048913727D);
            final ComplexNumber RESULT = ComplexNumber.exponential(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TEST.addLast(DynamicTest.dynamicTest("Method should return exponential of complex number", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-5.0D, 2.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(-0.0028039753D, 0.0061267979D);
            final ComplexNumber RESULT = ComplexNumber.exponential(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TEST.addLast(DynamicTest.dynamicTest("Method should return exponential of complex number", test));


        test = () ->
        {
            final ComplexNumber COMPLEX_NUMBER = new ComplexNumber(-2.0D, -7.0D);
            final ComplexNumber EXPECTED_RESULT = new ComplexNumber(0.1020295751D, -0.0889134674D);
            final ComplexNumber RESULT = ComplexNumber.exponential(COMPLEX_NUMBER);
            assertEquals(EXPECTED_RESULT, RESULT);
        };

        TEST.addLast(DynamicTest.dynamicTest("Method should return exponential of complex number", test));


        return TEST;
    }
}
