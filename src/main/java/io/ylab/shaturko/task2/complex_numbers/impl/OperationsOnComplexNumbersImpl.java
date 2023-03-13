package io.ylab.shaturko.task2.complex_numbers.impl;

import io.ylab.shaturko.task2.complex_numbers.ComplexNumber;
import io.ylab.shaturko.task2.complex_numbers.OperationsOnComplexNumbers;

public class OperationsOnComplexNumbersImpl implements OperationsOnComplexNumbers {
    private double realNumber;
    private double imaginaryNumber;

    @Override
    public ComplexNumber sum(ComplexNumber number1, ComplexNumber number2) {
        realNumber = number1.getRealNumber() + number2.getRealNumber();
        imaginaryNumber = number1.getImaginaryNumber() + number2.getImaginaryNumber();

        return new ComplexNumber(realNumber, imaginaryNumber);
    }

    @Override
    public ComplexNumber subtract(ComplexNumber number1, ComplexNumber number2) {
        realNumber = number1.getRealNumber() - number2.getRealNumber();
        imaginaryNumber = number1.getImaginaryNumber() - number2.getImaginaryNumber();

        return new ComplexNumber(realNumber, imaginaryNumber);
    }

    @Override
    public ComplexNumber multiply(ComplexNumber number1, ComplexNumber number2) {
        double realNumber1 = number1.getRealNumber();
        double imaginaryNumber1 = number1.getImaginaryNumber();
        double realNumber2 = number2.getRealNumber();
        double imaginaryNumber2 = number2.getImaginaryNumber();

        double realNumberNew = realNumber1 * realNumber2 - imaginaryNumber1 * imaginaryNumber2;
        double imaginaryNumberNew = realNumber1 * imaginaryNumber2 + realNumber2 * imaginaryNumber1;

        return new ComplexNumber(realNumberNew, imaginaryNumberNew);
    }

}
