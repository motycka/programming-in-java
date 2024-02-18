package lesson05;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Bangkok");
        stack.push("Beijing");
        stack.push("Tokyo");
        stack.push("London");

        System.out.println(stack.peek()); // prints London
        System.out.println(stack.size()); // 4

        String lastCity = stack.pop();
        System.out.println(lastCity); // prints London
        System.out.println(stack.size()); // 3

        for (String city : stack) {
            System.out.println(city); // prints Bangkok, Beijing, Tokyo
        }
    }

}
