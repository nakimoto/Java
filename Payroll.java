import java.util.*; //general and random number generator
import java.util.Arrays; //arrays
import java.util.Scanner; //scanner input
import java.text.*; //decimal formatter if needed
/**
*@author Nanami Kimoto
*@year 2019
*NOTES: 2d array passes but prints out strange characters, not any values or anything. 
*The loop prints total pay at 14.75 an hour for under 40 hours. 
*when it is over 40 hours, it prints out "overtime hours for this employee" but not the regular pay.
*code revisit: horrific indentions, messy code. 
*/
   //constants
   static final int WORKDAYS = 5;//max work days 
   static final double OVERPAY = 21.75;//overtime pay rate
   static final double REGPAY = 14.75; //regular pay rate
   //main method
   public static void main(String args[]) {
      //variable declarations
      //2d array  
      int[][] employInfo = new int[20][5];
      Random randNum = new Random();//random generator
      int rand = 0;
      Scanner userIn = new Scanner(System.in);//scanner for user input
      //beginning message to user
      System.out.println("This program will calculate payroll information.");
      System.out.println("Please enter a minimum of five employees up to a maximum of twenty only");
      String sInput = new String("");//input string for scanner
      System.out.println("\nHow many employees would you like payroll information for?");
      //try catch for nfe
      try{    
         sInput = userIn.nextLine();//user input for employees 
         int numEmployee = Integer.parseInt(sInput);//parse string into int
         //validation for user input 
         if((numEmployee >4) && (numEmployee < 21)){
            //loop through array to populate
            System.out.println("\t\t\t\t MON  TUES  WED  THURS  FRI");
            for (int row = 0; row < employInfo.length; row++) {
               for (int col = 0; col < employInfo[row].length; col++){
                  rand =  randNum.nextInt(13);//generate random numbers between 0-12
                  employInfo[row][col] = rand;//to populate
               }//close for
            }//close for
         }else{
            System.out.println("Enter a value between 5 and 20. Please rerun program and try again."); 
            System.exit(0);
         }//close else
         double total = 0.0;//for pay         
         for (int row = 0; row < numEmployee; row++) {
            System.out.printf("Employee %d: ", row+1);//to loop and print
            for (int col = 0; col < employInfo[row].length; col++) {
               System.out.printf("%3d\t", employInfo[row][col]);//to loop and print
               total = employInfo[row][col] + total; 
            }//close for
            //printing out overtime pay
            System.out.println("Total hours worked: " + total);
            double over=(total-40.0);//subtract 40 from total hours to get overtime hours
            if(total> 40) {
               System.out.println("This employee's overtime pay: " + (over * OVERPAY));
                  //printing out regular pay
            }else{  
               total= total* REGPAY;
               System.out.println("Total pay: " + total);
               total =0;
            }//close else
         }//close for 
      }catch(NumberFormatException nfe){//if non-integer is entered
         System.out.println("Integer not entered! Please rerun the program and try again!");
      }
      //send method
      calculatePayroll(employInfo);
   }//close main method
      //calculatePayroll method here
   public static void calculatePayroll(int[][]overtime) {
      System.out.println(overtime);//call method, new array is overtime
   }//close second method
}//close class

