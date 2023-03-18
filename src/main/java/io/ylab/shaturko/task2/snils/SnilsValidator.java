package io.ylab.shaturko.task2.snils;

public interface SnilsValidator {

    /**
     * Проверяет, что в строке содержится валидный номер СНИЛС
     * @param snils СНИЛС
     * @return результат проверки
     */
    boolean validate(String snils);

}
