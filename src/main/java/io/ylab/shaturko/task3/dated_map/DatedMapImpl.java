package io.ylab.shaturko.task3.dated_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class DatedMapImpl  implements DatedMap {
    private Date dateKeyPut;
    private HashMap<String, String> hashMap;

    public DatedMapImpl() {
        this.hashMap = new HashMap<>();
    }

    @Override
    public void put(String key, String value) {
        hashMap.put(key, value);
        dateKeyPut = new Date();
    }

    @Override
    public String get(String key) {
        return hashMap.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return hashMap.containsKey(key);
    }

    @Override
    public void remove(String key) {
        hashMap.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return hashMap.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        if(containsKey(key)) {
            return dateKeyPut;
        } else {
            return null;
        }
    }
}
