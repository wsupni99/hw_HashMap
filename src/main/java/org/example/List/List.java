package org.example.List;

public interface List<T> {
    void add(T elem);
    T get(int index);
    int indexOf(T elem);
    int size();
    T remove(int index);
}
