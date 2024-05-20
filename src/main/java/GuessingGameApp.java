import java.util.Random;
import java.util.Scanner;
public class GuessingGameApp {

    public static Scanner inputScanner;
    public static int remainingGuesses;
    public static void main(String[] args) {

        inputScanner = new Scanner(System.in);

        /*

            Create a command line number guessing game, where users have to guess a random number between 1 and 10. 
            Please use the below iterations, to guide you, as you progress through the project.

            Build the application in the following small iterations. It should function at completion of each iteration!

            Print the instructions to the game and get user Input. 
                Instructions:
                    Guess a random number 
                    Must be between 1 and 10
                        Use a while loop to fill in the variable, see Question_3

            When the user guesses the correct number, the game announces they have won. 

            When the user guesses 0, the game provides instructions for the user.

            After guessing, the user has three more guesses to guess the correct answer.

            When the user guesses -1, the application should exit.

            The game should provide feedback that the secret number is > or < any incorrect guesses.

            Do not count 0 and -1 against the guesses.
            
            Stretch task: Accept strings instead of integers. The topic can be something fun, like dog breeds or favorite colors, etc.
            Stretchier task: Display the amount of guesses the user took and create a pointing system.

         */

        GuessingGameApp moveValuesAndObjects = new GuessingGameApp();
        remainingGuesses = 4;
        int usersRandomGuess;
        int numberComparisonOutcome;

        runHomePage();

        int secretAnswer = createSecretAnswer();

        
        System.out.println("                                       Guesses Remaining: " + remainingGuesses);
        System.out.println();

        while (true) {

            usersRandomGuess = moveValuesAndObjects.runGuess();
            remainingGuesses--;

            numberComparisonOutcome = moveValuesAndObjects.compareGuessToAnswer(usersRandomGuess, secretAnswer);

            String outcomeAsString = moveValuesAndObjects.printOutcome(numberComparisonOutcome, usersRandomGuess);
            System.out.println();
            System.out.println(outcomeAsString);
            System.out.println();
            System.out.println("                                       Guesses Remaining: " + remainingGuesses);
            System.out.println();

            if (numberComparisonOutcome == 0) {
                System.exit(0);
            }

            if (remainingGuesses == 0 && numberComparisonOutcome != 0) {
                System.out.println("You have guessed incorrectly three times in a row.");
                System.out.println("You lose :(");
                System.out.println("Better luck next time!");
                System.out.println();
                break;
            }
        }

        inputScanner.close();
        System.exit(0);

    }

    public static void runHomePage() {

        System.out.println();
        System.out.println("                                                   Exit: -1");
        System.out.println("                                            Instructions: 0");
        System.out.println();
        System.out.println();
        System.out.println("  -------------------   Guessing Game   -------------------  ");
        System.out.println();
        System.out.println();
        System.out.println(" Guess a random number between 1 and 10 then enter it below: ");
        System.out.println();
    }

    public int runGuess() {

        GuessingGameApp moveValuesAndObjects = new GuessingGameApp();
        int usersInput = inputScanner.nextInt();

        while (usersInput > 10 || usersInput < 1 ) {

            if (usersInput == -1) {
                System.exit(0);
            } else if (usersInput == 0) {
                moveValuesAndObjects.runInstructionsPage();
            } else {
                System.out.println();
                System.out.println("     You have entered an invalid response, please try again");
                System.out.println("  Guess a random number between 1 and 10 then enter it below:");
                System.out.println();
            }

            usersInput = createInputScanner().nextInt();

        }

        return usersInput;

    }

    public void runInstructionsPage() {

        System.out.println();
        System.out.println(" ------------------   Game Instructions   ------------------ ");
        System.out.println();
        System.out.println("Enter a random number between the inclusive range of 1 and 10");
        System.out.println("         If you guess the correct number, you win");
        System.out.println("      You will get three attempts to guess correctly");
        System.out.println("  If you guess incorrectly three times in a row, you lose");
        System.out.println();
        System.out.println("                     To exit, enter -1");
        System.out.println("                  To go back home, enter 0");
        System.out.println();

        int usersInput = createInputScanner().nextInt();

        while (usersInput != -1 && usersInput != 0) {

            System.out.println();
            System.out.println("     You have entered an invalid response, please try again");
            System.out.println("                        To exit, enter -1");
            System.out.println("                     To go back home, enter 0"); 
            System.out.println();

            usersInput = createInputScanner().nextInt();

        }

        if (usersInput == -1) {
            System.exit(0);
        } else if (usersInput == 0) {
            runHomePage();
        }

    }

    public static int createSecretAnswer() {

        Random randomObjectGenerator = new Random();

        return randomObjectGenerator.nextInt(10) + 1;

    }

    public int compareGuessToAnswer(int usersRandomGuess, int secretAnswer) {

            if (usersRandomGuess == secretAnswer) {
                return 0;
            } else if (usersRandomGuess > secretAnswer) {
                return 1;
            } else {
                return 2;
            }
    }

    public static Scanner createInputScanner() {

        return inputScanner;

    }

    public String printOutcome(int numberComparisonOutcome, int usersRandomGuess) {

        if (numberComparisonOutcome == 0) {
            return "Congratulations! You picked the right number! You win!";
        } else if (numberComparisonOutcome == 1) {
            return usersRandomGuess + " is too high, try again!";
        } else {
            return usersRandomGuess + " is too low, try again!";
        }
    }
}

