package com.harbourspace.lesson06;

import java.util.Optional;

public class OptionalTask {

    public static Optional<String> getWord(String text, String word) {
        if (text == null || word == null) {
            throw new IllegalArgumentException("Neither text nor word can be null.");
        }

        // Check if the text contains the word
        if (text.contains(word)) {
            return Optional.of(word);
        } else {
            return Optional.empty();
        }
    }

    public static void printWordPresence(Optional<String> optionalWord, String word) {
        // Based on the Optional value, print the appropriate message
        optionalWord.ifPresentOrElse(
                foundWord -> System.out.println("Word found: " + foundWord),
                () -> System.out.println("Word not found: " + word)
        );
    }

    public static void main(String[] args) {
        String text = "Here is a sample text to search through.";
        String wordToFind = "sample";
        String wordNotToFind = "missing";

        Optional<String> resultFound = getWord(text, wordToFind);
        printWordPresence(resultFound, wordToFind);

        Optional<String> resultNotFound = getWord(text, wordNotToFind);
        printWordPresence(resultNotFound, wordNotToFind);
    }
}
