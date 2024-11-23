package ru.vsu.cs.averkieva;

public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap<>();

        map.put("1234", "cat");
        map.put("1345", "dog");
        map.put("1234", "flower");

        map.printMap();

    }
}