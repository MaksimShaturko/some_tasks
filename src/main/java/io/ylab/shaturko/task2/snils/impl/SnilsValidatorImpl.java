package io.ylab.shaturko.task2.snils.impl;

import io.ylab.shaturko.task2.snils.SnilsValidator;

public class SnilsValidatorImpl implements SnilsValidator {
    private final static String WRONG = "Вы ввели некорректный СНИЛС";
    private final static String VALID = "СНИЛС валидный";
    private final static String INVALID = "СНИЛС неверный";

    @Override
    public boolean validate(String snils) {
        char[] chars = snils.toCharArray();
        if(!isDigits(chars) || !isValidNumberOfDigits(chars)) {
            System.out.println(WRONG);
            return false;
        } else {
            int controlNumber = Integer.parseInt(String.copyValueOf(chars, 9, 2));
            int sum = 0;
            int j = 9;
            for (int i = 0; i < chars.length - 2; i++) {
                if (i < 9) {
                    int x = Character.digit(chars[i], 10);
                    sum = sum + x * j--;
                }
            }
            int intToCheck = sum % 101;
            boolean isValid = intToCheck == controlNumber;
            if(isValid) {
                System.out.println(VALID);
                return true;
            } else {
                System.out.println(INVALID);
                return false;
            }
        }
    }

    /**
     * Проверка на цифры. Если в массиве есть символы, отличные от цифр, возвращает false
     * @param chars
     * @return Если все цифры - true.
     */
    private boolean isDigits(char[] chars) {
        for (char character : chars) {
                if (!Character.isDigit(character)) {
                    return false;
            }
        }
        return true;
    }

    /**
     * Проверка на количество цифр в номере СНИЛС
     * @param chars
     * @return
     */
    private boolean isValidNumberOfDigits(char[] chars) {
        return chars.length == 11;
    }
}
