import java.util.*;
/**Arrays 
*@author Nanami Kimoto
*@since 102517
*/

public class ArraysRandomizer{
static final int SIZE = 50;
static final int limit = 45;
   public static void main (String [] args){
  //variables
  boolean exit = false;
   int i = 1;
   int counter= 0;
   int[ ] arNum = new int[51];
   int arLen = arNum.length;
   Random rand1 = new Random();
   String [] sNums = new String [51];
   String sTemp = "";
   
   System.out.println("I am storing up to " + 50 + " numbers");
      while((counter < 51) && (exit == false)){
           if(sTemp.length() < 1){
            exit = true; 
            }else{
            //counter for the numbers
            sNums[counter] = sTemp;
            counter++;
       }
	 }	 
   //for loop to print array numbers in random form
    for(i = 1; i < 51; i++){
    arNum[i] = rand1.nextInt(45);
    }
   
    System.out.println("Array: ");
    for( i = 1; i < 51; i++){
      System.out.println(i +": " +  arNum[i]);
    }   	   
  } 
}  
