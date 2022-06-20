package nl.tijsbeek;

import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();

        interpreter.run(scanner.nextLine());

        System.out.println();
    }
}