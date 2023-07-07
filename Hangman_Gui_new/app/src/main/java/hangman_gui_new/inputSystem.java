package hangman_gui_new;

import java.util.Scanner;

public class inputSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}
