// Yixiao Li
// 10/30/2018
// GuessingGame.java

// This program will prints out a haiku message first,
// then it prompts user to play a guessing number game.
// When the user gets the number right, it will tell the user how many
// times he or she has tried guessing. Then it asks whether the user
// want to play again. If the user don't want to play again,
// it will print out the statistics for all the games. The range
// for which the random number is chosen can be changed.

import java.util.*;

public class GuessingGame {

   // This maximum changes the range of largest possible number used in the game
   public static final int MAXIMUM = 100;
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();      
      haikuIntro();
      
      int games = 0;
      int totalTries = 0;
      int bestGame = 1000000; // Assuming no game will require one million or more guesses
      String answer = "";
      
      // this is for the user to play multiple games,
      // the user can choose to play again or stop the game
      do { 
         int tries = guessing(console, rand);  
         totalTries += tries;
         bestGame = Math.min(bestGame, tries);
         games++;
               
         System.out.print("Do you want to play again? ");
         answer = console.next();
                  
      } while (answer.startsWith("Y") || answer.startsWith("y"));

      statistics(games, totalTries, bestGame);
   }
   
   // This method prints out a haiku intro message
   public static void haikuIntro() {
      System.out.println("Countless stars and crazy numbers,");
      System.out.println("which always force people to go crazy.");
      System.out.println("Maybe give it a guess?");
   }
   
   // This method prompts the user to play a guessing number game,
   // then it returns number of tries for user to get the right number
   //
   // Scanner console - the Scanner class to use for input
   // Random rand - the Random class to use for random numbers
   public static int guessing(Scanner console, Random rand) {
      System.out.println();
      System.out.println("I'm thinking of a number between 1 and " + MAXIMUM + "...");
      int num = rand.nextInt(MAXIMUM) + 1; // creates a random number between 1 and maximum
      
      System.out.print("Your guess? ");
      int input = console.nextInt();
      int tries = 1;
      
      while (input != num) {
         tries++;
         System.out.print("Your guess? ");
         input = console.nextInt();
         
         if (num > input) {
            System.out.println("It's higher.");
         } else if (num < input) {
            System.out.println("It's lower.");
         }
      }
      
      String result = "You got it right in ";
      if (tries == 1) {
         result += "1 guess!";
      } else {
         result += tries + " guesses!";
      }
      System.out.println(result);
      
      return tries;
   }
      
   // This method prints out the overall statistics of all the games played
   //
   // int games - the number of games played
   // int totalTries - the total number of tries in all the games played
   // int bestGame - least number of tries among all the games played
   public static void statistics(int games, int totalTries, int bestGame) {
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("Total games   = " + games);
      System.out.println("Total guesses = " + totalTries);
      System.out.println("Guesses/game  = " + round((double)totalTries/games));
      System.out.println("Best game     = " + bestGame);
   }
   
   // This method returns the given number rounded to one decimal place
   //
   //double num - the number to round
   public static double round(double num) {
      return Math.round(num * 10.0) / 10.0;
   }
}