package io.ylab.shaturko;

import java.util.Scanner;

/**
 * Программе передается 3 параметра: количество строк, количество столбцов, произвольный символ.
 * Необходимо вывести вывести фигуру, состоящую из заданного списка строк и заданного
 * количества столбцов, и каждый элемент в которой равен указанному символу.
 */
public class Stars {
    private final static String ENTER_RAWS = "Enter the number of raws >> ";
    private final static String ENTER_COLUMNS = "Enter the number of columns >> ";
    private final static String ENTER_SYMBOL = "Enter a symbol the figure will consist of >> ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ENTER_RAWS);
        int height = scanner.nextInt();
        System.out.println();

        System.out.print(ENTER_COLUMNS);
        int width = scanner.nextInt();
        System.out.println();
        scanner.nextLine();

        System.out.print(ENTER_SYMBOL);
        String symbol = scanner.nextLine();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
