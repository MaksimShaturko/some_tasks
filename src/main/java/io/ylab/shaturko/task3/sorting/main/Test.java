package io.ylab.shaturko.task3.sorting.main;

import io.ylab.shaturko.task3.sorting.Generator;
import io.ylab.shaturko.task3.sorting.Sorter;
import io.ylab.shaturko.task3.sorting.Validator;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File dataFile = new Generator().generate("src/main/resources/data.txt", 100);
        System.out.println(new Validator(dataFile).isSorted()); // false
        File sortedFile = new Sorter().sortFile(dataFile);
        System.out.println(new Validator(sortedFile).isSorted()); // true
    }
}
