/**
* PokeTree.
* @author Nanami Kimoto
* @since 4/22/19
* @param <P> Pokemon.
*/
public class PokeTree<p> {

   /** Root node. */
   private PokeNode<p> root = null;
   
   private static int plus = 0;
   
   /**Empty constructor for use.*/
   public PokeTree( ) {
      
   }
   
/** Add Method **/

   /** Adds a Pokemon object to the tree.
   * Non-recursive wrapper method
   * @param p  The Pokemon to be added.
   */
   public void add(Pokemon p) {
   
      root = add(root, p);
   }

   /** Recusively adds an item to the tree.
   * @param node  The root of the binary search tree.
   * @param p  The Pokemon to be added.
   * @return The node.
   */
   private PokeNode add(PokeNode node, Pokemon p) {
   
   
      if (node == null) {
      
         node =  new PokeNode<p>(p, 1, null, null);
         for (int i = 0; i < plus; i++) {
            node.increaseNumCaught();
         }
         return node;
      }
     //left child.
      else if (p.getNumber() < node.getPokemon().getNumber()) {
      //loop for caught pokemon.
         if (p.getNumber() == node.getPokemon().getNumber()) {
            plus = node.getNumCaught();
         }
         node.setLChild(this.add(node.getLChild(), p));
         
         return node;
      }
     //move to the right node. 
      else {
      //loop for getting pokemon.
         if (p.getNumber() == node.getPokemon().getNumber()) {
            plus = node.getNumCaught();
         }
         node.setRChild(this.add(node.getRChild(), p));
         
         return node;
      }
   }
/** Remove Method **/
   
   /** Removes a Pokemon from the tree.
   * @param p Pokemon object to remove.
   */
   public void remove( Pokemon p) {
      root = this.remove(root, p);
   }

   /**Recursively removes the Pokemon from the tree.   
   * @param node  The root of the binary search tree.
   * @param p Pokemon to be removed.
   * @return the root.
   * @throws RuntimeException if item not found.
   */
   private PokeNode remove(PokeNode node, Pokemon p) {
      //exception handling.
      if (node == null) {
         throw new RuntimeException("Not found!");
      }
      else if (p.getNumber() == node.getKey()
               && p.getName().equals(node.getPokemon().getName())){
      
         node = null;  
         return node;
      }
      
      //left if value is lass than.
      else if (p.getNumber() < node.getKey()) {
         node.setLChild(this.remove(node.getLChild(), p));
         return node;
      }
      //right if the value is more than the node. 
      //deletes node if correct ket is found. 
      else {
         node.setRChild(this.remove(node.getRChild(), p));
         return node;
      
      
      }
   }
   



/** Get Method **/

   /** gets an item from the tree with search key.
   * @param searchKey The search key.
   * @return the Pokemon object to be returned.
   */
   public Pokemon get(Pokemon searchKey) {
      return this.get(root, searchKey);
   }

   /** Recursive method.
   * @param node The root of the binary search tree.
   * @param searchKey To search for value or object.
   * @return the Pokemon object if found.
   * @throws RuntimeException if item not found during the search.
   */
   
   private Pokemon get(PokeNode node, Pokemon searchKey) {
   //exception handling.
      if (node == null) {
         throw new RuntimeException("Not found!");
      } 
      else {
      //return address if key is found.
         if (searchKey.getNumber() == node.getKey()
               && searchKey.getName().equals(node.getPokemon().getName())) {
            return node.getPokemon();
            
         }
         //searching left node.
         else if (searchKey.getNumber() < node.getKey()) {
            return this.get(node.getLChild(), searchKey);
         }
         //searching right node.
         else {
            return this.get(node.getRChild(), searchKey);
         }
      }
   }



   /** In-order transversal print method. */
   
   public void printPokeTree() {
      this.printPokeTree(root);
   }
   
   /** In-order print method.
   * @param root  The root of the binary search tree.
   */
   private void printPokeTree(PokeNode root) {
      try {
         if (root != null) {
            printPokeTree(root.getLChild());
            System.out.println("  " + root.getPokemon( ).toString() 
               + "\nCaught: "+root.getNumCaught( ) + "\n" ); 
            printPokeTree(root.getRChild());
         }   
      }//exception thrown.
      catch (NullPointerException nfe) {
      }
   }

   /** Pre-order transversal print method. */
   
   public void preorderPokeTree() {
      this.preorderPokeTree(root);
   }
   
   /** Pre-order print method.
   * @param root  The root of the binary tree.
   */
   private void preorderPokeTree(PokeNode root) {
      if(root != null){
         System.out.println("  " + root.getPokemon( ).toString() 
            + "\nCaught: "+root.getNumCaught( ) );
         preorderPokeTree(root.getLChild());
         preorderPokeTree(root.getRChild());
      }
   }
   
/** Driver Test **/

   /** Driver code to test class.
   * @param args are not used
   */
   public static void main(String[] args) {
      PokeTree<Pokemon> tree = new PokeTree<Pokemon>();
      System.out.println("Test add() method:");
   
      tree.add(new Squirtle());
      tree.add(new Charmander());
      tree.add(new Bulbasaur());
      tree.add(new Venusaur());
      tree.add(new Blastoise());
      tree.add(new Charizard());
      Pokemon m = new Squirtle("Miku");
      tree.add(m);
      tree.add(new Charmander("Mika"));
      Pokemon k = new Squirtle("Miki");
      tree.add(k);
   
      System.out.println( " Test printPokeTree() method: ");
      tree.printPokeTree();
   
      System.out.println(" Test preorderPokeTree() method: ");
      tree.preorderPokeTree();
      
      System.out.println(" Test get() method: ");
      
      System.out.println(tree.get(k).toString());
      Pokemon a = new Charmeleon();
      
      System.out.println(" Test remove() method: ");
      tree.remove(m);
      tree.printPokeTree();
      
      
      
      
   } //end main.

} //end class.

 