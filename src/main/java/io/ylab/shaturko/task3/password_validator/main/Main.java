package io.ylab.shaturko.task3.password_validator.main;

import io.ylab.shaturko.task3.password_validator.PasswordValidator;

public class Main {
    public static void main(String[] args) {
        boolean isValid1 = PasswordValidator
                .validate("Maks_34H_5", "12_3456_er45E", "12_3456_er45E");
        System.out.println(isValid1);

        boolean isValid2 = PasswordValidator
                .validate("Maks345656757fefk4543frfef", "123456_er", "123456_er");
        System.out.println(isValid2);

        boolean isValid3 = PasswordValidator
                .validate("Maks", "123456_er", "123456_er5");
        System.out.println(isValid3);


    }
}
