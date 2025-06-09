package Inputs;

import java.util.List;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);


    public static int readIntInRange(int min, int max) {
        int value;
        while (true) {
            System.out.print("> ");
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    
    public static String readLine() {
        System.out.print("> ");
        return scanner.nextLine().trim();
    }

    // Read until user enters a blank line (for diary)
    public static String readMultiLineUntilBlank() {
        System.out.println("(Press Enter on a blank line to finish)");
        StringBuilder builder = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
            builder.append(line).append("\n");
        }
        return builder.toString().trim();
    }

    // Yes/no confirmation
    public static boolean readYesNo(String prompt) {
        System.out.print(prompt + " (y/n): ");
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) return true;
            if (input.equals("n") || input.equals("no")) return false;
            System.out.print("Please enter 'y' or 'n': ");
        }
    }

    // Choose from a list (e.g. prompt themes, characters)
    public static int chooseFromList(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, options.get(i));
        }
        return readIntInRange(1, options.size());
    }
}
