package org.example.List;

public class LLNode<T> {
    private T data;
    public LLNode<T> next;
    LLNode<T> prev;

    public LLNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public LLNode<T> getNext() {
        return next;
    }

}