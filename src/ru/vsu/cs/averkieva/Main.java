package ru.vsu.cs.averkieva;

public class Main {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();

        map.put("1234", "cat");
        map.put("1345", "dog");
        map.put("1234", "flower");

        map.printMap();
        System.out.println("size: " + map.size());
        System.out.println();

        System.out.println(map.get("1234"));
        System.out.println();

        map.remove("1234");
        map.printMap();
        System.out.println("size: " + map.size());


    }
}