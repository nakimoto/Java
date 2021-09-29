/** 
* Hashtable A7.
* @author Nanami Kimoto
* @since 4/5/19
* @param <T> The type of object table holds
*/



public class HashTable<T> {
/** size constant. */
   private static final int MAX_SIZE = 10;
/** counter constant. */
   private int counter = 0;

/** array of LinkedLists. */
   @SuppressWarnings("unchecked")
 
private LinkedList<Entry<T>>[] table = new LinkedList[MAX_SIZE];
/** Hashtable method. */
   public HashTable() {

      for (int i = 0; i < 10; i++) {
         table[i] = new LinkedList<Entry<T>>();
      } //close for loop
   } //close constructor
   
/** Put method.
*@param item.
*/
   public void put(T item) { 
      Entry<T> e = new Entry(item);
      int index = (e.getKey()) % MAX_SIZE;
      table[index].add(e);
      System.out.println("Putting at index: " + index);
      counter++;
   } //close method
/** Get method. 
*@return item.
*/   
   public T get(T item) {
      int index = Math.abs(item.hashCode()) % MAX_SIZE;
      if (table[index].find(new Entry(item))) {
         return item;
      } else {
         return null;
      } //close loop
   } //close method
 /** Remove method.
 *@return item.
  */
   public T remove(T item) {
      int index = Math.abs(item.hashCode()) % MAX_SIZE;
      if (table[index].find(new Entry(item))) {
         table[index].remove(new Entry(item));
         counter--;
         return item;
      } else {
         return null;
      } //close loop
  
   } //close method
 /** isEmpty method. 
 *@return true.
 */
   public boolean isEmpty() {
      if (counter == 0) {
         return true;
      } else {
         return false;
      } //close loop
   } //close method
 /** Size method.
 *@return counter.
  */
   public int size() {
      return counter;
   } //close method
   
   
 
     
//******** provided stuff *******************/
   
   /** makes a String representation of the table.
   * Provided with assignment
   * @author Lisa Miller
   * @return a String representation of the table
   */
     
   
   public String toString() {
      String s = "";
      
      for (int i = 0; i < MAX_SIZE; i++) {
         s = s + "table[" + i + "] = ";
         s = s + table[i] + "\n"; //linked list has toString method
       
      }
      return s;
   }
   
  //****************** DRIVER *******************************/
   /** For testing hash table code.
   * Provided with assignment
   * @author Lisa Miller
   * @since 4/16/2018
   * @param args not used.
   */
   
   public static void main(String[] args) {
      HashTable<String> t = new HashTable<>();
      
      System.out.println("table: \n" + t);
      System.out.println("table size: " + t.size());
      System.out.println("table is empty? " + t.isEmpty());
      t.put("CAT");
      t.put("cat");
      t.put("horse");
      t.put("dog");
      t.put("Kapiolani CC");
      
      System.out.println("table: \n" + t);
      System.out.println("table size: " + t.size());
      System.out.println("table is empty? " + t.isEmpty());
      
      t.put("cow");
      t.put("pig");
      t.put("chicken");
      t.put("elephant");
      t.put("rat");
      //table has to have one chain at least now
      System.out.println("table: \n" + t);
      System.out.println("table size: " + t.size());
      System.out.println("table is empty? " + t.isEmpty());
      
      t.put("mouse");
      t.put("vole");
      t.put("fox");
      t.put("hound");
      t.put("owl");
      t.put("hippo");
      t.put("snake");
      t.put("gecko");
      t.put("mosquito");
      t.put("butterfly");
      //20 items now
      System.out.println("table: \n" + t);
      System.out.println("table size: " + t.size());
      System.out.println("table is empty? " + t.isEmpty());
      
      //test remove
      System.out.println("remove cow");
      System.out.println(t.remove("cow"));
      System.out.println("table: \n" + t);
      System.out.println("table size: " + t.size());
      System.out.println("table is empty? " + t.isEmpty());
       
      //test remove
      System.out.println("remove CAT");
      System.out.println(t.remove("CAT"));
      System.out.println("table: \n" + t);
      System.out.println("table size: " + t.size());
      System.out.println("table is empty? " + t.isEmpty());
      
      System.out.println("remove item not there DOG");
      System.out.println(t.remove("DOG"));
      System.out.println("table: \n" + t);
      System.out.println("table size: " + t.size());
      System.out.println("table is empty? " + t.isEmpty());
      
      //add CAT back in
      t.put("CAT");
      System.out.println("table: \n" + t);
      System.out.println("table size: " + t.size());
      System.out.println("table is empty? " + t.isEmpty());
      
      
      
     //test get method
      System.out.println("get cat");
      System.out.println(t.get("cat"));
     
      System.out.println("get DOG");
      System.out.println(t.get("DOG"));
      
   }
   
} //close class
