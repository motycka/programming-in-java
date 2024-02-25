package lesson06.math;

import java.math.BigDecimal;

public class BigDecimalExample {

    public static void main(String[] args) {

        // parse big decimal from string
        BigDecimal radius = new BigDecimal("987654321.12345678901234567890");

        // get big decimal value from other types
        BigDecimal two = BigDecimal.valueOf(2);

        // get big decimal representation of pi
        BigDecimal pi = BigDecimal.valueOf(Math.PI);

        var circleCircumference = two.multiply(pi).multiply(radius);

        System.out.println(circleCircumference); // 6205615119.05533231868504652218099103339093540

    }

}
