package com.harbourspace.lesson09;

public class GiftBox<T> {
    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}
