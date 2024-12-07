package ru.vsu.cs.averkieva;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    private HashMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
    }

    @Test
    public void testPut() {
        map.put("1234", "cat");
        map.put("1345", "dog");
        map.put("1234", "flower");

        assertEquals("flower", map.get("1234"), "Значение для ключа 1234 должно быть flower");
        assertEquals("dog", map.get("1345"), "Значение для ключа 1345 должно быть dog");
        assertEquals(2, map.size());

    }


    @Test
    public void testRemoveKey() {
        map.put("1234", "for cat");
        assertTrue(map.containsKey("1234"), "содержит  ключ 1234");

        map.removeKey("1234");
        assertFalse(map.containsKey("1234"), "Не должен содержать ключ 1234 после удаления");
        assertEquals(0, map.size());


    }

    @Test
    public void testSize() {

        map.put("1234", "cat");
        map.put("1345", "dog");
        assertEquals(2, map.size(), "Размер = 2");

        map.removeKey("1234");
        assertEquals(1, map.size(), "После удаления элемента размер = 1 ");

        map.clear();
        assertEquals(0, map.size(), "Размер после очистки = 0");
    }


    @Test
    public void testCollisions() {

        map.put("a", "valueA");
        map.put("1563", "valueB");
        assertEquals(map.hash("a"), map.hash("1563")); // - одинаковые хэши

        assertTrue(map.containsKey("1563"));
        assertTrue(map.containsKey("a"));
        assertEquals("valueA", map.get("a"), "Значение для ключа a должно быть valueA");
        assertEquals("valueB", map.get("1563"), "Значение для ключа 1563 должно быть valueB");

        assertEquals(2, map.size());
    }

    @Test
    public void testRemoveCollisions() {
        map.put("a", "valueA");
        map.put("1563", "valueB");

        map.removeKey("a");

        assertFalse(map.containsKey("a"), "Не должен содержать ключ a после его удаления");
        assertTrue(map.containsKey("1563"), "Содержит ключ 1563 после удаления a");

        assertEquals("valueB", map.get("1563"), "Значение ключа 1563 - valueB");
    }
}
