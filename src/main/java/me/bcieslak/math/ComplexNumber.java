package me.bcieslak.math;

import java.io.Serializable;
import java.util.Objects;

public class ComplexNumber implements Serializable
{
    private static final String NULL_POINTER_EXCEPTION_MESSAGE = "Argument can not be null";
    private static final String DIVIDE_BY_ZERO_MESSAGE = "/ by 0";
    private static final int MIN_ROUND_LEVEL = 0;
    private static final int MAX_ROUND_LEVEL = 10;

    private double realValue;
    private double imaginaryValue;
    private int roundLevel = MAX_ROUND_LEVEL;

    public ComplexNumber()
    {
        this.realValue = 0.0D;
        this.imaginaryValue = 0.0D;
    }

    public ComplexNumber(double realValue)
    {
        this.realValue = realValue;
        this.imaginaryValue = 0.0D;
    }

    public ComplexNumber(double realValue, double imaginaryValue)
    {
        this.realValue = realValue;
        this.imaginaryValue = imaginaryValue;
    }

    public double getRealValue()
    {
        return this.realValue;
    }

    public void setRealValue(double realValue)
    {
        this.realValue = realValue;
    }

    public double getImaginaryValue()
    {
        return this.imaginaryValue;
    }

    public void setImaginaryValue(double imaginaryValue)
    {
        this.imaginaryValue = imaginaryValue;
    }

    public void setValues(double realValue, double imaginaryValue)
    {
        this.realValue = realValue;
        this.imaginaryValue = imaginaryValue;
    }

    public int getRoundLevel()
    {
        return this.roundLevel;
    }

    public void setRoundLevel(int roundLevel)
    {
        if(roundLevel < MIN_ROUND_LEVEL) this.roundLevel = MIN_ROUND_LEVEL;
        else this.roundLevel = Math.min(roundLevel, MAX_ROUND_LEVEL);
    }

    @Override
    public boolean equals(Object otherComplexNumber)
    {
        if (this == otherComplexNumber) return true;
        if (otherComplexNumber == null || getClass() != otherComplexNumber.getClass()) return false;
        ComplexNumber that = (ComplexNumber) otherComplexNumber;
        return Double.compare(that.realValue, realValue) == 0 && Double.compare(that.imaginaryValue, imaginaryValue) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(realValue, imaginaryValue);
    }

    @Override
    public String toString()
    {
        StringBuilder complexNumber = new StringBuilder();

        complexNumber.append("(");

        if(this.realValue == 0.0D) complexNumber.append("0.0");
        else complexNumber.append(this.realValue);

        if(this.imaginaryValue == 0.0D) complexNumber.append("+").append("0.0");
        else if(this.imaginaryValue < 0.0D) complexNumber.append("-").append(Math.abs(this.imaginaryValue));
        else complexNumber.append("+").append(this.imaginaryValue);

        complexNumber.append("j)");

        return complexNumber.toString();
    }

    public ComplexNumber copy()
    {
        return new ComplexNumber(this.realValue, this.imaginaryValue);
    }

    public static ComplexNumber roundComplexNumber(ComplexNumber complexNumber, int roundLevel)
    {
        if(complexNumber == null) throw new NullPointerException(NULL_POINTER_EXCEPTION_MESSAGE);

        ComplexNumber result = complexNumber.copy();

        if(roundLevel < MIN_ROUND_LEVEL) roundLevel = MIN_ROUND_LEVEL;
        else if(roundLevel > MAX_ROUND_LEVEL) roundLevel = MAX_ROUND_LEVEL;

        double multiplier = 1.0D;
        for(int i = 0; i < roundLevel; i++) multiplier *= 10.0D;

        double realValue = Math.round(result.getRealValue() * multiplier) / multiplier;
        double imaginaryValue = Math.round(result.getImaginaryValue() * multiplier) / multiplier;

        result.setValues(realValue, imaginaryValue);

        return result;
    }

    public ComplexNumber add(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(NULL_POINTER_EXCEPTION_MESSAGE);

        double realValue = this.realValue + complexNumber.getRealValue();
        double imaginaryValue = this.imaginaryValue + complexNumber.getImaginaryValue();

        return ComplexNumber.roundComplexNumber(new ComplexNumber(realValue, imaginaryValue), this.roundLevel);
    }

    public ComplexNumber subtract(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(NULL_POINTER_EXCEPTION_MESSAGE);

        double realValue = this.realValue - complexNumber.getRealValue();
        double imaginaryValue = this.imaginaryValue - complexNumber.getImaginaryValue();

        return roundComplexNumber(new ComplexNumber(realValue, imaginaryValue), this.roundLevel);
    }

    public ComplexNumber multiply(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(NULL_POINTER_EXCEPTION_MESSAGE);

        double resultOfRealValue = this.realValue * complexNumber.getRealValue() + this.imaginaryValue *
                complexNumber.getImaginaryValue() * -1;

        double resultOfImaginaryValue = this.realValue * complexNumber.getImaginaryValue() +
                this.imaginaryValue * complexNumber.getRealValue();

        return roundComplexNumber(new ComplexNumber(resultOfRealValue, resultOfImaginaryValue), this.roundLevel);
    }

    public ComplexNumber divide(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(NULL_POINTER_EXCEPTION_MESSAGE);

        if(complexNumber.equals(new ComplexNumber(0.0D, 0.0D)))
            throw new ArithmeticException(DIVIDE_BY_ZERO_MESSAGE);

        double denominator = Math.pow(complexNumber.getRealValue(), 2) + Math.pow(complexNumber.getImaginaryValue(), 2);

        double realValue = (this.getRealValue() * complexNumber.getRealValue() + this.getImaginaryValue() *
                complexNumber.getImaginaryValue()) / denominator;

        double imaginaryValue = (this.getImaginaryValue() * complexNumber.getRealValue() - this.getRealValue()
                * complexNumber.getImaginaryValue()) / denominator;

        return roundComplexNumber(new ComplexNumber(realValue, imaginaryValue), this.roundLevel);
    }
}
