package com.motycka.java.practice.lesson4;

public class Lesson04Main {

//    private static String message = "If the only tool you have is a hammer, it is tempting to treat everything as if it were a nail.";
    private static String message = "The quick brown fox jumps over the lazy dog";

    public static void main(String[] args) {
        Encoder encoder = new SaltedEncoder("xyz");

        String encodedMessage = encoder.encode(message);
        String decodedMessage = encoder.decode(encodedMessage);

        System.out.println(encodedMessage);
        System.out.println(decodedMessage);
    }

}

interface Encoder {
    String encode(String message);

    String decode(String message);
}

class ReverseEncoder implements Encoder {

    @Override
    public String encode(String message) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i =  message.length() - 1; i >= 0; i--) {
            stringBuilder.append(message.charAt(i));
        }

        return stringBuilder.toString();
    }

    @Override
    public String decode(String message) {
        return encode(message);
    }
}

class SaltedEncoder implements Encoder {

    private final String salt;

    SaltedEncoder(String salt) {
        this.salt = salt;
    }

    @Override
    public String encode(String message) {
        return reverse(message.replace(" ", salt));
    }

    @Override
    public String decode(String message) {
        return reverse(message).replace(salt, " ");
    }

    private String reverse(String message) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i =  message.length() - 1; i >= 0; i--) {
            stringBuilder.append(message.charAt(i));
        }

        return stringBuilder.toString();
    }
}
