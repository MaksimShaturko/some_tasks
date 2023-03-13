package io.ylab.shaturko.task2.complex_numbers.main;

import io.ylab.shaturko.task2.complex_numbers.ComplexNumber;
import io.ylab.shaturko.task2.complex_numbers.OperationsOnComplexNumbers;
import io.ylab.shaturko.task2.complex_numbers.impl.OperationsOnComplexNumbersImpl;

import java.util.Scanner;

public class Main {
    private final static String ENTER_REAL_PART1 = "Введите действительную часть комплексного числа 1 >> ";
    private final static String ENTER_IMAGINARY_PART1 = "Введите мнимую часть комплексного числа 1 >> ";
    private final static String ENTER_REAL_PART2 = "Введите действительную часть комплексного числа 2 >> ";
    private final static String ENTER_IMAGINARY_PART2 = "Введите мнимую часть комплексного числа 2 >> ";
    private final static String COMPLEX_NUMBER1 = "Complex Number 1 = ";
    private final static String COMPLEX_NUMBER2 = "Complex Number 2 = ";
    private final static String MODULUS1 = "modulus 1 = ";
    private final static String MODULUS2 = "modulus 2 = ";
    private final static String SUM_NUMBER = "sumNumber = ";
    private final static String SUBTRACTED_NUMBER = "subtractedNumber = ";
    private final static String MULTIPLIED_NUMBER = "multipliedNumber = ";

    public static void main(String[] args) {
        OperationsOnComplexNumbers operations = new OperationsOnComplexNumbersImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println(ENTER_REAL_PART1);
        double realPart1 = scanner.nextDouble();
        System.out.println(ENTER_IMAGINARY_PART1);
        double imaginaryPart1 = scanner.nextDouble();

        System.out.println(ENTER_REAL_PART2);
        double realPart2 = scanner.nextDouble();
        System.out.println(ENTER_IMAGINARY_PART2);
        double imaginaryPart2 = scanner.nextDouble();

        ComplexNumber number1 = createComplexNumber(realPart1, imaginaryPart1);
        ComplexNumber number2 = createComplexNumber(realPart2, imaginaryPart2);

        System.out.println(COMPLEX_NUMBER1 + number1);
        System.out.println(COMPLEX_NUMBER2 + number2);

        System.out.println(MODULUS1 + number1.getModulus());
        System.out.println(MODULUS2 + number2.getModulus());

        ComplexNumber sumNumber = operations.sum(number1, number2);
        System.out.println(SUM_NUMBER + sumNumber);

        ComplexNumber subtractedNumber = operations.subtract(number1, number2);
        System.out.println(SUBTRACTED_NUMBER + subtractedNumber);

        ComplexNumber multipliedNumber = operations.multiply(number1, number2);
        System.out.println(MULTIPLIED_NUMBER + multipliedNumber);

        scanner.close();
    }

    private static ComplexNumber createComplexNumber(double realPart, double imaginaryPart) {
        if (imaginaryPart == 0) {
            return new ComplexNumber(realPart);
        } else {
            return new ComplexNumber(realPart, imaginaryPart);
        }
    }

}
