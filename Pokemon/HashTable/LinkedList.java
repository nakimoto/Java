/**
 * A generic list of linked nodes.
 * Also has a driver main method.
 * @param <T> the type of object list holds.
 * @author Lisa Miller from William Albritton
 * @since 10/1/2017
 */
public class LinkedList<T> implements ListInterface<T> {

	/** reference to first node in the linked list (linked nodes). */
   protected Node<T> head = null;
	/**Total number of items, used
	*for error checking and node removal.*/
   protected Integer size = new Integer(0);

	/** Constructor with no parameters. */
   public LinkedList() {
   	// no code, because data fields already initialized
   }

	/**
	 * Adds an item to the end of the list.
	 * 
	 * @param item the object to add to the list
	 */
   public void add(T item) {
   	// case 1: if empty list
      if (head == null) {
      	// list is empty, so add to beginning of list
      	// make new node and assign to head of list
         head = new Node<T>(item, null);
      }
      // if not empty list
      else {
      	// case2: add to end of list
      	// current starts at 2nd node in list
         Node<T> previous = head;
         Node<T> current = head.getNext();
      	// while not at end of list
         while (current != null) {
         	// advance to next node
            previous = current;
            current = current.getNext();
         }
      	// Add new node to end of list:
      	// Make new node that has "null" for next.
      	// A node with "null" is always the last node
         Node<T> node = new Node<T>(item, null);
      	// Point previous node (last node) to new node
         previous.setNext(node);
      }
   	// increase size of list
      size++;
   }
   
   
   	/**
	 * Adds an item to the beginning of the list.
   *
   * Old head becomes head.next
	 * 
	 * @param item the object to add to the list
	 */
   public void addFirst(T item) {
      head = new Node<T>(item, head);
      size++;
   }

	/**
	 * Gets an item (address to an item) from the list.
	 * 
	 * @param position
	 *            The position of an item in the list.
	 * @return the address to the requested item
	 * @exception ListException
	 *                if an item does not exist at that position
	 */
   public T get(Integer position) throws ListException {
   	// check if empty list
      if (head == null) {
         throw new ListException("Cannot get an item from an empty list!");
      }
   	// if position is outside range, throw exception
      if (position < 1 || position > size) {
         throw new ListException(position + " is outside list range!");
      }
   	// Find node:
   	// counter to keep track of loops
      Integer counter = new Integer(1);
   	// point to current node
      Node<T> current = head;
      while (!counter.equals(position)) {
      	// BAD CODE: while(counter != position){
      	// goto next node for current pointer
         current = current.getNext();
      	// add 1 to counter
         counter++;
      }
   	// return the data (item) stored by the node
      return current.getData();
   }
   
   	/**
	 * Removes the first item in the list.
   * @return the data in removed node or null
	 */
   public T removeFirst() {
      Node<T> temp = head;
      if (head != null) {
         head = head.getNext();
      }
      if (temp != null) {
         size--;
         return temp.getData();
      } else {
         return null; 
      }
   }

	/**
	 * Removes an item from a list.
	 * 
	 * @param position
	 *            The position of an item in the list.
	 * @exception ListException
	 *                if an item does not exist at that position
	 */
   public void remove(Integer position) throws ListException {
   	// check if empty list
      if (head == null) {
         throw new ListException("cannot remove from empty list");
      }
   	// if position is outside range, throw exception
      if (position < 1 || position > size) {
         throw new ListException(position + " is outside list range.");
      }
   	// if at beginning of list
      if (position.equals(1)) {
      	// remove 1st node
         head = head.getNext();
      }
      // if not at beginning of list
      else {
      	// Find node:
      	// point previous to 1st node
         Node<T> previous = head;
      	// point current to 2nd node
         Node<T> current = head.getNext();
      	// loop position-2 number of times
         for (int i = 2; i < position; i++) {
         	// goto next node for previous and current
            previous = current;
            current = current.getNext();
         }
      	// Point the previous node to node after current node.
      	// This "skips" over one node, thus removing it!
         previous.setNext(current.getNext());
      }
   	// decrease size of list
      size--;
   }


