/**
* PokeNode.
* @author Nanami Kimoto
* @since 4/22/19
* @param <P> Pokemon data held in Nodes.
*/
public class PokeNode<P> {

   
   /** Pokemon Data held in Node. */
   private Pokemon data;
   /** Number of when Pokemon was caught. */
   private int num;
   /** Link to Left child Node. */
   private PokeNode<P> left;
   /** Link to Right child Node. */
   private PokeNode<P> right;
   
   /**
   * CONSTRUCTOR.
   * @param P           Stored Pokemon object.
   * @param numCaught   Pokemon Caught.
   * @param lChild      Left child.
   * @param rChild      Right child.
   */
   public PokeNode(Pokemon p, int numCaught,
         PokeNode lChild, PokeNode rChild) {
      //Exception handling.
      if (p != null) {   
      data = p; 
      } else {
         System.out.println("Pokemon should be a non-null object.");
      }
      //loop for checking.
      if (numCaught >= 1) {
      num = numCaught; 
      } else {
         System.out.println("Value should be at least 1.");
      }
      
      left = lChild;
      right = rChild;  
   }  
   
   
   /**
   * GetPokemon Method.
   * returns Pokemon object from node.
   */
   public Pokemon getPokemon( ) {
      return data;
   }
   
   /**
   * GetKey Method.
   * return Pokemon number.
   */
   public int getKey( ) {
    return data.getNumber();
   }
   
    /**
   * GetNumCaught Method.
   * return the numCaught catch number of pokemon.
   */
   public int getNumCaught( ) {
      return num;
   }
   
   /**
   * GetLChild Method. 
   * return Left child.
   */
   public PokeNode getLChild( ) {
      return left;
   }
   
   /**
   * GetRChild Method.
   * return Right child.
   */
   public PokeNode getRChild( ) {
      return right;
   }
   
   /**
   * IncreaseNumCaught method.
   * increments the numCaught.
   */
   
   public void increaseNumCaught( ) {
      num++;
   }

   /**
   * DecreaseNumCaught method.
   * decrements the numCaught.
   * throws an exception for invalid value.
   */
   public void decreaseNumCaught( ) {
      num++;
   }

   /**
   * SetLChild Method.
   * sets newLNode as the left child.
   * @param newLChild  New left child.
   */
   public void setLChild(PokeNode newLChild) {
      left = newLChild;
   }
   
   /**
   * SetRChild Method.
   * sets newLNode as the right child.
   * @param newRChild   New right child.
   */
   public void setRChild(PokeNode newRChild) {
      right = newRChild;
   }



}

