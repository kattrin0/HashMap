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

        // Добавляем тестовые данные
       /* map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        map.put("Key4", 4);
        map.put("Key5", 5);*/
        map.put("1234", "cat");
        map.put("1345", "dog");
        map.put("1234", "flower");
        map.put("1563", "for test");
        map.put("a", "for test1");


        saveAndVisualize(map,"hashmap.dot");

        //System.out.println("Визуализация сохранена в hashmap.png");
    }
}