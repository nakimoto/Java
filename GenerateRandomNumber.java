import java.util.*;

/*
*@author Nanami Kimoto
* Generating random numbers
*@year 2017
*/
class GenerateRandomNumber {
   public static void main(String[] args) {
      int inum1=0;
      int inum2=0;
      Random rNum = new Random();
      /* Below code would generate 5 random numbers
       * between 0 and 200.
       */
       System.out.println("Random numbers: ");
      for (inum1 = 1; inum1 <= 20; inum1++) {
         System.out.println(rNum.nextInt(777));
      for (inum2=0; inum2<=20; inum2++)
      System.out.println(rNum.nextInt(751));  
   }
  }
}