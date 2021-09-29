import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *@author Nanami Kimoto
 *@year 2019
 *For option 4, it continues to print a loop of snacks entered if user didn't enter 5 (constant value) snacks
 *it will print null for all spaces if the user enters no snacks
 *Tried to use DecimalFormat df = new DecimalFormat("#,###,##0.00"); but it threw an error for "cannot format value" for menu option 3
 */

public class VendingMachine{
   //constants
   static final int STORE = 5;

   public static void main(String[] arg) throws SnackException{
      
         //variables
         
         int userInput = 0; 
         int barcode = 0;
         int calories = 0;
         double price = 0.0;
         String name = "";
         Snack [] snackArray = new Snack[STORE];
         boolean exit = true; 
         
         System.out.println("Welcome to The Vending Machine!");
         System.out.println("This program will store up to " +STORE+ " of your snacks inside.");
         System.out.println("You may add, remove, list snacks that cost more than given price, and list all snacks available.");
         
         try{
         //import scanner to receive user input
         Scanner intReader = new Scanner(System.in);
         Scanner dReader = new Scanner(System.in);
         Scanner sReader = new Scanner(System.in);
         
         //menu
         while(true){
            System.out.println("\n1. Add a snack");
            System.out.println("2. Remove a snack");
            System.out.println("3. Print all snacks that cost more than your given price");
            System.out.println("4. Print all snacks");
            System.out.println("0. End this program");
            System.out.println("\nWhat would you like to do?");
            userInput = intReader.nextInt();
            
            switch(userInput){ 
               
               //add a snack requirement
               
               case 1:
                  //required information from user 
                  System.out.println("What is the snack's barcode? ");
                  barcode = intReader.nextInt();
                  System.out.println("What is the snack's calories? ");
                  calories = intReader.nextInt();               
                  System.out.println("What is the snack's price? ");
                  price = dReader.nextDouble();
                  System.out.println("What is the snack's name? ");
                  name = sReader.nextLine();
                  //using driver class to add info
                  Snack newSnack = new Snack(barcode, calories, price, name);
                  for(int i = 0; i<snackArray.length; i++){
                     if(snackArray[i] == null){
                        snackArray[i] = newSnack;
                        i++;//store in array
                    }
                  }  
                  break;
               
               //remove barcode, otherwise tell user that is doesn't exist
               case 2:
                  intReader = new Scanner(System.in); //resets int scanner for int input ONLY
                  System.out.println("Please enter barcode of the snack you would like to remove.");
                  barcode = intReader.nextInt();
                     for(int i = 0; i < snackArray.length; i++){
                        if((snackArray[i] != null) && (snackArray[i].getBarcode() == barcode)){
                        snackArray[i] = null;
                        break;
                        }
                        else if(i == snackArray.length - 1){
                           System.out.println("No such snack exists! " + barcode);   
                        } 
                     }
                     break; 
               
               //for printing snacks of prices higher than given
               case 3:
                  double snackPrice = 0.0;
                  dReader = new Scanner(System.in); //resets souble scanner for double input ONLY
                  System.out.println("Please enter a price between $1.00 and $5.00.");
                  snackPrice = dReader.nextDouble();
                  if(snackPrice >= 1.0 || snackPrice <= 5.0){
                     for(int i = 0; i < snackArray.length; i++){
                        if(snackPrice < snackArray[i].getPrice()){
                           System.out.println(snackArray[i]);
                        }  
                     }
                  }
                  else{
                     System.out.println("Please enter a price between $1.00 and $5.00");
                  }
                  break;  
               
               //print all available snacks
               case 4:
                     System.out.println("Available snacks: " + Arrays.toString(snackArray));
                     
                  break;
               
               //to exit
               case 0:
                  System.out.println("Ending program...");
                  System.exit(0);//ends program here
                  break; 
               
               default :
                  System.out.println("Returning to menu...");
                  break;
            } 
         }   
      }  
      //if user enters things other than integers such as letters or symbols
      catch(InputMismatchException ime){
         System.out.println("Please type 0, 1, 2, 3, or 4 according to menu directions.");
      }
      catch(NullPointerException npe){
         System.out.println("No snacks are currently stored! Please return to the menu and choose a different option.");
      }
      catch(SnackException se){//intercation with snackexception.java
         System.out.println(se.getMessage());
      }
     
   }
  
}