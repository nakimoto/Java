import java.util.*;
/**
*Program that takes a number input and gives a letter output for grading. 
*@author Nanami Kimoto
*@year 2017
*/

public class Grades {
   public static void main (String [] args) {
      //variable declaration
      Scanner reader = new Scanner (System.in);
      //asking user to input score
      System.out.print("Please enter a score between 0 and 100: ");
      double score = reader.nextDouble();
      //score calculation using series of if else if statements 
      if (score >0&&score<60.0) {
          System.out.println("Your grade is an F.");
      } else if(score >=60.0 && score <=69.0) {
          System.out.println("Your grade is a D.");
      } else if(score >=70.0 && score <=79.0) {
          System.out.println("Your grade is a C.");
     } else if(score >=80.0 && score <=89.0) {
          System.out.println("Your grade is a B.");
     } else if(score >=90.0 && score <=100) {
          System.out.println("Your grade is an A.");
    }
  }
}
   