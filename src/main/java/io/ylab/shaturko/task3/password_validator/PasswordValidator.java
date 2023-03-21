package io.ylab.shaturko.task3.password_validator;

import io.ylab.shaturko.task3.password_validator.exceptions.WrongLoginException;
import io.ylab.shaturko.task3.password_validator.exceptions.WrongPasswordException;

public class PasswordValidator {
    private final static String REQUIRED = "[A-Za-z0-9_]+";
    private final static String WRONG_LOGIN = "Логин содержит недопустимые символы";
    private final static String TOO_LONG_LOGIN = "Логин слишком длинный";
    private final static String WRONG_PASSWORD = "Пароль содержит недопустимые символы";
    private final static String TOO_LONG_PASSWORD = "Пароль слишком длинный";
    private final static String PASSWORDS_NOT_MATCH = "Пароль и подтверждение не совпадают";

    public static boolean validate(String login, String password, String confirmPassword) {

        try {
            return validateLoginLength(login) && validateLogin(login)
                    && validatePasswordLength(password) && validatePassword(password)
                    && validateMatching(password, confirmPassword);

        } catch (WrongLoginException ex) {
            System.out.println(ex.getMessage());
        } catch (WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }


    private static boolean validateLogin(String login) throws WrongLoginException {
        if (login.matches(REQUIRED)) {
            return true;
        } else {
            throw new WrongLoginException(WRONG_LOGIN);
        }
    }

    private static boolean validateLoginLength(String login) throws WrongLoginException {
        if (login.length() < 20) {
            return true;
        } else {
            throw new WrongLoginException(TOO_LONG_LOGIN);
        }
    }

    private static boolean validatePassword(String password) throws WrongPasswordException {
        if (password.matches(REQUIRED)) {
            return true;
        } else {
            throw new WrongPasswordException(WRONG_PASSWORD);
        }
    }

    private static boolean validatePasswordLength(String password) throws WrongPasswordException {
        if (password.length() < 20) {
            return true;
        } else {
            throw new WrongPasswordException(TOO_LONG_PASSWORD);
        }
    }

    private static boolean validateMatching(String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) {
            return true;
        } else {
            throw new WrongPasswordException(PASSWORDS_NOT_MATCH);
        }
    }
}
