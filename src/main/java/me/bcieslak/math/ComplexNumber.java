package me.bcieslak.math;

import java.io.Serializable;
import java.util.Objects;

public class ComplexNumber implements Serializable
{
    private double realValue;
    private double imaginaryValue;

    public ComplexNumber()
    {
        this.realValue = 0;
        this.imaginaryValue = 0;
    }

    public ComplexNumber(double realValue)
    {
        this.realValue = realValue;
        this.imaginaryValue = 0;
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
        else if(this.imaginaryValue > 0.0D) complexNumber.append("+").append(this.imaginaryValue);

        complexNumber.append("j)");

        return complexNumber.toString();
    }

    public ComplexNumber copy()
    {
        return new ComplexNumber(this.realValue, this.imaginaryValue);
    }
}
