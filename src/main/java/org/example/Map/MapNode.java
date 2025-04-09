package org.example.Map;

public class MapNode<K, V> {
    private K key;
    private V value;
    private MapNode<K, V> next;

    public MapNode(K key, V value) {
        this.key = key;
        this.value = value;
        if (key != null){
            int hash = key.hashCode();
        }

    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
