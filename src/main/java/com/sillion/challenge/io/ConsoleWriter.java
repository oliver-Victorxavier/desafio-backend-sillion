package com.sillion.challenge.io;

import java.util.Map;

public class ConsoleWriter {

    public void println(String message) {
        System.out.println(message);
    }

    public void printInputPrompt(String message) {
        System.out.println(message);
        System.out.print("> ");
    }

    public void printError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }


    public void printSuccess(String message) {
        System.out.println(message);
    }

    public void printPhraseResult(String phrase, long count) {
        System.out.println("\"" + phrase + "\" ⇒ repete " + count + " vezes");
    }

    public void printWordResults(Map<String, Long> wordCounts) {
        for (Map.Entry<String, Long> entry : wordCounts.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\" ⇒ repete " + entry.getValue() + " vezes");
        }

    }

    public void printSeparator() {
        System.out.println("-".repeat(50));
    }

}