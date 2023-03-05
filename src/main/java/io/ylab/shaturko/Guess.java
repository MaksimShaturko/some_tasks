package io.ylab.shaturko;

import java.util.Random;
import java.util.Scanner;

/**
 * Игра угадайка. При запуске программа загадывает число от 1 до 99 (включительно) и дает
 * пользователю 10 попыток отгадать. Далее пользователь начинает вводить число.
 * И тут возможен один из следующих вариантов:
 * - Пользователь отгадал число. В таком случае выводится строка
 * “Ты угадал с N попытки”, где N - номер текущей попытки пользователя
 * - Пользователь ввел число, меньше загаданного. В таком случае выводится сообщение
 * “Мое число меньше! У тебя осталось M попыток” где M - количество оставшихся попыток
 * - Пользователь ввел число, больше загаданного. В таком случае выводится сообщение
 * “Мое число больше! У тебя осталось M попыток” где M - количество оставшихся попыток
 * - У пользователя закончились попытки и число не было угадано. В таком случае выводится сообщение
 * “Ты ну угадал”
 */
public class Guess {
    private final static String INTRO_1 = "Я загадал число от 1 до 99. У тебя ";
    private final static String INTRO_2 = " попыток, чтобы отгадать";
    private final static String LESS_1 = "Мое число меньше, у тебя осталось ";
    private final static String LESS_2 = " попыток";
    private final static String MORE_1 = "Мое число больше, у тебя осталось ";
    private final static String MORE_2 = " попыток";
    private final static String GUESSED_1 = "Ты угадал с ";
    private final static String GUESSED_2 = " попытки";
    private final static String NOT_GUESSED = "Ты не угадал";
    private final static String ENTER_NUMBER = "Введи число >> ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = new Random().nextInt(99) + 1;
        int maxAttempts = 10;
        int attempt = 0;
        int i;
        System.out.println(INTRO_1 + maxAttempts + INTRO_2);

        for (i = maxAttempts; i > 0; i--) {

            System.out.println(ENTER_NUMBER);
            attempt = scanner.nextInt();

            if (attempt < numberToGuess) {
                System.out.println(MORE_1 + (i - 1) + MORE_2);
                continue;
            }

            if (attempt > numberToGuess) {
                System.out.println(LESS_1 + (i - 1) + LESS_2);
                continue;
            }
            break;
        }

        if(attempt == numberToGuess) {
            System.out.println(GUESSED_1 + (maxAttempts - i + 1) + GUESSED_2);
        } else {
            System.out.println(NOT_GUESSED);
        }
    }
}
