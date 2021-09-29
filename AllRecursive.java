import java.util.Scanner;
import java.util.*;

/*
*Printing recursive functions
*@author Nanami Kimoto
*@year 2019
*NOTES: No do, while, or for loops. Only recursive using if else. Menu is recursive also. 
*There is a try/catch block after each menu option, as well as throwing an exception in the method for-
*-incorrect menu entry if user entered a number not between 0 and 3. 
*Try/catch block around all to catch if user enters a word in menu instead of integer value.  
*/

public class AllRecursive{

    //power
    public static int power(int n, int powerValue){
    
        //SPECIAL CASE: return 1 for numbers raised to power of 0 (because it's always 1)
        if(powerValue==0)
            return 1;
        //multiply until user requested value is achieved
        else
            return n*power(n, powerValue-1);
    }
    //factorial
    public static int factorial(int n){
    
        //SPECIAL CASE: for 0, since 0! = 1
        if(n==0)
            return 1;
        //multiply until user requested number is achieved
        else
            return n*factorial(n-1);
    }
    //summation
    public static int summation(int n){
    
        //SPECIAL CASE: for 0, since 0 summation is just 0 
        if(n==0)
            return 0;
        //add number until user requested value is achieved
        else
            return n+summation(n-1);
    }
    //recursive menu
    public static void menu() throws IllegalArgumentException{
   
       try{
        System.out.println("This program will calculate power, factorial, and summation!");
        System.out.println("What would you like to do?");
        //menu options
        System.out.print("1. Power\n" + "2. Factorial\n" + "3. Summation\n" + "0. Exit the program\n");            
        //user input
        int userChoice= 0;
        Scanner userIn = new Scanner(System.in);
        userChoice = userIn.nextInt();
        if(userChoice == 0)
            return;//this exits the program
        //other menu options
        else{
         //power choice
            if(userChoice==1){
              try{
                System.out.print("Please enter desired number for power function: ");
                int num = userIn.nextInt();
                System.out.print("Please enter power you want your number raised to: ");
                int pow = userIn.nextInt();
                int val = power(num, pow);//call to power
                System.out.println(num + " raised to the power of "+ pow + " = " + val);
               }catch(InputMismatchException e){
                 System.out.println("Incorrect entry! Please enter a non-negative integer value.");
                } 
            }
            //factorial choice
            else if(userChoice==2){
               try{
                System.out.print("Enter desired number for factorial function: ");
                int num = userIn.nextInt();
                int fact = factorial(num);//call to factorial
                if(num <= 12){
                System.out.println("Factorial of " + num + " is " + fact);
                } else{//for upper limit factorial, send user back to menu
                     System.out.print("Upper limit for factorial is 12, please exit and try again. ");
                }
                }catch(InputMismatchException e){
                 System.out.println("Incorrect entry! Please enter a non-negative integer value.");
                }
            }
            
            else if(userChoice==3){
              try{
                System.out.print("Enter desired number for summation function: ");
                int num = userIn.nextInt();
                int sum = summation(num);//call to summation
                System.out.println("Summation value of " + num + " is " + sum);
                }catch(InputMismatchException e){
                 System.out.println("Incorrect entry! Please enter a non-negative integer value.");
                }
            }
            
            //incorrect entry, re-loop to menu
            else{
            
                System.out.println("Incorrect Input! Please enter a values between 0 and 3 according to the menu options.");
            }
           
            menu();
        }
       }catch(InputMismatchException e){//if user puts a word instead of number for menu
           System.out.println("Incorrect entry! Please enter a non-negative integer value.");
        } 
    }
    //calls recursive menu
    public static void main(String[] args){
    
        menu();
    }  
}