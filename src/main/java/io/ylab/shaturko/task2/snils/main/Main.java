package io.ylab.shaturko.task2.snils.main;

import io.ylab.shaturko.task2.snils.SnilsValidator;
import io.ylab.shaturko.task2.snils.impl.SnilsValidatorImpl;

import java.util.Scanner;

public class Main {
    private static final String ENTER_SNILS = "Введите СНИЛС >> ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ENTER_SNILS);
        String snils = scanner.nextLine();

        SnilsValidator validator = new SnilsValidatorImpl();
        validator.validate(snils);

        scanner.close();
    }
}
