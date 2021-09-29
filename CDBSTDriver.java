

//Driver class

public class CDBSTDriver{
   public static void main(String[ ] arg) throws Exception{
      final int SIZE = 6;
      CDBST tree = new CDBST( );
      CD cd1 = null;
      CD [ ] cdarr = new CD[SIZE];
      cdarr[0] = new CD ("Coldplay", "Album24", 24.99, 5);
      cdarr[1]  = new CD ("Maroon 5", "Album2", 2.99, 5);
      cdarr[2]  = new CD ("Ariana Grande", "Album43", 43.99, 5);
      cdarr[3]  = new CD ("Madonna", "Album6", 6.99, 5);
      cdarr[4]  = new CD ("Bon Jovi", "Album55", 55.12, 5);
      cdarr[5]  = new CD ("Bon Jovi", "Album55", 55.12, 5);
      for(int i = 0; i< cdarr.length; i++){
         if(tree.addNode(cdarr[i])) {
            System.out.println("added");
            System.out.println(cdarr[i].toString( ));
            System.out.println("---------\n");
         }
         else{
            System.out.println("duplicate");
         }
      }
      System.out.println("\n==========\n");
      System.out.println("printing all CDs, inorder by price");
      tree.printBSTree( );
      
      
       System.out.println("\n======Find Albums=====");
        System.out.println("======+++++++=====\n");
      
      
      CD cd2 = new CD ("Rocker", "dont find me", 12.09, 2);
      if(tree.findNode(cd2)) {
         System.out.println("\nfound\n*****\n");
      }
      else{
         System.out.println(cd2.toString( ));
         System.out.println("\nnot found\n*****\n");
      }
      cd2 = new CD ("Madonna", "Album6", 6.99, 5);
      if(tree.findNode(cd2)) {
         System.out.println(cd2.toString( ));
         System.out.println("found\n====");
      }
      else{
         System.out.println(cd2.toString( ));
         System.out.println("not found\n====");
      }
   }
}