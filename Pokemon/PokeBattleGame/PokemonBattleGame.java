import java.util.*; // scanner

/**
* Pokemon PokemonBattleGame.
* @author Nanami Kimoto
* @since 3/8/2019
*/

public class PokemonBattleGame {
   /**
     * Main method.
     * @param args not used.
     */
     
     /** Constants for charge player 1. */
   private static int Charge1 = 0;
   /** Constant for charge player 2. */
   private static int Charge2 = 0;
     
     /**
     * Main method.
     * @param args not used.
     */
     
     
   public static void main(String[] args) {
   //user input
      Scanner gamerIn = new Scanner(System.in);
     
      //random
      Random rand = new Random();
      //declarations
      Pokemon p1 = new Charmander();
      Pokemon p2 = new Charizard();
      int playerTurn = rand.nextInt(2) + 1; //chooses random player
      boolean endGame = false;
      //first thing the player sees 
      System.out.println("Welcome to the Pokemon Battle Game!");
      System.out.println("Player 1, pick your pokemon!");
      p1 = makePokemon();
      System.out.println(p1.toString());
      System.out.println("Player 2, pick your pokemon!");
      p2 = makePokemon();
      System.out.println(p2.toString());
               
      
      System.out.println("First player will be randomly selected."); 
      if (playerTurn == 1) {
      //random choice and alternating players
         System.out.println("Player 1 has been chosen to go first!");
         
         while (!endGame) {
            if (p1.getHP() == 0) {
               System.out.println("Game over! Player 1 has fainted!");
               System.out.println("Player 2 wins!");
               endGame = true;
            } else if (p1.getHP() > 0 && p2.getHP() > 0) {
                    
               System.out.println("Player 1's turn!");
               Gameplay(p1, Charge1, p2, Charge2, playerTurn);
               playerTurn = 2;
            }
          //player2
            if (p2.getHP() == 0) {
               System.out.println("Game over! Player 2 has fainted!");
               System.out.println("Player 1 wins!");
               endGame = true;
            } else if (p2.getHP() > 0 && p1.getHP() > 0) {
                    
               System.out.println("Player 2's turn!");
               Gameplay(p2, Charge2, p1, Charge1, playerTurn);
               playerTurn = 1; //alternate turns
            }
         }
          
      } else {
         System.out.println("Player 2 has been chosen to go first!");
           
            
          //player2
           
         while (!endGame) {
            if (p2.getHP() == 0) {
               System.out.println("Game over! Player 2 has fainted!");
               System.out.println("Player 1 wins!");
               endGame = true;
            } else if (p2.getHP() > 0 && p1.getHP() > 0) {
                    
               System.out.println("Player 2's turn!");
               Gameplay(p2, Charge2, p1, Charge1, playerTurn);
               playerTurn = 1; //alternate turns
            }
          
            if  (p1.getHP() == 0) {
               System.out.println("Game over! Player 1 has fainted!");
               System.out.println("Player 2 wins!");
               endGame = true;
            } else if (p1.getHP() > 0 && p2.getHP() > 0) {
                    
               System.out.println("Player 1's turn!");
               Gameplay(p1, Charge1, p2, Charge2, playerTurn);
               playerTurn = 2; //alternate turns
            
            
            }
         } 
      }
        
   }   
        
      
       
    /**
    * makePokemon static Method.
    * @return p
    */
    
