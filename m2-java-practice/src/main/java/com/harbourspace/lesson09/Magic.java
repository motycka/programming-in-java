package com.harbourspace.lesson09;

@FunctionalInterface
public interface Magic<T1, T2, R> {
    R apply(T1 item1, T2 item2);
}
