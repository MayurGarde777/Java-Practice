//Program will generate a random number and ask user to guess it and based on user input it will tell him if guess is too large or too small or small (if very close), large, if matches you wins and gets score. 

package Basics_Practice;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static int score, number, guess;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        number = rand.nextInt(1000); // Generate a random number between 0 to 1000
        System.out.println("Guessing Game \n");
        score = 0;
        do
        {
            System.out.print("\nGuess number : ");
            guess = sc.nextInt();
            score = score + 1;
            if(number < guess)
            {
                if((guess - number) < 50)
                    System.out.println("Wrong guess, guess was little larger ");
                else
                    System.out.println("Wrong guess, guess was too large");
            }
            else if(number > guess)
            {
                if((number - guess) < 50)
                    System.out.println("Wrong guess, guess was little smaller ");
                else
                    System.out.println("Wrong guess, guess was too small");
            }

        }while(guess != number);
        System.out.println("Your Score : " + score);
        sc.close();
    }
}
