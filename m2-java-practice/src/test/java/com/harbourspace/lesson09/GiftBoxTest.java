package com.harbourspace.lesson09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GiftBoxTest {

    @Test
    public void testStringBox() {
        GiftBox<String> stringBox = new GiftBox<>();
        stringBox.put("Hello");
        Assertions.assertEquals("Hello", stringBox.get());
    }

    @Test
    public void testIntegerBox() {
        GiftBox<Integer> integerBox = new GiftBox<>();
        integerBox.put(123);
        Assertions.assertEquals(Integer.valueOf(123), integerBox.get());
    }
}

