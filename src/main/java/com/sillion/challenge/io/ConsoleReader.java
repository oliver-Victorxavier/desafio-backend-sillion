package com.sillion.challenge.io;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine().trim();
    }

    public boolean readConfirmation(String message) {

        while (true) {
            System.out.println(message);
            System.out.print("> ");

            String input = scanner.nextLine().trim().toLowerCase();

            if (input.startsWith("s") || input.equals("y") || input.equals("yes")) {
                return true;
            }
            if (input.startsWith("n") || input.equals("no")) {
                return false;
            }

            System.out.println("Opção inválida! Digite 'S' para Sim ou 'N' para Não.");
        }
    }

    public void close() {
        scanner.close();
    }
}