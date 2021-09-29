/**
* HashTable.
*
* @author 
* @since
* @param <T> The type of object table holds
*/

public class MyHashTable<T> {
   



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
      MyHashTable<String> t = new MyHashTable<>();
      
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
  
/*********** Driver output *********************
table: 
table[0] = 
table[1] = 
table[2] = 
table[3] = 
table[4] = 
table[5] = 
table[6] = 
table[7] = 
table[8] = 
table[9] = 

table size: 0
table is empty? true
putting at index: 6
putting at index: 2
putting at index: 5
putting at index: 4
putting at index: 8
table: 
table[0] = 
table[1] = 
table[2] = cat, 
table[3] = 
table[4] = dog, 
table[5] = horse, 
table[6] = CAT, 
table[7] = 
table[8] = Kapiolani CC, 
table[9] = 

table size: 5
table is empty? false
putting at index: 9
putting at index: 0
putting at index: 9
putting at index: 1
putting at index: 7
table: 
table[0] = pig, 
table[1] = elephant, 
table[2] = cat, 
table[3] = 
table[4] = dog, 
table[5] = horse, 
table[6] = CAT, 
table[7] = rat, 
table[8] = Kapiolani CC, 
table[9] = cow, chicken, 

table size: 10
table is empty? false
putting at index: 3
putting at index: 8
putting at index: 3
putting at index: 2
putting at index: 8
putting at index: 4
putting at index: 0
putting at index: 1
putting at index: 5
putting at index: 3
table: 
table[0] = pig, snake, 
table[1] = elephant, gecko, 
table[2] = cat, hound, 
table[3] = mouse, fox, butterfly, 
table[4] = dog, hippo, 
table[5] = horse, mosquito, 
table[6] = CAT, 
table[7] = rat, 
table[8] = Kapiolani CC, vole, owl, 
table[9] = cow, chicken, 

table size: 20
table is empty? false
remove cow
cow
table: 
table[0] = pig, snake, 
table[1] = elephant, gecko, 
table[2] = cat, hound, 
table[3] = mouse, fox, butterfly, 
table[4] = dog, hippo, 
table[5] = horse, mosquito, 
table[6] = CAT, 
table[7] = rat, 
table[8] = Kapiolani CC, vole, owl, 
table[9] = chicken, 

table size: 19
table is empty? false
remove CAT
CAT
table: 
table[0] = pig, snake, 
table[1] = elephant, gecko, 
table[2] = cat, hound, 
table[3] = mouse, fox, butterfly, 
table[4] = dog, hippo, 
table[5] = horse, mosquito, 
table[6] = 
table[7] = rat, 
table[8] = Kapiolani CC, vole, owl, 
table[9] = chicken, 

table size: 18
table is empty? false
remove item not there DOG
null
table: 
table[0] = pig, snake, 
table[1] = elephant, gecko, 
table[2] = cat, hound, 
table[3] = mouse, fox, butterfly, 
table[4] = dog, hippo, 
table[5] = horse, mosquito, 
table[6] = 
table[7] = rat, 
table[8] = Kapiolani CC, vole, owl, 
table[9] = chicken, 

table size: 18
table is empty? false
putting at index: 6
table: 
table[0] = pig, snake, 
table[1] = elephant, gecko, 
table[2] = cat, hound, 
table[3] = mouse, fox, butterfly, 
table[4] = dog, hippo, 
table[5] = horse, mosquito, 
table[6] = CAT, 
table[7] = rat, 
table[8] = Kapiolani CC, vole, owl, 
table[9] = chicken, 

table size: 19
table is empty? false
get cat
cat
get DOG
null
*/