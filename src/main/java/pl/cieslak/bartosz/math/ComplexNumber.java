package pl.cieslak.bartosz.math;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ComplexNumber implements Serializable
{
    private static final String ARGUMENT_IS_NULL_MESSAGE = "Argument can not be null";
    private static final String DIVIDE_BY_ZERO_MESSAGE = "/ by 0";
    private static final String LIST_HAS_NULL_ELEMENT_MESSAGE = "List has minimum one element which is null";
    private static final String LIST_IS_EMPTY_MESSAGE = "List is empty";
    public static final int MIN_ROUND_LEVEL = 0;
    public static final int MAX_ROUND_LEVEL = 10;

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

    public ComplexNumber(double realValue, double imaginaryValue, int roundLevel)
    {
        this.realValue = realValue;
        this.imaginaryValue = imaginaryValue;
        this.roundLevel = roundLevel;
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
        return new ComplexNumber(this.realValue, this.imaginaryValue, this.roundLevel);
    }

    public static ComplexNumber roundComplexNumber(ComplexNumber complexNumber, int roundLevel)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);

        if(roundLevel < MIN_ROUND_LEVEL) roundLevel = MIN_ROUND_LEVEL;
        else if(roundLevel > MAX_ROUND_LEVEL) roundLevel = MAX_ROUND_LEVEL;

        double multiplier = 1.0D;
        for(int i = 0; i < roundLevel; i++) multiplier *= 10.0D;

        ComplexNumber result = complexNumber.copy();

        double realValue = Math.round(result.getRealValue() * multiplier) / multiplier;
        double imaginaryValue = Math.round(result.getImaginaryValue() * multiplier) / multiplier;

        result.setValues(realValue, imaginaryValue);

        return result;
    }

    private static double roundValue(double value, int roundLevel)
    {
        if(roundLevel < MIN_ROUND_LEVEL) roundLevel = MIN_ROUND_LEVEL;
        else if(roundLevel > MAX_ROUND_LEVEL) roundLevel = MAX_ROUND_LEVEL;

        double multiplier = 1.0D;
        for(int i = 0; i < roundLevel; i++) multiplier *= 10.0D;

        return Math.round(value * multiplier) / multiplier;
    }

    public ComplexNumber add(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);

        double realValue = this.realValue + complexNumber.getRealValue();
        double imaginaryValue = this.imaginaryValue + complexNumber.getImaginaryValue();

        return ComplexNumber.roundComplexNumber(new ComplexNumber(realValue, imaginaryValue), this.roundLevel);
    }

    public ComplexNumber subtract(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);

        double realValue = this.realValue - complexNumber.getRealValue();
        double imaginaryValue = this.imaginaryValue - complexNumber.getImaginaryValue();

        return roundComplexNumber(new ComplexNumber(realValue, imaginaryValue), this.roundLevel);
    }

    public ComplexNumber multiply(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);

        double resultOfRealValue = this.realValue * complexNumber.getRealValue() + this.imaginaryValue *
                complexNumber.getImaginaryValue() * -1.0D;

        double resultOfImaginaryValue = this.realValue * complexNumber.getImaginaryValue() +
                this.imaginaryValue * complexNumber.getRealValue();

        return roundComplexNumber(new ComplexNumber(resultOfRealValue, resultOfImaginaryValue), this.roundLevel);
    }

    public ComplexNumber divide(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);

        if(complexNumber.equals(new ComplexNumber(0.0D, 0.0D)))
            throw new ArithmeticException(DIVIDE_BY_ZERO_MESSAGE);

        double denominator = Math.pow(complexNumber.getRealValue(), 2.0D) + Math.pow(complexNumber.getImaginaryValue(), 2.0D);

        double realValue = (this.getRealValue() * complexNumber.getRealValue() + this.getImaginaryValue() *
                complexNumber.getImaginaryValue()) / denominator;

        double imaginaryValue = (this.getImaginaryValue() * complexNumber.getRealValue() - this.getRealValue()
                * complexNumber.getImaginaryValue()) / denominator;

        return roundComplexNumber(new ComplexNumber(realValue, imaginaryValue), this.roundLevel);
    }

    public static ComplexNumber sum(List<ComplexNumber> listOfComplexNumbers)
    {
        if(listOfComplexNumbers == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);

        if(listOfComplexNumbers.size() < 1) throw new IllegalArgumentException(LIST_IS_EMPTY_MESSAGE);

        if(listOfComplexNumbers.stream().anyMatch(Objects::isNull))
            throw new NullPointerException(LIST_HAS_NULL_ELEMENT_MESSAGE);

        ComplexNumber result = new ComplexNumber();
        for(ComplexNumber value : listOfComplexNumbers) result = result.add(value);

        return roundComplexNumber(result, MAX_ROUND_LEVEL);
    }

    public ComplexNumber negation()
    {
        double realValue = this.realValue;
        double imaginaryValue = this.imaginaryValue;

        if(realValue != 0.0D) realValue = -realValue;
        if(imaginaryValue != 0.0D) imaginaryValue = -imaginaryValue;

        return roundComplexNumber(new ComplexNumber(realValue, imaginaryValue, this.roundLevel), this.roundLevel);
    }

    public static ComplexNumber negation(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);
        return complexNumber.negation();
    }

    public ComplexNumber conjugate()
    {
        double realValue = this.realValue;
        double imaginaryValue = this.imaginaryValue;

        if(imaginaryValue != 0.0D) imaginaryValue = -imaginaryValue;

        return roundComplexNumber(new ComplexNumber(realValue, imaginaryValue, this.roundLevel), this.roundLevel);
    }

    public static ComplexNumber conjugate(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);
        return complexNumber.conjugate();
    }

    public double modulus()
    {
        double result = Math.sqrt(Math.pow(this.realValue, 2.0D) + Math.pow(this.imaginaryValue, 2.0D));
        return roundValue(result, this.roundLevel);
    }

    public static double modulus(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);
        return complexNumber.modulus();
    }

    public ComplexNumber exponential()
    {
        double r = Math.exp(this.realValue);
        double realValue = r * Math.cos(this.imaginaryValue);
        double imaginaryValue = r * Math.sin(this.imaginaryValue);
        return ComplexNumber.roundComplexNumber(new ComplexNumber(realValue, imaginaryValue, this.roundLevel), this.roundLevel);
    }

    public static ComplexNumber exponential(ComplexNumber complexNumber)
    {
        if(complexNumber == null) throw new NullPointerException(ARGUMENT_IS_NULL_MESSAGE);
        return complexNumber.exponential();
    }
}
