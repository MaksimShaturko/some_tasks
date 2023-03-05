package io.ylab.shaturko;

import java.util.Scanner;

/**
 * Pell numbers
 */
public class Pell {
    private final static String ENTER_N = "Enter the number n >> ";
    private final static String PELL_NUMBER = "Pell number is: ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ENTER_N);
        byte n = scanner.nextByte();
        long pCurrent = 0;
        long pPrevious = 0;

        for (byte i = 0; i <= n; i ++) {
            if (i == 1) {
                pCurrent = 1;
                continue;
            }
            long pTemp = pCurrent;
            pCurrent = 2 * pCurrent + pPrevious;
            pPrevious = pTemp;
        }

        System.out.println(PELL_NUMBER + pCurrent);
    }
}