   public static Pokemon makePokemon() {
      
      Scanner pokeIn = new Scanner(System.in);
      String pokeSpecies = "";
      String pokeNameConfirmation = "";
      Pokemon p = new Charmander();
      
      boolean endLoop = false;
      
      while (!endLoop) {
      
         
         //menu of pokemon
         System.out.println("List of currently available Pokemon:\n");
         System.out.print("1 - Bulbasaur, 2 - Ivysaur, 3 - Venusaur,\n");
         System.out.print("4 - Charmander, 5 - Charmeleon, 6 - Charizard\n");
         System.out.print("7 - Squirtle, 8 - Wartortle, 9 - Blastoise\n  ");
         
         System.out.print("choose the corresponding number!\n");
         pokeSpecies = pokeIn.nextLine();
      
      
         switch(pokeSpecies) {
               
            case "1":
               p = new Bulbasaur();
                    
               System.out.print("You chose Bulbasaur!\n");
               endLoop = true;
               break;
                  
            case "2":
               p = new Ivysaur();
               endLoop = true;
               System.out.print("You chose Ivysaur!\n");
               break;
                  
            case "3":
               p = new Venusaur();
               endLoop = true;
               System.out.print("You chose Venusaur!\n");
               break;
                  
            case "4":
               p = new Charmander();
               endLoop = true;
               System.out.print("You chose Charmander!\n");
               break;
                  
            case "5":
               p = new Charmeleon();
               endLoop = true;
               System.out.print("You chose Charmeleon!\n");
               break;
                  
            case "6":
               p = new Charizard();
               endLoop = true;
               System.out.print("You chose Charizard!\n");
               break;
                  
            case "7":
               p = new Squirtle();
               endLoop = true;
               System.out.print("You chose Squirtle!\n");
               break;
                     
            case "8":
               p = new Wartortle();
               System.out.print("You chose Wartortle!\n");
               endLoop = true;
               break;
                  
            case "9":
               p = new Blastoise();
               endLoop = true;
               System.out.print("You chose Blastoise!\n");
               break;
                     //default to error message
            default:
               System.out.println("\n Incorrect entry!\n");
               System.out.print("Please try again!");
               break;
               
            
               
         } //switch close
             
      } //while close
      return p;      
   } //makepokemon method close
           
         
         
  /**
     * gameplay method.
     * @param Attacker player 1
     * @param Defender player 2
     * @ch1 charge for player 1
     * @ch2 charge for player 2
     * @coin1 int coin for random
     */
         
   public static void Gameplay(Pokemon Attacker, int charge1,
       Pokemon Defender, int charge2, int coin1) { 
      
      Scanner userIn = new Scanner(System.in);
      String userChoice = "";
      boolean choice = false;
         
      while (!choice) {
         
         System.out.println("There are three options: ");
         System.out.println("1 for Fast Attack "  
             + " 2 for Special Attack, 3 for pass");
         System.out.println("Please enter a number to choose an option\n");
         userChoice = userIn.nextLine();
            
         switch(userChoice) {
            
            case "1":
               Attacker.chooseFastAttack();
               System.out.println(Attacker.
                   performFastAttack(Defender));
               System.out.println("Defending pokemon has " 
                   + Defender.getHP() + "hp left!\n");
               choice = true;
                     
               break;
            case "2":
               Attacker.chooseSpecialAttack();  
               if (coin1 == 1) {
                  if (Charge1 >= 3) {
                     System.out.println(Attacker.
                         performSpecialAttack(Defender));
                     Charge1 = Charge1 - 3;
                     System.out.println("Defending pokemon has " 
                           + Defender.getHP() + "hp left!\n");
                     choice = true;
                  } else {
                     System.out.println("You need " + (3 - Charge1) 
                          + "more charges to use this attack!\n");
                  }
                  
                  
               } else { //player 2 turn
                  if (Charge2 >= 3) {
                     System.out.println(Attacker.
                         performSpecialAttack(Defender));
                     Charge2 = Charge2 - 3;
                     System.out.println("Defending pokemon has " 
                          + Defender.getHP() + "hp left!\n");
                     choice = true;
                  } else {
                     System.out.println("You need " + (3 - Charge2) 
                          + "more charges to use this attack!\n");
                  }
               
               
               }
            
               break;
          
            
            case "3":
               if (coin1 == 1) {
                  System.out.println("Charging up!");
                  Charge1++;
            
               } else { //player 2
                  
                  System.out.println("Charging up!");
                  Charge2++;
               }
            
               choice = true;
            
               break;
          
            
            default:
               System.out.println("\n Incorrect entry!\n");
               System.out.print("Please try again!");
               break;
                     
                     
         } //switch close
                  
      } //while close
                
   } //gameplay method close
               
} //main close
            
      
         
         
