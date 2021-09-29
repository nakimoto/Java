import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.Deque;

/**
* Queue and stack for A6.
* @author Nanami Kimoto
* @since 3/31/19
*/
public class PriorityQueueStack {
  /**
   * Main method for deck and queue.
   * @param args not used.
   */
   public static void main(String[] args) {
   
      /** Pokemon Stack. */
      Deque<Pokemon> ps = new ArrayDeque<Pokemon>();
      
      /** Pokemon Queue. */
      PriorityQueue<Pokemon> pq = new PriorityQueue<Pokemon>();
      
      /**
       * Using a temp to store name.
       */
       
      Pokemon pTemp = new Bulbasaur();
      int a = 0;
      
      /** For loop to add Pokemon. */
      for (a = 0; a < 10; a++) {
      
         /** Pokemon names. */
         pTemp = new Bulbasaur("Pon");
         pq.add(pTemp);
         ps.push(pTemp);
         
         pTemp = new Squirtle("Maru");
         pq.add(pTemp);
         ps.push(pTemp);
         
         pTemp = new Charmander("Azuki");
         pq.add(pTemp);
         ps.push(pTemp);
         
         pTemp = new Ivysaur();
         pq.add(pTemp);
         ps.push(pTemp);
         
         pTemp = new Wartortle();
         pq.add(pTemp);
         ps.push(pTemp);
         
         pTemp = new Charmeleon();
         pq.add(pTemp);
         ps.push(pTemp);
         
         pTemp = new Venusaur();
         pq.add(pTemp);
         ps.push(pTemp);
         
         pTemp = new Blastoise();
         pq.add(pTemp);
         ps.push(pTemp);
         
         pTemp = new Charizard();
         pq.add(pTemp);
         ps.push(pTemp);
         
      }
      
      /** Printing the priority queue. */
      System.out.println("___________");
      System.out.println("\nNow printing the Priority Queue:\n");
      while (pq.size() > 0) {
      
         Pokemon cs = pq.poll();
         System.out.println(cs.toString() + "\n");
      }
      
      /** Printing the stack. */
      System.out.println("__________");
      System.out.println("\nNow printing the Stack:\n");
      while (ps.size() > 0) {
      
         Pokemon currentStack = ps.pop();
         System.out.println(currentStack.toString() + "\n");
      }
      
   } //close method
   
} //close class