	/**
	 * Removes an item from a list.
	 * 
	 * @param item the thing to remove
	 * @return thing removed, or null if not found in table
	 */
   public T remove(T item) {
      // point to current node
      boolean match = false;
      Node<T> dummy = new Node<>(item);
      Node<T> current = head;
      Node<T> prev = head;
      if (head == null) {
         return null;
      } else if (dummy.getData().equals(current.getData())) {
         head = head.getNext();
         return item;
      } else {
        //look for thing in the list
         while (!match && current != null) {  
            prev = current;     
            current = current.getNext();
            if (current != null) {
               match = item.equals(current.getData());
            }
         }
         if (match) { //its there remove it
          // Point the previous node to node after current node.
            prev.setNext(current.getNext());
            return current.getData();
         } else {
            return null;
         }
      }
   
   }
   
	/**
	 * Finds an item in the list.
	 * 
	 * @param item The item being looked for.
	 * @return true if item in the list, false if not found.
	 */
   public boolean find(T item) {
      boolean match = false;
      // point to current node
      Node<T> current = head;
      T currItem = head.getData();
   	  // check if empty list
      if (head == null) {
         return false;
        
      } else {
        //else Find node:      
         while (!match && current != null) {     
            match = item.equals(current.getData());       
            current = current.getNext();
         
         }
      // return result
         return match;
      }
   }


	/**
	 * Counts number of unique items in list.
	 * 
	 * @return The number of unique items in the list.
	 */
   public int countUniques() {
      
      boolean isUnique = false;
      // point to current node
      Node<T> current = head;
      Node<T> matcher;
      int numberOfUniques = 0;
      
   	  // check if empty list
      if (head == null) {
         return 0;
        
      } else {
        //else Find node:      
         while (current != null) { //outer loop    
            isUnique = true;
            matcher = current.getNext();
         
            while (matcher != null) { //inner loop
               if (matcher.getData().equals(current.getData())) {
                  isUnique = false;
               }
               matcher = matcher.getNext();
            }
            if (isUnique) {
               numberOfUniques++;
            }
         
               
            current = current.getNext();
         
         }
      // return result
         return numberOfUniques;
      }
   }

	/**
	 * Automatically called by println() or print().
	 * 
	 * @return a String of the List 
	 */
   public String toString() {
   	// instantiate empty string
      String s = new String("");
   	// loop through all the nodes in linked list
      for (Node<T> current = head; current != null; current = current
      		.getNext()) {
      	// keep adding to end of string
         s = s + current.toString() + ", ";
      	// add one to position for each loop
      }
      return s;
   }

	/**
	 * This Is An "Accessor" Method - Used To Get A Data Field.
	 * 
	 * @return the size of the list
	 */
   public Integer getSize() {
      return size;
   }
   
   /***************** DRIVER *****************************/

	/**
	 * Method main is used as a driver to test the class.
	 * 
	 * @param args
	 *            Not used.
	 */
   public static void main(String[] args) {
   	// Test list of Strings:
   	// test construtor
      System.out.println("test construtor");
      ListInterface<String> list = new LinkedList<String>();
   	// test toString() for empty list
      System.out.println("empty list: " + list.toString());
      String letter = new String("A");
   	// test add
      System.out.println("test add() 1 node");
      list.add(letter);
   	// test toString() for list of 1
      System.out.println("list of 1:\n" + list.toString());
   	// test add() for several nodes
      System.out.println("test add() several nodes");
      letter = new String("B");
      list.add(letter);
      letter = new String("C");
      list.add(letter);
      letter = new String("D");
      list.add(letter);
   	// test toString() for empty list of many
      System.out.println("list of many:\n" + list.toString());
   	// test get
      Integer currentSize = list.getSize();
      letter = list.get(currentSize);
      System.out.println("test get(), letter: " + letter);
   	// test remove
      System.out.println("remove #1 and 3: ");
      list.remove(3);
      list.remove(1);
      System.out.println(list.toString());
   	// test remove
      System.out.println("remove #2, 1: ");
      list.remove(2);
      list.remove(1);
      System.out.println(list.toString());
   } // end of main

} // end of class
