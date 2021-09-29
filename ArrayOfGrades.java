import java.util.Scanner;
/**
* Program for collecting grades and determining average. 
* @author Nanami Kimoto
* @year 2018
*/

public class ArrayOfGrades{
    /**constant declaration.*/
   static final int SIZE = 10;
   /** 
   * main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
   
      int count = 0; //counter
       
      double[ ] dArray = new double[SIZE]; //declare empty array
      Scanner sc = new Scanner(System.in);
      
      
      System.out.println("I will store up to " + SIZE + " grades");
      System.out.println("Then, I will compute the average of those grades.");
      
      double dTotal = 0; //accumulator for calculating average
      int arrLen = dArray.length; //get length of array
      boolean exit = false; //for blank lines (press enter to quit)
      String s1 = "";
      //loop for boolean and counter
      while ((count < SIZE) && (!exit)) {
         System.out.println("Please enter values of grades 0-100.");
         System.out.print("Enter a grade " + (count + 1) + ": ");
        //try catch block for nfe
         try {
            s1 = sc.nextLine();
         
            if (s1.length() < 1) { //condition
               exit = true; //boolean exit
            } else { //return to counter 
          //parse and store in array
               dArray[count] = Double.parseDouble(s1); 
               count++; 
            }
         
         } catch (NumberFormatException nfe) {
            System.out.println("You didn't enter a valid grade, try again.");
         }            	 
      } //ends while
    
      System.out.println("Valid grades entered: ");
      for (int i = 0; i < arrLen; i++) {
         System.out.println(dArray[i]);
      }	 
    
      System.out.println("Average of grades calculation: ");
      //loop for average
      for (int i = 0; i < arrLen; i++) {
         dTotal += dArray[i]; //adds all grades 
         
         
      }
      //calculate and print the average
      System.out.println("Average percentage is " + dTotal 
            + "/" + arrLen + " = " + dTotal / arrLen);  
    
      System.out.println("Program finished."); 	
   } //main
} //class