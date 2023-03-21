package io.ylab.shaturko.task3.dated_map.main;

import io.ylab.shaturko.task3.dated_map.DatedMap;
import io.ylab.shaturko.task3.dated_map.DatedMapImpl;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        DatedMap datedMap = new DatedMapImpl();

        datedMap.put("Maks", "husband");
        datedMap.put("Ira", "wife");
        datedMap.put("Vlad", "son");
        datedMap.put("Dasha", "daughter");

        System.out.println(datedMap.containsKey("Ira"));
        System.out.println(datedMap.get("Maks"));
        System.out.println(datedMap.keySet());
        System.out.println(datedMap.getKeyLastInsertionDate("Vlad"));

        Thread.sleep(1000);

        datedMap.put("Vlad", "good son");
        System.out.println(datedMap.getKeyLastInsertionDate("Vlad"));

        System.out.println(datedMap.getKeyLastInsertionDate("Noname"));
    }
}
