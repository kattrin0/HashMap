package ru.vsu.cs.averkieva;
import static ru.vsu.cs.averkieva.HashMapGraph.saveAndVisualize;

public class Main {
    public static void main(String[] args) {
        /*HashMap<String,String> map = new HashMap<>();

        map.put("1234", "cat");
        map.put("1345", "dog");
        map.put("1234", "flower");
        map.put("1563", "for test");
        map.put("a", "for test1");


        System.out.println( map.hash("1563"));
        System.out.println(map.hash("a"));


        System.out.println( map.containsKey("1234"));

        map.printMap();
        System.out.println("size: " + map.size());
        System.out.println();

        System.out.println(map.get("1234"));
        System.out.println();

        map.removeKey("1563");
        System.out.println( map.containsKey("1234"));
        map.printMap();
        System.out.println("size: " + map.size());*/

        HashMap<String, String> map = new HashMap<>();

        /* test1
        map.put("1234", "cat");
        map.put("1345", "dog");
        map.put("1234", "flower");
        map.put("1563", "for test");
        map.put("a", "for test1");
        map.put("1frgh", "cat1");
        map.put("1dfg4", "cat2");
        map.put("rt4erty", "cat3");
        map.put("12ert3654", "cat4");
        map.put("wery654", "cat5");

        map.put("54", "cat6");
        map.put("b", "cat6");
        map.put("c", "cat6");
        map.put("d", "cat6");
        map.put("e", "cat6");
        */

        map.put("1234", "cat");
        map.put("1345", "dog");
        map.put("1234", "flower");


        map.put("1563", "apple");
        map.put("a", "apple1");

        saveAndVisualize(map,"hashmap.dot");

        //System.out.println("Визуализация сохранена в hashmap.png");
    }
}