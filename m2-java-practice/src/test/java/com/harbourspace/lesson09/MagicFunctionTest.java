package com.harbourspace.lesson09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MagicFunctionTest {

    @Test
    public void testDoMagicWithBiFunction() {
        // Testing Task 3 functionality
        Integer resultBiFunction = MagicFunction.doMagicWithBiFunction("Hello", 5, (str, num) -> str.length() + num);
        Assertions.assertEquals(Integer.valueOf(10), resultBiFunction);
    }

    @Test
    public void testDoMagicWithCustomInterface() {
        // Testing Task 4 functionality
        Integer resultCustomInterface = MagicFunction.doMagicWithCustomInterface("World", 3, (str, num) -> str.length() * num);
        Assertions.assertEquals(Integer.valueOf(15), resultCustomInterface);
    }
}
