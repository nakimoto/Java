import java.util.*;
import java.util.ArrayList;
/**
* Pokemon arrayList.
* @author Nanami Kimoto
* @since 2/23/2019
*/
public class PokeArray {
   /**
    * Main method.
    * @param args not used.
    */
   public static void main(String[] args) {
   //scanner to collect pokemon names
   //main menu boolean
      Scanner userIn = new Scanner(System.in);
      String inString = new String("");
      boolean mainMenuLoop = false;
      
      //array list for pokemon 
      ArrayList<Pokemon> pokemonArray = new ArrayList<>();
     // pokemonArray.add(p);
      //pokemon.showPokemons(pokemonArray);
      int pokeArrayCounter = 0;
      
      //Loop until stop condition is given.
      while (!mainMenuLoop)
      {
         //Print menu to user.
         System.out.println("This is the Pokemon Creator Program.");
         System.out.println("Please choose an option from the menu.");
         System.out.println("Please enter the number of your choice: ");
         System.out.println("Option 1, Add a Pokemon");
         System.out.println("Option 2, Print all Pokemon");
         System.out.println("Option 0, Exit the program");
         System.out.println("\nWhat would you like to do?");
      
         //Read and store user input appropriately as inString.
         inString = userIn.nextLine();
         inString = inString.trim();
         
         //Switch begin
         switch(inString) {
         
            //option 0 for exiting the program
            case "0":
               mainMenuLoop = true;
               System.out.println("\nGood bye!");
               break;
            
            //option 1 for adding a pokemon
            case "1":
              makePokemon(pokemonArray);
              
               if (pokemonArray.size() > 6) {
               
                  pokemonArray.remove(6);
               }
               
               break;
            
            //option 2 for printing current pokemon list
               
              case "2":
               printArray(pokemonArray);
               break;
         
            //case defaults to incorrect entry
            default:
               System.out.print("\n Incorrect entry! Please try again!");
               break;
         }
      }
   } 
   
