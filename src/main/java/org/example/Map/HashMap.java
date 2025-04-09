package org.example.Map;

import org.example.List.LLNode;
import org.example.List.LinkedList;

public class HashMap<K, V> implements Map<K, V> {
    private LinkedList[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    // Конструктор
    public HashMap() {
        table = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Новые методы
    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode());
    }
    private boolean keysEqual(K a, K b) {
        return (a == null && b == null) || (a != null && a.equals(b));
    }



    // Методы из интерфейса
    @Override
    public void put(K key, V value) {
        int hash = hash(key);
        int index = hash % table.length;

        LinkedList<MapNode<K, V>> bucket = table[index];

        if (bucket == null) {
            bucket = new LinkedList<>();
            table[index] = bucket;
        }

        LLNode<MapNode<K, V>> current = bucket.getHead();

        while (current != null) {
            MapNode<K, V> node = current.getData();
            if (keysEqual(key, node.getKey())) {
                node.setValue(value);
                return;
            }
            current = current.getNext();
        }

        bucket.addFirst(new MapNode<>(key, value));
        size++;

    }


    @Override
    public V get(K key) {
        int hash = hash(key);
        int index = hash % table.length;

        LinkedList<MapNode<K, V>> bucket = table[index];
        if (bucket == null) {
            return null;
        }

        LLNode<MapNode<K, V>> currentLLNode = bucket.getHead();
        while (currentLLNode != null) {
            MapNode<K, V> currentMapNode = currentLLNode.getData();
            if (keysEqual(key, currentMapNode.getKey())) {
                return currentMapNode.getValue();
            }

            currentLLNode = currentLLNode.getNext();
        }

        return null;
    }


    @Override
    public boolean containsKey(K key) {
        int hash = hash(key);
        int index = hash % table.length;

        LinkedList<MapNode<K, V>> bucket = table[index];
        if (bucket == null) {
            return false;
        }

        LLNode<MapNode<K, V>> current = bucket.getHead();
        while (current != null) {
            MapNode<K, V> node = current.getData();
            if (keysEqual(key, node.getKey())) return true;
            current = current.getNext();
        }
        return false;
    }


    @Override
    public boolean containsValue(V value) {
        for (LinkedList<MapNode<K, V>> bucket : table) {
            if (bucket != null) {
                LLNode<MapNode<K, V>> current = bucket.getHead();
                while (current != null) {
                    MapNode<K, V> node = current.getData();
                    if ((node.getValue() == null && value == null) ||
                            (node.getValue() != null && node.getValue().equals(value))) {
                        return true;
                    }
                    current = current.getNext();
                }
            }
        }
        return false;
    }


    @Override
    public V remove(K key) {
        int hash = hash(key);
        int index = hash % table.length;

        LinkedList<MapNode<K, V>> bucket = table[index];
        if (bucket == null) {
            return null;
        }

        LLNode<MapNode<K, V>> current = bucket.getHead();
        LLNode<MapNode<K, V>> prev = null;

        while (current != null) {
            MapNode<K, V> node = current.getData();
            if (keysEqual(key, node.getKey())) {
                V oldValue = node.getValue();

                // Удаление головы
                if (prev == null) {
                    bucket.removeFirst();
                } else {
                    LLNode<MapNode<K, V>> next = current.getNext();
                    prev.next = next;
                    if (next == null) {
                        bucket.remove(bucket.size() - 1); // обновим tail, если нужно
                    }
                    size--;
                }

                size--;
                return oldValue;
            }

            prev = current;
            current = current.getNext();
        }

        return null;
    }


    @Override
    public int size() {
        return this.size;
    }
}
