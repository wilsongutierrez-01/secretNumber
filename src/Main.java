import java.util.Random;
import java.util.Scanner;

public class Main {
    private int secretNumber;
    private int range = 10;
    private int intents;
    private int level;
    private int intentUse = 1;
    private int guess;
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main game = new Main();
        game.startGame();
    }
    public void startGame() {
        generateSecreteNumber();
        welcome();
        selectLevel();
        levelSelected(level);
        while (guess != secretNumber && intentUse <= intents) {
            guessNumber();
        }
        if (guess != secretNumber) {
            System.out.println("Game over attempts done! The secret number was: " + secretNumber);
        }
    }
    private void generateSecreteNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(range) + 1;
    }

    private void welcome() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and " + range + ".");
        System.out.println("You have " + intents + " " + "chances to guess the correct number.\n");
    }

    private void selectLevel() {
        System.out.println("Please select the difficulty level: ");
        System.out.println("1. Easy (10 chances, range 1-50)");
        System.out.println("2. Medium (5 chances, range 1-75)");
        System.out.println("3. Hard (3 chances, range 1-100)");
        level = scanner.nextInt();
    }

    private void levelSelected(int level) {
        switch (level) {
            case 1:
                intents = 10;
                range = 50;
                System.out.println("Great! You have selected the Easy difficulty level.");
                break;
            case 2:
                intents = 5;
                range = 75;
                System.out.println("Great! You have selected the Medium difficulty level.");
                break;
            case 3:
                intents = 3;
                range = 100;
                System.out.println("Great! You have selected the Hard difficulty level.");
                break;
            default:
                System.out.println("Wrong choice.");
        }
        System.out.println("You have " + intents  + " chances to guess the correct number between 1 and " + range + ". \n Let's start the game!" );
    }

    private void guessNumber() {
        System.out.println("Enter your guess: ");
        guess = scanner.nextInt();

        if (guess == secretNumber) {
            System.out.println("Congratulations! You guessed the correct number in " + intentUse +  " attempts.");
        }else if (guess > secretNumber) {
            System.out.println("Incorrect! The number is less than " + guess + ".");
        } else {
            System.out.println("Incorrect! The number is greater than " + guess + ".");
        }
        intentUse++;
    }
}