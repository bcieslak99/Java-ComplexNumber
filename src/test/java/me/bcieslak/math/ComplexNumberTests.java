package me.bcieslak.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTests
{
    @TestFactory
    @DisplayName("Method should return string of complex number.")
    List<DynamicTest> methodShouldReturnStringOfComplexNumber()
    {
        LinkedList<DynamicTest> testsOfStrings = new LinkedList<>();


        Executable test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber();
            String expectedResult = "(0.0+0.0j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (0.0+0.0j)", test));


        test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(1.0D, 0.0D);
            String expectedResult = "(1.0+0.0j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (1.0+0.0j)", test));


        test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(0.0D, 1.0D);
            String expectedResult = "(0.0+1.0j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (0.0+1.0j)", test));


        test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(1.0D, -1.0D);
            String expectedResult = "(1.0-1.0j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (1.0-1.0j)", test));


        test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(-1.0D, -1.0D);
            String expectedResult = "(-1.0-1.0j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (-1.0-1.0j)", test));


        test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(-23.7D, 14.3D);
            String expectedResult = "(-23.7+14.3j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (-23.7+14.3j)", test));


        test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(12.78D, 93.83D);
            String expectedResult = "(12.78+93.83j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (12.78+93.83j)", test));


        test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(0.0D, -18.453D);
            String expectedResult = "(0.0-18.453j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (0.0-18.453j)", test));


        test = () ->
        {
            ComplexNumber complexNumber = new ComplexNumber(-18.453D, 0.0D);
            String expectedResult = "(-18.453+0.0j)";
            assertEquals(expectedResult, complexNumber.toString());
        };

        testsOfStrings.add(DynamicTest.dynamicTest("Method should return (-18.453+0.0j)", test));


        return testsOfStrings;
    }
}
