package ru.vsu.cs.averkieva;

import java.util.LinkedList;
import java.util.List;

class HashMap<K, V> {
    private final int defaultSize = 16;
    private float loadFactor = 0.75F;
    List<Entry<K, V>>[] array;
    int size;
    private K Key;
    private V Value;

    public HashMap() {
        this.array = new List[defaultSize];
        for (int i = 0; i < defaultSize; i += 1) {
            array[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    public void put(K key, V value) {
        if (isOverflowed()) {
            resize();
        }
        int hashCode = hash(key);
        for (Entry<K, V> entry : array[hashCode]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        array[hashCode].add(new Entry<>(key, value));
        size += 1;
    }

    public V get(K key) {
        int hashCode = hash(key);
        for (Entry<K, V> entry : array[hashCode]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public int hash(K key) {
        if (key == null) {
            return 0;
        }
        int hash = key.hashCode();
        //return hash ^ (hash >>> 16);
        return Math.abs(hash) % array.length;
    }

    private void resize() {
        List<Entry<K, V>>[] newArray = new List[array.length * 2];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = new LinkedList<>();
        }
        for (List<Entry<K, V>> bucket : array) {
            for (Entry<K, V> entry : bucket) {
                int hashCode = hash(Key);
                hashCode = Math.abs(hashCode) % newArray.length;
                newArray[hashCode].add(entry);
            }
        }
        array = newArray;
    }

    private boolean isOverflowed() {
        return size > (loadFactor * array.length);
    }

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void printMap() {
        System.out.println("HashMap:");
        for (List<Entry<K, V>> k : array) {
            for (Entry<K, V> entry : k) {
                System.out.println("Key: " + entry.key + ", Value: " + entry.value);
            }
        }
    }

    public static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
