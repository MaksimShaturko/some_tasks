package io.ylab.shaturko.task2.sequences.impl;

import io.ylab.shaturko.task2.sequences.SequenceGenerator;

/**
 * Последовательности A - J заданы в виде нескольких значений следующим образом
 * A. 2,  4,  6,   8,  10...
 * B. 1,  3,  5,   7,   9...
 * C. 1,  4,  9,  16,  25...
 * D. 1,  8, 27,  64, 125...
 * E. 1, -1,  1,  -1,   1,  -1...
 * F. 1, -2,  3,  -4,   5,  -6...
 * G. 1, -4,  9, -16,  25....
 * H. 1,  0,  2,   0,   3,   0,  4....
 * I. 1,  2,  6,  24, 120, 720...
 * J. 1,  1,  2,   3,   5,   8, 13, 21…
 * Необходимо найти закономерности, по которым эти последовательности
 * сформированы и реализовать следующий интерфейс, каждый метод которого принимает число N
 * и выводит в консоль N элементов соответствующей
 * последовательности. Каждый элемент можно выводить с новой строки
 */
public class SequenceGeneratorImpl implements SequenceGenerator {
    private final static String WRONG = "Вы ввели отрицательное количество элементов либо 0";
    private final static String SEQUENCE_A = "Последовательность A:";
    private final static String SEQUENCE_B = "Последовательность B:";
    private final static String SEQUENCE_C = "Последовательность C:";
    private final static String SEQUENCE_D = "Последовательность D:";
    private final static String SEQUENCE_E = "Последовательность E:";
    private final static String SEQUENCE_F = "Последовательность F:";
    private final static String SEQUENCE_G = "Последовательность G:";
    private final static String SEQUENCE_H = "Последовательность H:";
    private final static String SEQUENCE_I = "Последовательность I:";
    private final static String SEQUENCE_J = "Последовательность J:";
    private final static String HYPHENS = "---------------------------";
    @Override
    public void a(int n) {
        System.out.println(SEQUENCE_A);
        generateSequence(n, 2, 1, false, 2);
        System.out.println(HYPHENS);
    }

    @Override
    public void b(int n) {
        System.out.println(SEQUENCE_B);
        generateSequence(n, 1, 1, false, 2);
        System.out.println(HYPHENS);
    }

    @Override
    public void c(int n) {
        System.out.println(SEQUENCE_C);
        generateSequence(n, 1, 2, false, 1);
        System.out.println(HYPHENS);
    }

    @Override
    public void d(int n) {
        System.out.println(SEQUENCE_D);
        generateSequence(n, 1, 3, false, 1);
        System.out.println(HYPHENS);
    }

    @Override
    public void e(int n) {
        System.out.println(SEQUENCE_E);
        generateSequence(n, 1, 0, true, 1);
        System.out.println(HYPHENS);
    }

    @Override
    public void f(int n) {
        System.out.println(SEQUENCE_F);
        generateSequence(n, 1, 1, true, 1);
        System.out.println(HYPHENS);
    }

    @Override
    public void g(int n) {
        System.out.println(SEQUENCE_G);
        generateSequence(n, 1, 2, true, 1);
        System.out.println(HYPHENS);
    }

    @Override
    public void h(int n) {
        System.out.println(SEQUENCE_H);
        addingThroughOne(n, 1, 1);
        System.out.println(HYPHENS);
    }

    @Override
    public void i(int n) {
        System.out.println(SEQUENCE_I);
        multiplyWithIncreasing(n, 1, false, 1);
        System.out.println(HYPHENS);
    }

    @Override
    public void j(int n) {
        System.out.println(SEQUENCE_J);
        addWithPrevious(n, 1);
        System.out.println(HYPHENS);
    }

    /**
     * Полу-универсальный метод. Думаю, можно сделать полностью универсальный. Но задачу делал первой,
     * впереди ждало еще четыре, поэтому не стал чрезмерно углубляться. В любом случае, условие задачи
     * выполнено
     * @param numberOfElements
     * @param startElement
     * @param degree - если есть необходимость возводить в степень в последовательности
     * @param signAlternating true - если в последовательности меняется знак
     * @param shift - Сдвиг числа. На сколько увеличиваем следующее по отношению к предыдущему
     */
    private void generateSequence(int numberOfElements, int startElement, int degree,
                                  boolean signAlternating, int shift) {
        int element;
        int sign = 1;
        int changeSign = setChangeSign(signAlternating);
        if (numberOfElements > 0) {
            for (int i = startElement; i <= numberOfElements * shift; i = i + shift) {
                element = sign * ((int) Math.pow(Math.abs(i), degree));
                System.out.println(element);
                sign = sign * changeSign;
            }
        } else {
            printWrongNumberOfElements();
        }
    }

    /**
     * Изменение числа через 1 шаг итерации
     * @param numberOfElements
     * @param startNumber
     * @param shift - Сдвиг числа. На сколько увеличиваем следующее по отношению к предыдущему
     */
    private void addingThroughOne(int numberOfElements, int startNumber, int shift) {
        int oneOrZero;
        int element = startNumber;
        int temp = 0;
        if (numberOfElements > 0) {
            for (int i = 1; i <= numberOfElements; i++) {
                System.out.println(element);
                oneOrZero = i % 2;
                if (oneOrZero != 0) {
                    temp = element + shift;
                    element = 0;
                } else {
                    element = temp;
                }
            }
        } else {
            printWrongNumberOfElements();
        }
    }

    /**
     * Последовательность с увеличивающимся множителем
     * @param numberOfElements
     * @param startElement
     * @param signAlternating
     * @param increaseMultiplierBy - на сколько увеличивать множитель в каждую итерацию
     */
    private void multiplyWithIncreasing(int numberOfElements, int startElement, boolean signAlternating,
                           int increaseMultiplierBy) {
        int element = startElement;
        int multiplier = 1;
        int changeSign = setChangeSign(signAlternating);
        if (numberOfElements > 0) {
            for (int i = 1; i <= numberOfElements; i++) {
                System.out.println(element);
                multiplier = (multiplier + increaseMultiplierBy) * changeSign;
                element = multiplier * element;
            }
        } else {
            printWrongNumberOfElements();
        }
    }

    /**
     * Каждое последующее число - это сумма предыдущих двух. Последовательность J
     * @param numberOfElements
     * @param startNumber
     */
    private void addWithPrevious(int numberOfElements, int startNumber) {
        int element = startNumber;
        int temp1 = 0;
        int temp2;
        if (numberOfElements > 0) {
            for (int i = 1; i <= numberOfElements; i++) {
                System.out.println(element);
                temp2 = temp1;
                temp1 = element;
                element = temp1 + temp2;
            }
        } else {
            printWrongNumberOfElements();
        }
    }

    /**
     * Устанавливаем значение -1, если в последовательности чередуется знак
     * @param signAlternating true - если чередуется знак
     * @return
     */
    private int setChangeSign(boolean signAlternating) {
        if (signAlternating) {
            return -1;
        } else {
            return 1;
        }
    }

    private void printWrongNumberOfElements() {
        System.out.println(WRONG);
    }


}
