package nl.tijsbeek;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

public class Interpreter {
    public static final int MAX_POINTER_VALUE = 3000;
    public static final int MIN_POINTER_VALUE = 0;

    public static final char LOOP_OPEN = '[';
    public static final char LOOP_CLOSE = ']';

    private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    private byte[] array = new byte[MAX_POINTER_VALUE];
    private int pointer = 0;

    public void run(String code) {
        Iterator<Character> iterator = code.chars()
                .mapToObj(value -> (char) value)
                .iterator();

        while (iterator.hasNext()) {
            Character next = iterator.next();

            switch (next) {
                case '>' -> pointer++;
                case '<' -> pointer -= (MIN_POINTER_VALUE >= pointer) ? 0 : 1;
                case '+' -> array[pointer] += 1;
                case '-' -> array[pointer] -= 1;
                case '.' -> System.out.print((char) (array[pointer]));
                case ',' -> array[pointer] = scanner.nextByte();
                case LOOP_OPEN -> {
                    runLoop(iterator);
                }
            }
        }
    }

    private void runLoop(final Iterator<Character> iterator) {
        StringBuilder loopBuilder = new StringBuilder();

        int loopDepth = 1;

        while (iterator.hasNext()) {
            Character nextLoopChar = iterator.next();

            if (LOOP_CLOSE == nextLoopChar && 1 == loopDepth) {

                String code = loopBuilder.toString();
                while (0 != array[pointer]) {
                    run(code);
                }
                return;

            } else if (LOOP_CLOSE == nextLoopChar) {
                loopDepth--;
            } else if (LOOP_OPEN == nextLoopChar) {
                loopDepth++;
            }

            loopBuilder.append(nextLoopChar);
        }
    }
}