   //static method for makePokemon
    /**
    * makePokemon static Method.
    * @return p
    */
   public static Pokemon makePokemon(ArrayList<Pokemon>pokemonArray) {
      
      Scanner pokeIn = new Scanner(System.in);
      String pokeSpecies = "";
      String pokeName = "";
      String pokeNameConfirmation = "";
      Pokemon p = new Charmander();
      boolean pokemonChooseLoop = false;
      while (!pokemonChooseLoop) {
      
         //Specify the Pokemon's species.
         //split up by evolution type
         System.out.println("\nYou can add your Pokemon here! ");
         System.out.println("List of currently available Pokemon:\n");
         System.out.print("1 - Bulbasaur, 2 - Ivysaur, 3 - Venusaur,\n");
         System.out.print("4 - Charmander, 5 - Charmeleon, 6 - Charizard\n");
         System.out.print("7 - Squirtle, 8 - Wartortle, 9 - Blastoise\n  ");
         System.out.println("\nTo add a Pokemon, ");
         System.out.print("choose the corresponding number!");
         pokeSpecies = pokeIn.nextLine();
         
      
         //input selecetion to match pokemon
         if (pokeSpecies.equals("1") || pokeSpecies.equals("2") 
             || pokeSpecies.equals("3") || pokeSpecies.equals("4") 
             || pokeSpecies.equals("5") || pokeSpecies.equals("6") 
             || pokeSpecies.equals("7") || pokeSpecies.equals("8") 
             || pokeSpecies.equals("9"))
         { //loop
            pokemonChooseLoop = true;
         
         
         } else {
          //incorect entry, returns error message
            System.out.println("\n Incorrect entry!");
            System.out.print("Please try again!");
              
         }
      }
      
   

   //Pokemon name
      String nameChoice = new String("");
      boolean namePokemonLoop = false;
    
      while (!namePokemonLoop) {
      
         System.out.println("Would you like to name your Pokemon?");
         System.out.print("Please enter Y for yes and N for no.");
         //scanner for user choice name
         nameChoice = pokeIn.nextLine();
      
         //Switch begin
         switch(nameChoice) {
         
            //No cases for lowercase and uppercase possibility 
            case "N":
            case "n":
            
               namePokemonLoop = true;
               //switch on the pokespecies from above (list of pokemon possible)
               switch(pokeSpecies) {
               //each case for each new pokemon name
                  case "1":
                     p = new Bulbasaur();
                     pokemonArray.add(0, p);
                    
                     break;
                  
                  case "2":
                     p = new Ivysaur();
                     pokemonArray.add(0, p);
                     break;
                  
                  case "3":
                     p = new Venusaur();
                     pokemonArray.add(0, p);
                     break;
                  
                  case "4":
                     p = new Charmander();
                     pokemonArray.add(0, p);
                     break;
                  
                  case "5":
                     p = new Charmeleon();
                     pokemonArray.add(0, p);
                     break;
                  
                  case "6":
                     p = new Charizard();
                     pokemonArray.add(0, p);
                     break;
                  
                  case "7":
                     p = new Squirtle();
                     pokemonArray.add(0, p);
                     break;
                     
                  case "8":
                     p = new Wartortle();
                     pokemonArray.add(0, p);
                     break;
                  
                  case "9":
                     p = new Blastoise();
                     pokemonArray.add(0, p);
                     break;
                     //default to error message
                  default:
                     System.out.println("\n Incorrect entry!");
                     System.out.print("Please try again!");
                     break;
               
            
               
             } 
               
             //yes cases for lowercase and uppercase possibility 
            case "Y":
            case "y":
            
               
               //Ask for name, then confirm it.
               boolean nameConfirmationLoop = false;
               while (!nameConfirmationLoop) {
               
               
                  //User inputs the preferred Pokemon name.
                  System.out.print("What is the Pokemon's name?");
                  pokeName = pokeIn.nextLine();
               
                  //Ask user to confirm if the name is ok.
                  System.out.print("Your Pokemon's name is " + pokeName);
                  System.out.print("Is this correct?");
                  System.out.print("Please enter Y for yes and N for no.");
                  pokeNameConfirmation = pokeIn.nextLine();
               
                  //Switch for name confirmation  Y/N input.
                  switch(pokeNameConfirmation) {
                  
                     case "Y":
                     case "y":
                        nameConfirmationLoop = true;
                        namePokemonLoop = true;
                        switch(pokeSpecies) {
                        
                           case "1":
                              p = new Bulbasaur(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           case "2":
                              p = new Ivysaur(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           case "3":
                              p = new Venusaur(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           case "4":
                              p = new Charmander(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           case "5":
                              p = new Charmeleon(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           case "6":
                              p = new Charizard(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           case "7":
                              p = new Squirtle(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           case "8":
                              p = new Wartortle(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           case "9":
                              p = new Blastoise(pokeName);
                              pokemonArray.add(0, p);
                              break;
                           
                           default:
                              System.out.println("\n Incorrect entry!");
                              System.out.print("Please try again!");
                              break;
                        }
                        break;
                    
                      
                  }
                  
                  }
                  System.out.println("\nYour Pokemon creation was succesfull!");
                  System.out.print("Here is your Pokemon: \n");
                  System.out.println(p.toString() + "\n");
                  
              }
             
           }
           return p;
        }
        
       
        

     /**
   * Print pokemon arraylist.
   * @param showPokemons pokemon arraylist
   */ 
   
    public static void printArray(ArrayList<Pokemon> pokemonArray) {
    
 //       if (pokemonArray.size() == 0)
//        {
//           System.out.println("Your list is empty! No Pokemon found!");
//           System.out.println("You can make one by returning to the menu!");
//        }
//       else
     //{
        
          for (int i = 0; i < pokemonArray.size(); i++) {
          
          if (pokemonArray.get(i) != null) {
          System.out.println("Pokemon: " + (i + 1));
         
          
           System.out.println(pokemonArray.get(i).toString());
         }
         }
     // }
      
      }
   
}