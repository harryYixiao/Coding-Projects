// Yixiao Li
// 11/10/2018
// TA: Grigory Khanykov
// Assignment 6: MadLibs.java

// This program prompts the user to play a game called "Mad Lib."
// It prints out a welcome message first, then prompts you whether you
// want to create a text file or view a text file, or you want to quit.
// If you create a file, it asks you for words or phrases to fill in a
// story of the file chosen, and output the new story to an output file.
// If you view a file, the program will print out the story in that file.
// The program won't stop prompting you to create or view file until you quit. 

import java.util.*;
import java.io.*;

public class MadLibs {
   // Throws a FileNotFoundException if the file needed to open does not exist.
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      String answer = "";
      
      introduction();
      
      // This prompts the user to create or view a file until the user quit.
      while (!answer.equalsIgnoreCase("Q")) {
      
         if (answer.equalsIgnoreCase("C")) {
            create(console);  
                   
         } else if (answer.equalsIgnoreCase("V")) {
            view(console);
         }
         
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         answer = console.nextLine();  
      }
   }
   
   // This method prints out a introduction message for the user
   public static void introduction() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
    
   // This method asks user for an input file and an output file,
   // then asks for words and phrases to fill in a story of that input file,
   // and output the new story to the output file.
   // Throws a FileNotFoundException if the file needed to open does not exist.
   //
   // Scanner console - the Scanner to use for input  
   public static void create(Scanner console) throws FileNotFoundException {
      Scanner input = findFile(console);
      
      System.out.print("Output file name: ");
      String outputFile = console.nextLine();
      
      PrintStream output = new PrintStream(new File(outputFile));
      
      System.out.println();
      
      createParagraph(console, input, output);    
      System.out.println();
   }
   
   // This method asks the user for an input file
   // and prints out the story of that file
   // Throws a FileNotFoundException if the file needed to open does not exist.
   //
   // Scanner console - the Scanner to use for input
   public static void view(Scanner console) throws FileNotFoundException {
      Scanner input = findFile(console);
      
      System.out.println();    
      while (input.hasNextLine()) {
         System.out.println(input.nextLine());
      }
      System.out.println();
   }
   
   // This method asks the user to choose an input file.
   // It won't stop prompting you for a file name until you give an existed file,
   // and it returns a Scanner of the input file.
   // Throws a FileNotFoundException if the file needed to open does not exist.
   //
   // Scanner console - the Scanner to use for input
   public static Scanner findFile(Scanner console) throws FileNotFoundException {
      System.out.print("Input file name: ");
      String fileName = console.nextLine();
      File file = new File(fileName);
      
      while (!file.exists())  {
         System.out.print("File not found. Try again: ");
         fileName = console.nextLine();
         file = new File(fileName);
      }
      return new Scanner(file);
   }
   
   // This takes each token from each line of the input file,
   // and asks the user for words and phrases to fill in the story,
   // and output the new story to the output file.
   //
   // Scanner console - the Scanner to use for input
   // Scanner input - the Scanner to use for inputting texts from a file
   // PrintStream output - the PrintStream to use for outputing texts to an output file
   public static void createParagraph(Scanner console, Scanner input, PrintStream output) {
      while (input.hasNextLine()) {
         String line = input.nextLine();
         Scanner tokens = new Scanner(line);
         
         while (tokens.hasNext()) {
            String word = tokens.next();
            
            // Print "an" for words with vowel, and space instead of dash
            if (word.startsWith("<") && word.endsWith(">")) {
               System.out.print("Please type ");
            
               String firstLetter = "" + word.charAt(1);
               String vowel = "AEIOUaeiou";           
               if (vowel.contains(firstLetter)) {
                  System.out.print("an ");
               } else {
                  System.out.print("a ");
               }
            
               word = word.substring(1, word.length() - 1);            
               word = word.replace("-", " ");          
               System.out.print(word + ": ");
            
               word = console.nextLine();            
            }
                           
            output.print(word + " ");
         }
         
         output.println();
      }
      System.out.println("Your mad-lib has been created!");
   }
}