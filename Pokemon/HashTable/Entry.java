
/** 
* EntryTable A7.
* @author Nanami Kimoto
* @since 4/5/19
* @param <V> The type of object table holds.
*/
public class Entry<V> {
 /**
   * constant.
   */ 
   private int Key = 0;
    /**
   * constant.
   */
   private V Value = null;
 /**
   * Entry method.
   *@param input.
   */
   public Entry(V input) {
      Value = input;
      Key = Math.abs(Value.hashCode());
 
   } //close method
 
  /**
   * Get key.
   * @return Key.
   */ 
   
   public int getKey() {
      return Key; 
   }
/**
   * Get Value.
   * @return Value.
   */ 
   public V getValue() {
      return Value;
   }
 
 /**
   * set key.
   *@param Type1 the type.
   */ 
   private void setKey(int Type1) { //set key to type1 variable
      Key = Type1;
   }
  /**
   * set Value.
   *@param Type2 the type.
   */ 
   private void setValue(V Type2) { //Set value to type2 variable
      Value = Type2;
   }
 /**
   * toString method.
   * @return s1.
   */ 
   public String toString() {
      String s1 = Value.toString();
   
      return s1;
   }
  
    /**
* for comparing.
* @param other Entry to compare with
* @return true if they are the same, false otherwise
*/

   @SuppressWarnings("unchecked")
public boolean equals(Object o) {
      if (this.getClass().isInstance(o)) {
         Entry<V> toCompare = (Entry<V>) o;
         if (this.Key == toCompare.getKey() 
             && this.Value.equals(toCompare.getValue())) {
            return true;
         }
      }       
      return false;
   }
}
   
   
 
 
 




