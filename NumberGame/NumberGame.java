import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxNumber = 100;
        int guess;
        int attempts = 0;
        int maxAttempts = 10;
        int points = 110;
        String userWish;
        boolean wish = true, guessed = false;
        
        while (wish) {
            int randomNumber = random.nextInt(maxNumber) + 1;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a random number between 1 and " + maxNumber);
            System.out.println("Can you guess what it is within 10 attempts?");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;
                points-=10;
                
                if (guess < 1 || guess > maxNumber) {
                    System.out.println("Please enter a number between 1 and " + maxNumber);
                } else if ((guess > randomNumber)&& ((guess-randomNumber) > 10)) {
                    System.out.println("Too high! Try again.");
                } else if ((((guess-randomNumber) < 10) && ((guess-randomNumber) > -10))&&(guess!=randomNumber)) {
                    System.out.println("You're close!! You can do it!!");
                } else if (guess < randomNumber) {
                    System.out.println("Too Low!! Go Higher");
                } else {
                    System.out.println("Congratulations! You did it !! You've guessed the number " + randomNumber + " in " + attempts + " attempts.");
                    System.out.println("You've scored " + points + " points.");
                    guessed = true;
                    break;
                }
            }
            if (attempts == maxAttempts && guessed == false) {
                System.out.println("Sorry! You've finished all your attempts. Good Luck Next Time !!!");
            }
            if (attempts == maxAttempts || guessed) {
                System.out.println("Do you wish to continue... (Y/N)");
                userWish = scanner.next();
                if (userWish.equalsIgnoreCase("Y")) {
                    attempts = 0;
                    points = 110;
                    wish=true;
                }
                else {
                    wish=false;
                    System.out.println("Bye... Comeback Later");
                }
            }
        }
        scanner.close();
    }
}