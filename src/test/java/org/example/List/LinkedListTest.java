package org.example.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testAddAndGet() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.get(1));
        assertEquals("B", list.get(2));
    }

    @Test
    void testIndexOf() {
        list.add("X");
        list.add("Y");
        assertEquals(1, list.indexOf("X"));
        assertEquals(2, list.indexOf("Y"));
        assertEquals(-1, list.indexOf("Z"));
    }

    @Test
    void testRemove() {
        list.add("1");
        list.add("2");
        assertEquals("1", list.remove(0));
        assertEquals(1, list.size());
        assertEquals("2", list.get(1));
    }

    @Test
    void testAddFirst() {
        list.add("B");
        list.addFirst("A");
        assertEquals("A", list.get(0));
    }

    @Test
    void testRemoveFirst() {
        list.add("A");
        list.add("B");
        list.removeFirst();
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void testPeekLast() {
        assertNull(list.peekLast());
        list.add("A");
        list.add("B");
        assertEquals("B", list.peekLast());
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
    }
}
