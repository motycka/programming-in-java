package com.motycka.java;

public class MemoryModel {
    public static void main(String[] args) {
        Foo foo = new Foo();

        System.out.println(foo.x);
        System.out.println(foo.y);
        foo.bar();
        System.out.println(foo.x);
        System.out.println(foo.y);
    }
}


class Foo {
    int x = 1;
    int y = 1;

    void bar() {
//        synchronized (aLock) {
//            x = x + 1;
//        }
        x = x + 1;
        y = y + 1;
    }
}
