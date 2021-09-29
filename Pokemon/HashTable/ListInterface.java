/**
 * A generic interface for a list.
 * @author Lisa Miller from:
 * @author William McDaniel Albritton
 * @since 2/12/2018
 * @param <T> The type of data held in the list.
 */
public interface ListInterface<T> { //"public" is implied

	/**
	 * Adds an item to the end of the list.
	 * 
	 * @param item
	 *            is the object that is added to the list
	 */
   void add(T item);  //"public" is implied

   	/**
	 * Adds an item to the beginning of the list.
	 * 
	 * @param item the object to add to the list
	 */
   void addFirst(T item);
    
    
	/**
	 * Gets an item (address to an item) from the list.
	 * 
	 * @param position
	 *            The position of an item in the list.
	 * @return the address to the requested item
	 * @exception ListException
	 *                if an item does not exist at that position
	 */
   T get(Integer position) throws ListException; //"public" is implied


   
   
   /**
	 * Removes the first item in the list.
   * @return the data in removed node or null
	 */
   T removeFirst();
   
   	/**
	 * Removes an item from a list.
	 * 
	 * @param position
	 *            The position of an item in the list.
	 * @exception ListException
	 *                if an item does not exist at that position
	 */
   void remove(Integer position) throws ListException; //"public" is implied
   
	/**
	 * Finds an item in the list.
	 * 
	 * @param item The item being looked for.
	 * @return true if item in the list, false if not found.
	 */
   boolean find(T item);
   
   	/**
	 * Counts number of unique items in list.
	 * 
	 * @return The number of unique items in the list.
	 */
   int countUniques();

	/**
	 * This Is An "Accessor" Method - Used To Get A Data Field.
	 * 
	 * @return the size of the list
	 */
   Integer getSize(); //"public" is implied

} // end of interface

// *************************************************************************

/**
 * Used for all List exceptions.
 */
class ListException extends RuntimeException {
	/**
	 * @param message
	 *            describes the exact cause of the error.
	 */
   ListException(String message) {
      super(message);
   } // end of constructor
} // end of class

// *************************************************************************

