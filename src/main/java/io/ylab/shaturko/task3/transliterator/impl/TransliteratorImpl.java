package io.ylab.shaturko.task3.transliterator.impl;

import io.ylab.shaturko.task3.transliterator.Transliterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TransliteratorImpl implements Transliterator {

    private Map<String, String> mapTranslit = new HashMap<>();

    public TransliteratorImpl() throws FileNotFoundException {
        File file = new File("src/main/resources/matches.txt");
        Scanner scanner = new Scanner(new FileInputStream(file));
            while (scanner.hasNextLine()) {
                String[] matches = scanner.nextLine().split(":");
                if (matches.length == 2) {
                    mapTranslit.put(matches[0], matches[1]);
                } else {
                    mapTranslit.put(matches[0], "");
                }
            }
            scanner.close();
    }

    @Override
    public String transliterate(String source) {
        StringBuilder resultString = new StringBuilder(" ");
        char[] chars = source.toCharArray();
        for (char symbol: chars) {
            if(mapTranslit.containsKey(String.valueOf(symbol))) {
                resultString.append(mapTranslit.get(String.valueOf(symbol)));
            } else {
                resultString.append(symbol);
            }
        }
        return resultString.toString();
    }
}
