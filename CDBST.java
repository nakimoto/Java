/*CDBST(implements given CDBSTI)
*@author Nanami Kimoto
*Use of override
*METHODS: addnode(boolean), findnode(boolean), print tree(recurseively) 
*tested with CDBST driver, no problems. 
*/

public class CDBST implements CDBSTI{

/****Instance Variables***/
  
   private BSTNode root;
  
/***constructor****/

   public CDBST(){//empty constructor
   
       root = null;
   }
   
/****Boolean add method***/

   @Override 
   public boolean addNode(CD cd){
   //check if null
       if(root == null){
       //insert root
           root = new BSTNode(cd);
           return true;
       }else{
           BSTNode node = new BSTNode(cd);//new node for cd 
           BSTNode pointer = root;//pointer
           //loop for comparing
           while(pointer != null){
               //returns false if cd is already in collection
               if(pointer.getCD().equals(cd))
                   return false;
               else if(pointer.getCD().compareTo(cd) < 0){ 
                   //check for empty right child
                   if(pointer.getRightChild() == null){
                       pointer.setRightChild(node);
                       return true;
                   }else 
                       pointer = pointer.getRightChild();
               }else{
                   //check for empty left child
                   if(pointer.getLeftChild() == null){
                       pointer.setLeftChild(node);
                       return true;
                   }else 
                       pointer = pointer.getLeftChild();
               }
           }
          //if cd is not inserted, return false 
           return false; 
       }
   }//close boolean add method
   
/***Boolean find method***/

   @Override
   public boolean findNode(CD cd){
       BSTNode pointer = root; //sets pointer to root
       //loop for finding CD
       while(pointer != null){
           if(pointer.getCD().equals(cd)) 
               return true;//returns true if current cd equals cd value
           else if(pointer.getCD().compareTo(cd) < 0) //otherwise search right child
               pointer = pointer.getRightChild();
           else //otherwise search left child
               pointer = pointer.getLeftChild();
       }
      //if cd not found, return false
       return false; 
   }//close boolean find method
   
/***Print tree method****/

   @Override
   public void printBSTree(BSTNode root){
      //check if null
       if(root != null){ 
       //call both left and right children, and root in order to print tree
           printBSTree(root.getLeftChild()); 
           System.out.println(root);//where cd info was stored
           printBSTree(root.getRightChild());
       }
   }//close first print method

   @Override
   public void printBSTree(){
       printBSTree(root);//recursively print
   }//close second print method
}//close class

