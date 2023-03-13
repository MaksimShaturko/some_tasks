package io.ylab.shaturko.task2.complex_numbers;

public class ComplexNumber {
    private double realNumber;
    private double imaginaryNumber;
    private double modulus;

    public ComplexNumber(double realNumber) {
        this.realNumber = realNumber;
        imaginaryNumber = 0;
    }

    public ComplexNumber(double realNumber, double imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    public double getRealNumber() {
        return realNumber;
    }

    public double getImaginaryNumber() {
        return imaginaryNumber;
    }

    public double getModulus() {
        if (modulus == 0) {
            modulus = calculateModulus(realNumber, imaginaryNumber);
        }
        return modulus;
    }

    @Override
    public String toString() {
        if (imaginaryNumber != 0) {
            if(imaginaryNumber > 0) {
                return realNumber + " +" + imaginaryNumber + "i";
            } else {
                return realNumber + " " + imaginaryNumber + "i";
            }
        } else {
            return Double.toString(realNumber);
        }
    }

    private double calculateModulus(double realNumber, double imaginaryNumber) {
        return Math.sqrt(Math.pow(realNumber, 2) + Math.pow(imaginaryNumber, 2));
    }
}
