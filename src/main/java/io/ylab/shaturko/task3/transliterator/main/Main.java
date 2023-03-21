package io.ylab.shaturko.task3.transliterator.main;

import io.ylab.shaturko.task3.transliterator.Transliterator;
import io.ylab.shaturko.task3.transliterator.impl.TransliteratorImpl;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Transliterator transliterator = new TransliteratorImpl();
        String res = transliterator
                .transliterate("HELLO! ПРИВЕТ! Go, boy!");
        System.out.println(res);

        System.out.println(transliterator
                .transliterate("ПОЭТОМУ КОГДА В БЛИЖАЙШЕМ БУДУЩЕМ НАМ ПОТРЕБУЕТСЯ ВНЕДРИТЬ СЛЕДУЮЩИЕ ДОПОЛНИТЕЛЬНЫЕ ОПЦИИ:"));

    }
}
