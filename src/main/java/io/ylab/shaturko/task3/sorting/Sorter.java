package io.ylab.shaturko.task3.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Сортировка происходит таким образом:
 * Первый раз данные берутся из стартового сгенерированного файла data.txt
 * Далее в процессе сортировки используются только два промежуточных файла tempFile1.txt и tempFile2.txt и
 * результирующий файл result.txt.
 *
 * Файл не делю на небольшие участки для их сортировки в оперативной памяти.
 * Целиком файл от прогона к прогону делится на два промежуточных и объединяется снова в результирующий.
 * От прогона к прогону снчала делю/объединияю единичные элементы, затем пары, затем четверки, восьмерки и т.д.
 * Все как по алгоритму.
 *
 * Никаких сортировок из библиотек, никаких промежуточных массивов. Показываю внешнюю сортировку слиянием
 * в чистом виде только с использованием файлов практически без использовния ОЗУ (представим, что свободной ОЗУ
 * вообще нет, а отсортировать надо).
 *
 */
public class Sorter {
    private int numberOfLines = 0;

    public File sortFile(File dataFile) throws IOException {
        File tempFile1 = new File("src/main/resources/tempFile1.txt");
        File tempFile2 = new File("src/main/resources/tempFile2.txt");

        // Первый прогон делаю в отдельном методе и получаю количество строк/чисел в файле
        // Далее исползую это значение для расчета количества циклов в проходе, количества проходов,
        // длины серий (четверки. восьмерки и т.д.), остатка
        numberOfLines = firstDivideAndCountNumberOfLines(dataFile, tempFile1, tempFile2);

        // Объединяю единичные элементы
        File resultFile = merge(tempFile1, tempFile2, 1);

        // Далее от двоек и дальше до предела сначала делю, затем объединяю, делю объединяю и т.д.
        for (int i = 2; i <= (int) (Math.log10(numberOfLines) / Math.log10(2) + 1); i++) {
            divide(resultFile, tempFile1, tempFile2, i);
            resultFile = merge(tempFile1, tempFile2, i);
        }

        return resultFile;
    }

    /**
     * Общий цикл for по количеству необходиых циклов, который рассчитывается от длины серии
     * Далее два цикла. Внешний и внутренний.
     * Внешний цикл для прохода по элементам (единице, двйке, четверке, восьмерке... - по серии) первого файла.
     * Внутренний цикл для прохода по серии второго файла.
     * Все записи в результирующий файл происходят во внутрененм цикле, поэтому его итерацию мы делаем вручную
     * после успешной записи нужного элемента из второго файла в результирующий
     * @param tempFile1
     * @param tempFile2
     * @param numberOfSeries
     * @return
     * @throws FileNotFoundException
     */
    private File merge(File tempFile1, File tempFile2, int numberOfSeries) throws FileNotFoundException {
        File resultFile = new File("src/main/resources/result.txt");
        Scanner scanner1 = new Scanner(tempFile1);
        Scanner scanner2 = new Scanner(tempFile2);
        PrintWriter printWriter = new PrintWriter(resultFile);
        int seriesLength = (int) Math.pow(2, numberOfSeries - 1);

        int numberOfFullCycles = numberOfLines / seriesLength / 2;
        int remainder = numberOfLines - numberOfFullCycles * seriesLength * 2;
        if((remainder - seriesLength) > 0) {
            numberOfFullCycles = numberOfFullCycles + 1;
        }

        for (int cycle = 0; cycle < numberOfFullCycles; cycle++) {

            int s2 = 0;
            // Используется для пропуска взятия следующего элемента из второго файла.
            // Ставится true, если после сравнения был взят элемент первого файла.
            // Нужно выйти во внешний цикл, взять элемент первого файла и пойти снова во внутрениий,
            // пропуская взятия из второго файла. Также при установке skip = true, сохраняем итариционную переменную
            // второго цикла, чтобы оставить второй цикл в неизменном состоянии
            boolean skip = false;

            // true, если больше нельзя брать элементы из первого файла, взяты все в пределах длины серии.
            boolean stopTakeFile1 = false;

            // true, если больше нельзя брать элементы из второго файла, взяты все в пределах длины серии.
            boolean stopTakeFile2 = false;

            // Все элементы из первого файла в пределах серии записаны в результирующий файл
            boolean allFromFile1Entered = false;

            // Все элементы из второго файла в пределах серии записаны в результирующий файл
            boolean allFromFile2Entered = false;

            // Будущие элементы первого и второго файла
            long n1 = 0;
            long n2 = 0;

            // Внешний цикл для прохода по элементам первого файла
            for (int f1 = 0; f1 < seriesLength; f1++) {
                if (!stopTakeFile1) {
                    n1 = scanner1.nextLong();
                }
                if (seriesLength - f1 == 1) {
                    stopTakeFile1 = true;
                }

                // Внутренний цикл для прохода по элементам второго файла
                for (int f2 = s2; f2 < seriesLength; ) {
                    if (!skip) {
                        if (!stopTakeFile2) {
                            if (scanner2.hasNextLong()) {
                                n2 = scanner2.nextLong();
                                if (seriesLength - f2 == 1) {
                                    stopTakeFile2 = true;
                                }
                            } else {
                                allFromFile2Entered = true;
                                n2 = Long.MAX_VALUE;
                            }
                        }
                    }
                    if (n1 < n2) {
                        if(!allFromFile1Entered) {
                            printWriter.println(n1);
                            printWriter.flush();
                        }
                        if (stopTakeFile1) {
                            allFromFile1Entered = true;
                            n1 = Long.MAX_VALUE;
                        }
                        skip = true;
                        s2 = f2;
                        if (allFromFile1Entered) {
                            if (allFromFile2Entered) {
                                break;
                            } else {
                                continue;
                            }
                        }
                        break;
                    } else {
                        if (!allFromFile2Entered) {
                            printWriter.println(n2);
                            printWriter.flush();
                        }
                        if (stopTakeFile2) {
                            allFromFile2Entered = true;
                        }
                        if (allFromFile2Entered) {
                            n2 = Long.MAX_VALUE;
                            if (allFromFile1Entered) {
                                break;
                            } else {
                                continue;
                            }
                        }
                        skip = false;
                        f2++;
                    }
                }
            }
        }
            while (scanner1.hasNextLong()) {
                printWriter.println(scanner1.nextLong());
                printWriter.flush();
            }

        return resultFile;
    }

