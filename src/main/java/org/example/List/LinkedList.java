package org.example.List;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    // Добавил head (и tail на всякий)
    private int size;
    private LLNode<T> head;
    private LLNode<T> tail;
    public LLNode<T> getTail(){
        return tail;
    }
    public LLNode<T> getHead() {
        return head;
    }


    // Методы интерфейса
    @Override
    public void add(T elem) {
        LLNode<T> newNode = new LLNode<>(elem);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс " + index);
        }

        LLNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.getData();
    }


    @Override
    public int indexOf(T elem) {
        LLNode<T> current = head;
        int index = 0;

        while (current != null) {
            if ((current.getData() == null && elem == null) ||
                    (current.getData() != null && current.getData().equals(elem))) {
                return index + 1;
            }
            current = current.next;
            index++;
        }
        return -1;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс " + index);
        }

        LLNode<T> current = head;
        T removedElement;
        if (index == 0) {
            removedElement = head.getData();
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            LLNode<T> nodeToRemove = current.next;
            removedElement = nodeToRemove.getData();
            current.next = nodeToRemove.next;

            if (current.next == null) {
                tail = current;
            }
        }
        size--;
        return removedElement;
    }


    // Новые методы
    public void addFirst(T elem) {
        LLNode<T> newNode = new LLNode<>(elem);
        if (size != 0) {
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        size++;
    }


    public void removeFirst(){
        if (size != 0){
            T removedElem = head.getData();
            if(head == tail){
                head = null;
                tail = null;
            } else head = head.next;
            size--;
        } else {
            throw new NoSuchElementException("Ошибка при удалении: список пуст." );
        }
    }

    public T peekLast(){
        if (size == 0){
            return null;
        } else return tail.getData();
    }
}
