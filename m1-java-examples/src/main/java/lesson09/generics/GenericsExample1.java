package lesson09.generics;

import java.util.LinkedList;
import java.util.List;

public class GenericsExample1 {

//    public static void main(String[] args) {
//        List list = new LinkedList();
//        list.add("Hello World");
//        String str = list.get(0);
//    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Hello World");
        String str = list.get(0);
    }

}





