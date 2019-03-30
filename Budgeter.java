// Yixiao Li
// 10/22/18
// Budgeter.java

// This program shows what the program does and asks for
// your number of income categories and each income amount.
// It then asks for you to choose monthly or daily expenses
// and each amount. Then prints out the total monthly income (daily)
// and total monthly expenses (daily), and how much more you spent
// or earned, and tells you your spending behavior.

import java.util.*;

public class Budgeter {
   // This class constant changes number of days in a month
   public static final int DAYS = 31;
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      budgeterFunction();
      double earning = incomeCategories(console);
      double spending = expenseCategories(console);
      total(earning, spending);
      conclusion(earning, spending);
   }
   
   // This method prints out the first two lines of the budgeter program
   public static void budgeterFunction() {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   
   // This method ask for your number of income categories
   // and each income amount, and calculates total amount.
   // Then it returns your total monthly income
   // 
   // Scanner console - the Scanner class to use for input
   public static double incomeCategories(Scanner console) {
      return calculateTotal(console, "income");   
   }
   
   // This method asks you to choose between monthly and daily expenses,
   // then asks you the number of categories then
   // each amount of your monthly or daily expenses
   // This method returns your total monthly expenses
   // 
   // Scanner console - the Scanner class to use for input
   public static double expenseCategories(Scanner console) {
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int choice = console.nextInt();
      
      double expenseTotal = calculateTotal(console, "expense");
      if (choice == 2) {
         expenseTotal = expenseTotal * DAYS;
      }
      return expenseTotal;
   }
   
   // This prompts the user for number of categories of payments,
   // then prompts the user for amount for each category.
   //
   // Scanner console - the Scanner class to use for input
   // String word - the word to specify the type of payments
   public static double calculateTotal(Scanner console, String word) {
      System.out.print("How many categories of " + word + "? ");
      int number = console.nextInt();
      
      double total = 0.0;
      for (int i = 1; i <= number; i++) {
         System.out.print("    Next " + word + " amount? $");
         total += console.nextDouble();
      }
      System.out.println();
      
      return total;
   }
   
   // This method prints out the total monthly income and daily incomes,
   // and it also prints out the total monthly expense and daily expenses
   // 
   // double earning - the total amount of monthly income
   // double spending - the total amount of monthly expenses
   public static void total(double earning, double spending) {
      System.out.printf("Total income = $%.2f ($%.2f/day)\n", earning, earning / DAYS);
      System.out.printf("Total expenses = $%.2f ($%.2f/day)\n", spending, spending / DAYS);
      System.out.println();
   }
   
   // This method prints how much your monthly income is more than monthly expenses
   // or how much your monthly expenses is more than your monthly income,
   // then it gives you a conclusion according to how well you manage your budget.
   // 
   // double earning - the total amount of monthly income
   // double spending - the total amount of monthly expenses 
   public static void conclusion(double earning, double spending) {
      double difference = earning - spending;
   
      if (difference >= 0) {
         System.out.printf("You earned $%.2f more than you spent this month.\n", difference);
      }
      if (difference > 0 && difference <= 250) {
         System.out.println("You're a saver.");
         System.out.println("You can only buy a cheap Christmas gift.");
      } else if (difference > 250) {
         System.out.println("You're a big saver.");
         System.out.println("You will have money to buy yourself a great Christmas gift!");
      }
      
      if (difference < 0) {
         System.out.printf("You spent $%.2f more than you earned this month.\n",
                            Math.abs(difference)); // statement too long so I have to break it
      }
      if (difference <= 0 && difference > -250) {
         System.out.println("You're a spender.");
         System.out.println("You might not have enough money to buy anything for Christmas.");
      } else if (difference <= -250) {
         System.out.println("You're a big spender.");
         System.out.println("You do not have money to pay utility bills!");
      } 
   }
}