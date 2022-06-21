package nl.tijsbeek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();

        System.out.println("""
                Brainfuck interpreter.
                """);

        String brainfuck = loadChoice();

        interpreter.run(brainfuck);

        System.out.println();
    }

    private static String loadChoice() {
        System.out.println("""
                To start press 1 or 2:
                                        
                1) load a file
                2) load using console (max 1 line)
                """);

        int loadChoice = Integer.parseInt(scanner.nextLine());

        if (1 == loadChoice) {
            System.out.println("File location:");

            String fileLocation = scanner.nextLine();

            try {
                return Files.readString(Path.of(fileLocation));
            } catch (final IOException e) {
                System.err.println("Something went wrong when reading the file, check or it's the correct location and try again.");
            }

        } else if (2 == loadChoice) {
            System.out.println("The brainfuck code: (max 1 line)");

            return scanner.nextLine();

        } else {
            System.err.println("Invalid choice, try again.");
        }

        return loadChoice();
    }
}