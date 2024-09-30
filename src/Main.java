// Program Title : RPS Game
// Programmer & Author : Keith Ralph Poncardas
// Programming Language : Java
// Date Launched : April 22, 2024

import java.util.Scanner;
import java.util.Random;

public class Main {
    // Function To Check If The Input Selection Is Valid
    public static boolean isValidSelection (String select) {
        String[] validSelections = {"rock", "paper", "scissor"};

        boolean isValid = false;

        for (String validSelection : validSelections) {
            if (validSelection.equals(select)) {
                isValid = true;
                break;
            }
        }

        return !isValid;
    }
    // Function To User Choice
    public static String getUserChoice () {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Player Choice (rock, paper, scissor) [exit] :");
            String userChoice = scanner.nextLine().trim().toLowerCase();

            if (userChoice.equals("exit")) {
                return null;
            }

            if (userChoice.isEmpty()) {
                System.out.println("No Input, Try Again.");
                continue;
            }

            boolean isValidSelect = isValidSelection(userChoice);

            if (isValidSelect) {
                System.out.println("Invalid Select, Try Again.");
                continue;
            }

            return userChoice;
        }
    }
    // Function To Computer Choice
    public static String computerChoice () {
        String[] computerChoice = {"rock", "paper", "scissor"};

        Random rand = new Random();

        int randomChoice = rand.nextInt(computerChoice.length);

        return computerChoice[randomChoice];
    }
    // Function Perform RPS Game
    public static String playGame () {
        String userChoice = getUserChoice();

        if (userChoice == null) {
            return "Exit.";
        }

        String computerChoice = computerChoice();

        String result;

        if (userChoice.equals(computerChoice)) {
            result = "It's A Tie!";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) || (userChoice.equals("scissors") && computerChoice.equals("paper")) || (userChoice.equals("paper") && computerChoice.equals("rock"))) {
            result = "You Win!";
        } else {
            result = "Computer Win!";
        }
        return result;
    }
    public static void main(String[] args) {
        String playGame = playGame();
        System.out.println(playGame);
    }
}