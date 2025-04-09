package org.example.Map;

import org.example.List.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    private HashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
    }

    @Test
    void testPutAndGet() {
        map.put("A", 1);
        map.put("B", 2);
        assertEquals(1, map.get("A"));
        assertEquals(2, map.get("B"));
    }

    @Test
    void testPutOverrideValue() {
        map.put("A", 1);
        map.put("A", 99);
        assertEquals(99, map.get("A"));
    }

    @Test
    void testContainsValue() {
        map.put("A", 1);
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(2));
    }

    @Test
    void testRemove() {
        map.put("A", 10);
        map.put("B", 20);
        assertEquals(10, map.remove("A"));
        assertNull(map.get("A"));
        assertEquals(1, map.size());
    }

    @Test
    void testRemoveNonExistentKey() {
        assertNull(map.remove("X"));
    }

    @Test
    void testSize() {
        assertEquals(0, map.size());
        map.put("X", 123);
        assertEquals(1, map.size());
    }

    @Test
    void testNullKey() {
        map.put(null, 42);
        assertEquals(42, map.get(null));
    }
}