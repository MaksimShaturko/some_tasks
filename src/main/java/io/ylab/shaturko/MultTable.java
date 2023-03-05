package io.ylab.shaturko;

/**
 * На вход ничего не подается, необходимо распечатать таблицу умножения чисел
 * от 1 до 9 включительно
 */
public class MultTable {
    private static final String AS_TABLE = "Display as a table";
    private static final String AS_COLUMN = "Display as a column as in the task terms";

    public static void main(String[] args) {
        System.out.println(AS_TABLE);
        for(int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d x %d\t", j, i);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(AS_COLUMN);
        for(int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " x " + j);
            }
        }

    }
}