    /**
     * Метод деления файла на два промежуточных путем деления двойками, четверками, восьмерками и т.д.     *
     * @param dataFile
     * @param tempFile1
     * @param tempFile2
     * @param numberOfSeries
     * @throws FileNotFoundException
     */
    private void divide(File dataFile, File tempFile1, File tempFile2, Integer numberOfSeries) throws FileNotFoundException {
        Scanner scanner = new Scanner(dataFile);

        PrintWriter printWriter1 = new PrintWriter(tempFile1);
        PrintWriter printWriter2 = new PrintWriter(tempFile2);
        int seriesLength = (int) Math.pow(2, numberOfSeries - 1);
        int numberOfFullCycles = numberOfLines / seriesLength;
        if (numberOfFullCycles % 2 != 0) {
            numberOfFullCycles = numberOfFullCycles - 1;
        }
        int remainder = numberOfLines - numberOfFullCycles * seriesLength;

        int numbers = 1;

        for (int cycle = 0; cycle < numberOfFullCycles; cycle++) {
            for (int i = 0; i < seriesLength; i++) {
                if (scanner.hasNextLong()) {
                    if (numbers % 2 != 0) {
                        printWriter1.println(scanner.nextLong());
                        printWriter1.flush();
                    } else {
                        printWriter2.println(scanner.nextLong());
                        printWriter2.flush();
                    }
                }
            }
            numbers++;
        }

        if (remainder > seriesLength) {
            for (int i = 0; i < seriesLength; i++) {
                if (scanner.hasNextLong()) {
                    printWriter1.println(scanner.nextLong());
                }
            }
            while (scanner.hasNextLong()) {
                printWriter2.println(scanner.nextLong());
            }
        } else {
            while (scanner.hasNextLong()) {
                printWriter1.println(scanner.nextLong());
            }
        }
        printWriter1.flush();
        printWriter2.flush();
    }

    /**
     * Метод деления на промежуточные файлы по единичным элементам и с подсчетом количества всех элементов/чисел
     * стартового файла
     * @param dataFile
     * @param tempFile1
     * @param tempFile2
     * @return
     * @throws FileNotFoundException
     */
    private int firstDivideAndCountNumberOfLines(File dataFile, File tempFile1, File tempFile2) throws FileNotFoundException {
        Scanner scanner = new Scanner(dataFile);
        PrintWriter printWriter1 = new PrintWriter(tempFile1);
        PrintWriter printWriter2 = new PrintWriter(tempFile2);

        int numbers = 0;
        while (scanner.hasNextLong()) {
            if (numbers % 2 == 0) {
                printWriter1.println(scanner.nextLong());
            } else {
                printWriter2.println(scanner.nextLong());
            }
            numbers++;
            printWriter1.flush();
            printWriter2.flush();
        }
        return numbers;
    }
}
