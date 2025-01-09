import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int maxAttempts = 10;

        System.out.println("Number Guessing Game\n");

        while (true) {
            int numberToGuess = random.nextInt(100) + 1; 
            int attempts = 0;

            System.out.println("I have generated a number between 1 and 100. Try to guess it!");
            System.out.println("You have " + maxAttempts + " attempts.\n");

            while (attempts < maxAttempts) {
                int userGuess;

                while (true) {
                    System.out.print("Enter your guess (1-100): ");
                    if (scanner.hasNextInt()) {
                        userGuess = scanner.nextInt();
                        if (userGuess >= 1 && userGuess <= 100) {
                            break;
                        } else {
                            System.out.println("Please enter a number between 1 and 100.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                    }
                }

                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1);
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("The guessed number is too low. Try again!");
                } else {
                    System.out.println("The guessed number is too high. Try again!");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play another round? (y/n): ");
            String playAgainInput = scanner.next();

            if (!playAgainInput.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Thanks for playing This game, Your total score is: " + totalScore);
        scanner.close();
    }
}


